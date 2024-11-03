package com.microservice.statistics.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServerStats {

    private String serverId;
    private List<MatchData> matches = new ArrayList<>();
    private int totalMatches;

    public ServerStats(String serverId) {
        this.serverId = serverId;
    }

    public void addMatch(MatchData match) {
        matches.add(match);
        totalMatches++;
    }

    public List<MatchData> getMatchesByTimestamp(String timestamp) {
        return matches.stream()
                .filter(m -> m.getTimestamp() != null && m.getTimestamp().equals(timestamp))
                .toList();
    }

    public Map<String, Integer> getStats() {
        Map<String, Integer> stats = new HashMap<>();
        stats.put("totalMatches", totalMatches);

        // Collect unique player names from all matches
        Set<String> uniquePlayers = matches.stream()
                .flatMap(match -> match.getPlayers().stream()
                        .map(PlayerData::getName))  // Assuming PlayerData has a getName() method
                .collect(Collectors.toSet());

        stats.put("uniquePlayers", uniquePlayers.size());

        return stats;
    }
}
