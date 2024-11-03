package com.microservice.match.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix="match")
public class MatchProperties {

    private int playersAmount;
    private int killsAmountMax;
    private int deathAmountMax;
    private int assistsAmountMax;

}
