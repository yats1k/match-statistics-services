package com.microservice.statistics.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerStats extends PlayerData {

    private int matches;

    public PlayerStats(String name) {
        super(name);
    }

    public void addStats(PlayerData player) {
        if (getName().equals(player.getName())) {
            incByData(player);
            matches++;
        }
    }
}
