package com.inter6.example.response;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
public class HealthCheck {
    private Date timestamp;
    private Long uptime;
}
