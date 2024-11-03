package com.microservice.statistics.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.statistics.model.MatchData;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class MatchDataDeserializer implements Deserializer<MatchData> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public MatchData deserialize(String s, byte[] bytes) {
        if (bytes == null) {
            return null; // Handle null data
        }
        try {
            return objectMapper.readValue(bytes, MatchData.class);
        } catch (IOException e) {
            throw new RuntimeException("Error deserializing MatchData", e);
        }
    }

}
