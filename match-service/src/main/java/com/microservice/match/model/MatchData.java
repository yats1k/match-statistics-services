package com.microservice.match.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchData {

    private String matchId;
    private String serverId;
    private String timestamp;
    private List<PlayerData> players;

    public boolean hasTimestamp(String timestamp) {
        return Optional.ofNullable(timestamp).filter( p -> p.equals(getTimestamp())).isPresent();
    }

}
