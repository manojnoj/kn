package com.example.kn.controller;

import java.time.Instant;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/")
    public Map<String, Object> root() {
        return Map.of(
            "status", "ok",
            "timestamp", Instant.now().toString()
        );
    }

    @GetMapping("/health")
    public Map<String, Object> health() {
        return Map.of("status", "healthy");
    }

    @GetMapping("/api/secure")
    public Map<String, Object> secure(@AuthenticationPrincipal Jwt jwt) {
        return Map.of(
            "message", "Authenticated request",
            "subject", jwt.getSubject(),
            "issuer", jwt.getIssuer(),
            "claims", jwt.getClaims()
        );
    }
}
