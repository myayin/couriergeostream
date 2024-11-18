package com.merve.couriergeostream.queue;

import com.merve.couriergeostream.dto.CourierDto;
import com.merve.couriergeostream.dto.GetGeoDTO;
import com.merve.couriergeostream.dto.StoreDto;
import com.merve.couriergeostream.entity.CourierStoreEntrance;
import com.merve.couriergeostream.exception.CourierGeoStreamException;
import com.merve.couriergeostream.service.CourierService;
import com.merve.couriergeostream.service.CourierStoreEntranceService;
import com.merve.couriergeostream.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.locationtech.jts.geom.Point;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static com.merve.couriergeostream.constants.Constants.Kafka.DISTANCE_TRACKER_TOPIC_NAME;
import static com.merve.couriergeostream.constants.Constants.Kafka.ENTRANCE_TRACKER_CONSUMER_GROUP_ID;
import static com.merve.couriergeostream.util.PointUtil.createPoint;

@Service
@RequiredArgsConstructor
public class EntranceTrackerConsumer {

    private final CourierService courierService;

    private final StoreService storeService;

    private final CourierStoreEntranceService courierStoreEntranceService;


    @KafkaListener(topics = DISTANCE_TRACKER_TOPIC_NAME, groupId = ENTRANCE_TRACKER_CONSUMER_GROUP_ID, containerFactory = "kafkaListenerContainerFactory")
    public void onMessage(ConsumerRecord<String, GetGeoDTO> consumerRecord) throws CourierGeoStreamException {
        GetGeoDTO payload = consumerRecord.value();
        processLocation(payload);
    }

    private void processLocation(GetGeoDTO payload) throws CourierGeoStreamException {
        CourierDto courierDto = courierService.findById(payload.getCourierId());
        Point location = createPoint(payload.getCoordinateDTO());
        double radius = 100;

        List<StoreDto> storeDtos = findNearbyStores(courierDto, location, radius);
        for (StoreDto storeDto : storeDtos) {
            int thresholdTime = 1;
            CourierStoreEntrance courierStoreEntrance = getEntranceInThresholdTime(payload, storeDto, thresholdTime);
            if (!isEntranceExistInThresholdTime(courierStoreEntrance)) {
                saveEntrance(courierDto, location, storeDto);
            }
        }
    }

    private void saveEntrance(CourierDto courierDto, Point location, StoreDto storeDto) {
        CourierStoreEntrance courierStoreEntrance;
        courierStoreEntrance = CourierStoreEntrance.builder().courierId(courierDto.getId()).storeId(storeDto.getId()).date(new Date().toInstant()).location(location).build();
        courierStoreEntranceService.save(courierStoreEntrance);
    }

    private static boolean isEntranceExistInThresholdTime(CourierStoreEntrance courierStoreEntrance) {
        return Objects.nonNull(courierStoreEntrance);
    }

    private CourierStoreEntrance getEntranceInThresholdTime(GetGeoDTO payload, StoreDto storeDto, int thresholdTime) {
        return courierStoreEntranceService.findByCourierIdAndStoreIdAndDateAfter(payload.getCourierId(), storeDto.getId(), new Date().toInstant().plus(Duration.ofMinutes(thresholdTime)));
    }

    private List<StoreDto> findNearbyStores(CourierDto courierDto, Point location, double radius) {
        return storeService.findByCityAndDistinct(courierDto.getCity(), courierDto.getDistinct(), location, radius);
    }
}
