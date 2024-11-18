package com.merve.couriergeostream.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.merve.couriergeostream.dto.GetGeoDTO;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class GetGeoDTODeserializer implements Deserializer<GetGeoDTO> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public GetGeoDTO deserialize(String topic, byte[] data) {
        if (data == null) {
            return null;
        }

        try {

            return objectMapper.readValue(data, GetGeoDTO.class);
        } catch (Exception e) {

            throw new RuntimeException("Error deserializing GetGeoDTO", e);
        }
    }

    @Override
    public void close() {

    }
}
