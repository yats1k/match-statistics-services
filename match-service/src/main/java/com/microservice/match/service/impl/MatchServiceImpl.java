package com.microservice.match.service.impl;

import com.microservice.match.model.MatchData;
import com.microservice.match.service.MatchService;
import com.microservice.match.util.MatchGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MatchServiceImpl implements MatchService {

    Logger LOGGER = LoggerFactory.getLogger(MatchServiceImpl.class);

    public static final String MATCH_RESULTS_TOPIC_NAME = "match-results";

    private final KafkaTemplate<String, MatchData> kafkaTemplate;
    private final MatchGenerator matchGenerator;

    @Autowired
    public MatchServiceImpl(KafkaTemplate<String, MatchData> kafkaTemplate, MatchGenerator matchGenerator) {
        this.kafkaTemplate = kafkaTemplate;
        this.matchGenerator = matchGenerator;
    }

    @Override
    public void generateMatchResult(String serverId, int amountOfPlayers) {
        MatchData matchData = matchGenerator.generateMatch(serverId, amountOfPlayers);
        LOGGER.info("Generated match data on server {} for {} players", serverId, amountOfPlayers);
        // Send data to Kafka
        kafkaTemplate.send(MATCH_RESULTS_TOPIC_NAME, serverId, matchData);
        LOGGER.info("Match data has been sent to topic `{}` of Kafka", MATCH_RESULTS_TOPIC_NAME);
    }
}
