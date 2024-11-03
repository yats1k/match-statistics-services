package com.microservice.match.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.match.model.MatchData;
import org.apache.kafka.common.serialization.Serializer;

public class MatchDataSerializer implements Serializer<MatchData> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String topic, MatchData matchData) {
        try {
            return objectMapper.writeValueAsBytes(matchData);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializing MatchData", e);
        }
    }

}
