package com.microservice.statistics.controller;

import com.microservice.statistics.model.MatchData;
import com.microservice.statistics.model.PlayerStats;
import com.microservice.statistics.model.ServerStats;
import com.microservice.statistics.service.StatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/servers")
@RequiredArgsConstructor
public class StatisticsController {

    private final StatsService statsService;

    @GetMapping("/{serverId}/info")
    public ServerStats getServerInfo(@PathVariable String serverId) {
        return statsService.getServerInfo(serverId);
    }

    @GetMapping("/{serverId}/matches/{timestamp}")
    public List<MatchData> getServerMatches(@PathVariable String serverId, @PathVariable String timestamp) {
        return statsService.getServerMatches(serverId, timestamp);
    }

    @GetMapping("/info")
    public Map<String, ServerStats> getAllServersInfo() {
        return statsService.getAllServersInfo();
    }

    @GetMapping("/{serverId}/stats")
    public Map<String, Integer> getServerStats(@PathVariable String serverId) {
        return statsService.getServerInfo(serverId).getStats();
    }

    @GetMapping("/players/{name}/stats")
    public PlayerStats getPlayerStats(@PathVariable String name) {
        return statsService.getPlayerStats(name);
    }

    @GetMapping("/reports/recent-matches")
    public List<MatchData> getRecentMatches(@RequestParam(defaultValue = "5") int count) {
        return statsService.getRecentMatches(count);
    }

    @GetMapping("/reports/best-players")
    public List<PlayerStats> getBestPlayers(@RequestParam(defaultValue = "10") int count) {
        return statsService.getBestPlayers(count);
    }

    @GetMapping("/reports/popular-servers")
    public List<ServerStats> getPopularServers(@RequestParam(defaultValue = "10") int count) {
        return statsService.getPopularServers(count);
    }
}
