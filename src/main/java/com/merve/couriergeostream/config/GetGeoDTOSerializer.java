package com.merve.couriergeostream.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.merve.couriergeostream.dto.GetGeoDTO;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class GetGeoDTOSerializer implements Serializer<GetGeoDTO> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, GetGeoDTO data) {
        if (data == null) {
            return null;
        }

        try {

            return objectMapper.writeValueAsBytes(data);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializing GetGeoDTO", e);
        }
    }

    @Override
    public void close() {

    }
}
