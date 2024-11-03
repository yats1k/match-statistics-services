package com.microservice.statistics.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerData {

    private String name;
    private int kills;
    private int deaths;
    private int assists;
    private boolean won;

    public PlayerData(String name) {
        this.name = name;
    }

    protected void incByData(PlayerData playerData) {
        kills += playerData.getKills();
        deaths += playerData.getDeaths();
        assists += playerData.getAssists();
    }

}