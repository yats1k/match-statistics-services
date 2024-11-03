package com.microservice.statistics.service.impl;

import com.microservice.statistics.model.MatchData;
import com.microservice.statistics.model.PlayerData;
import com.microservice.statistics.model.PlayerStats;
import com.microservice.statistics.model.ServerStats;
import com.microservice.statistics.service.StatsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class StatsServiceImpl implements StatsService {

    Logger LOGGER = LoggerFactory.getLogger(StatsServiceImpl.class);

    public static final String MATCH_RESULTS_TOPIC_NAME = "match-results";

    private final Map<String, ServerStats> serverStats = new ConcurrentHashMap<>();
    private final Map<String, PlayerStats> playerStats = new ConcurrentHashMap<>();
    private final List<MatchData> recentMatches = Collections.synchronizedList(new ArrayList<>());

    @Override
    @KafkaListener(topics = MATCH_RESULTS_TOPIC_NAME)
    public void processMatchData(MatchData data) {
        LOGGER.info("Received match data: {}", data);
        serverStats.computeIfAbsent(data.getServerId(), ServerStats::new).addMatch(data);
        for (PlayerData player : data.getPlayers()) {
            playerStats.computeIfAbsent(player.getName(), PlayerStats::new).addStats(player);
        }
        recentMatches.add(data);
        LOGGER.info("Updated server and player stats for server: {}", data.getServerId());
    }

    @Override
    public ServerStats getServerInfo(String serverId) {
        return serverStats.getOrDefault(serverId, new ServerStats(serverId));
    }

    @Override
    public List<MatchData> getServerMatches(String serverId, String timestamp) {
        return serverStats.getOrDefault(serverId, new ServerStats(serverId)).getMatchesByTimestamp(timestamp);
    }

    @Override
    public Map<String, ServerStats> getAllServersInfo() {
        return serverStats;
    }

    @Override
    public PlayerStats getPlayerStats(String name) {
        return playerStats.getOrDefault(name, new PlayerStats(name));
    }

    @Override
    public List<MatchData> getRecentMatches(int count) {
        return recentMatches.subList(Math.max(recentMatches.size() - count, 0), recentMatches.size());
    }

    @Override
    public List<PlayerStats> getBestPlayers(int count) {
        return playerStats.values().stream()
                .sorted(Comparator.comparingInt(PlayerStats::getKills).reversed())
                .limit(count)
                .toList();
    }

    @Override
    public List<ServerStats> getPopularServers(int count) {
        return serverStats.values().stream()
                .sorted(Comparator.comparingInt(ServerStats::getTotalMatches).reversed())
                .limit(count)
                .toList();
    }
}
