package com.microservice.match;

import com.microservice.match.model.MatchData;
import com.microservice.match.service.MatchService;
import com.microservice.match.service.impl.MatchServiceImpl;
import com.microservice.match.util.MatchGenerator;
import com.microservice.match.util.MatchProperties;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class MatchServiceTest {

    private final String TEST_TOPIC = "match_results_topic";

    @Autowired
    private MatchProperties testProperties;

    @Mock
    private KafkaTemplate<String, MatchData> kafkaTemplate;

    @Mock
    MatchGenerator matchGenerator;

    @Mock
    MatchData matchData;

    MatchService matchService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        matchService = new MatchServiceImpl(kafkaTemplate, matchGenerator);
    }

    @Test
    public void testGenerateAndSendMatchData() {
        // Given
        String serverId = "server1"; // Example server ID
        when(matchGenerator.generateMatch(Mockito.eq(serverId), Mockito.anyInt())).thenReturn(matchData);

        // When
        assert testProperties.getPlayersAmount() > 0 : "Players amount shouldn't greater than 0";
        matchService.generateMatchResult(serverId, testProperties.getPlayersAmount());

        // Then
        // Verify that the send method was called with the correct parameters
        verify(kafkaTemplate, times(1)).send(Mockito.anyString(), Mockito.eq(serverId),
                Mockito.any(MatchData.class));
    }
}
