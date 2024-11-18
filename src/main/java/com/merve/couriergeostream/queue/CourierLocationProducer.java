package com.merve.couriergeostream.queue;

import com.merve.couriergeostream.dto.GetGeoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.merve.couriergeostream.constants.Constants.Kafka.DISTANCE_TRACKER_TOPIC_NAME;

@Service
@RequiredArgsConstructor
public class CourierLocationProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(GetGeoDTO request) {
        String key = request.getCourierId().toString();
        kafkaTemplate.send(DISTANCE_TRACKER_TOPIC_NAME, key, request);
    }
}
