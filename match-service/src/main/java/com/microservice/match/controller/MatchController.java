package com.microservice.match.controller;

import com.microservice.match.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/matches")
@RequiredArgsConstructor
public class MatchController {

    Logger LOGGER = LoggerFactory.getLogger(MatchController.class);

    private final MatchService matchService;

    @PostMapping("/generate/{serverId}/{amountOfPlayers}")
    public ResponseEntity<String> generateMatch(@PathVariable String serverId, @PathVariable int amountOfPlayers) {
        try {
            LOGGER.info("Received request on generating match data on {} for {} players", serverId, amountOfPlayers);
            matchService.generateMatchResult(serverId, amountOfPlayers);
        } catch (Exception e) {
            LOGGER.error("Error occurs when generating match results {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(String.format("Match result generated for the server: %s with %d players.", serverId, amountOfPlayers));
    }
}
