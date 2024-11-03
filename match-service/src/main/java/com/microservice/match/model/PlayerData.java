package com.microservice.match.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerData {

    private String name;
    private int kills;
    private int deaths;
    private int assists;
    private boolean won;

}
