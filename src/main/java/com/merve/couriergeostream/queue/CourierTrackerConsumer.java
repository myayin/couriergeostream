package com.merve.couriergeostream.queue;

import com.merve.couriergeostream.dto.CourierDto;
import com.merve.couriergeostream.dto.GetGeoDTO;
import com.merve.couriergeostream.entity.Courier;
import com.merve.couriergeostream.entity.CourierLocation;
import com.merve.couriergeostream.exception.CourierGeoStreamException;
import com.merve.couriergeostream.mapper.CourierMapper;
import com.merve.couriergeostream.service.CourierLocationService;
import com.merve.couriergeostream.service.CourierService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.locationtech.jts.geom.Point;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;

import static com.merve.couriergeostream.constants.Constants.Kafka.COURIER_TRACKER_CONSUMER_GROUP_ID;
import static com.merve.couriergeostream.constants.Constants.Kafka.DISTANCE_TRACKER_TOPIC_NAME;
import static com.merve.couriergeostream.util.PointUtil.createPoint;

@Service
@RequiredArgsConstructor
public class CourierTrackerConsumer {

    private final CourierService courierService;

    private final CourierLocationService courierLocationService;

    @KafkaListener(topics = DISTANCE_TRACKER_TOPIC_NAME, groupId = COURIER_TRACKER_CONSUMER_GROUP_ID, containerFactory = "kafkaListenerContainerFactory")
    public void onMessage(ConsumerRecord<String, GetGeoDTO> consumerRecord) throws CourierGeoStreamException {
        GetGeoDTO payload = consumerRecord.value();
        CourierDto courierDto = courierService.findById(payload.getCourierId());
        Point location = createPoint(payload.getCoordinateDTO());

        CourierLocation courierLocation = new CourierLocation();
        courierLocation.setCourierId(courierDto.getId());
        courierLocation.setLocation(location);
        courierLocationService.save(courierLocation);
        double distance = 0;
        if (Objects.nonNull(courierDto.getLastLocation())) {
            distance = courierDto.getLastLocation().distance(location);
        }

        courierDto.setTotalTravelDistance(courierDto.getTotalTravelDistance().add(BigDecimal.valueOf(distance)));
        courierDto.setLastLocation(location);
        Courier courier = CourierMapper.INSTANCE.toEntity(courierDto);

        courierService.save(courier);
    }
}
