package com.microservice.match.util;

import com.microservice.match.model.MatchData;
import com.microservice.match.model.PlayerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class MatchGenerator {

    // TODO: This somehow doesn't work, as workaround MatchProperty class used
//    @Value("${match.kills-amount-max")
//    private int KILLS_AMOUNT_MAX;
//
//    @Value("${match.death-amount-max}")
//    private int DEATH_AMOUNT_MAX;
//
//    @Value("${match.assists-amount-max}")
//    private int ASSISTS_AMOUNT_MAX;

    @Autowired
    private MatchProperties matchProperties;

    private final Random random = new Random();
    private final AtomicInteger matchCount = new AtomicInteger(0);

    public MatchData generateMatch(String serverId, int amountOfPlayers) {
        List<String> playerNames = IntStream.range(0, amountOfPlayers)
                .mapToObj(i -> getPlayerName()).toList();
        return generateMatch(serverId, playerNames);
    }

    public MatchData generateMatch(String serverId, List<String> playerNames) {
        String matchId = getMatchId(matchCount.incrementAndGet());
        String timestamp = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        List<PlayerData> playerStats = generatePlayers(playerNames);

        return new MatchData(matchId, serverId, timestamp, playerStats);
    }

    private List<PlayerData> generatePlayers(List<String> playerNames) {
        return Optional.ofNullable(playerNames)
                .stream()
                .flatMap(List::stream)
                .map(name -> new PlayerData(
                        name,
                        random.nextInt(matchProperties.getKillsAmountMax()),
                        random.nextInt(matchProperties.getDeathAmountMax()),
                        random.nextInt(matchProperties.getAssistsAmountMax()),
                        random.nextBoolean()))
                .collect(Collectors.toList());
    }

    private String getPlayerName() {
        return "Player" + (random.nextInt(100) + 1);
    }

    private String getMatchId(int i) {
        return String.format("%03d", i);
    }

}
