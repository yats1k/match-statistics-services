package com.microservice.statistics.service;

import com.microservice.statistics.model.MatchData;
import com.microservice.statistics.model.PlayerStats;
import com.microservice.statistics.model.ServerStats;

import java.util.List;
import java.util.Map;

public interface StatsService {

    void processMatchData(MatchData data);

    ServerStats getServerInfo(String serverId);

    List<MatchData> getServerMatches(String serverId, String timestamp);

    Map<String, ServerStats> getAllServersInfo();

    PlayerStats getPlayerStats(String name);

    List<MatchData> getRecentMatches(int count);

    List<PlayerStats> getBestPlayers(int count);

    List<ServerStats> getPopularServers(int count);
}
