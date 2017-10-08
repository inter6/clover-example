package com.inter6.example.api;

import com.inter6.example.response.ErrorResponse;
import com.inter6.example.response.HealthCheck;
import com.inter6.example.service.HealthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Slf4j
public class HealthApi {

    private final HealthService healthService;

    @Autowired
    public HealthApi(HealthService healthService) {
        this.healthService = healthService;
    }

    @GetMapping(path = "health")
    public ResponseEntity<Object> health() {
        try {
            HealthCheck healthCheck = healthService.check();
            log.debug("{}", healthCheck);
            return ResponseEntity.<HealthCheck>ok()
                    .body(healthCheck);
        } catch (Throwable e) {
            log.error("", e);
            return ResponseEntity.<ErrorResponse>status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ErrorResponse.builder()
                            .message(e.getMessage())
                            .build());
        }
    }
}
