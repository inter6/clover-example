package com.inter6.example.service;

import com.inter6.example.response.HealthCheck;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.util.Date;

@Service
public class HealthService {

    public HealthCheck check() {
        return HealthCheck.builder()
                .timestamp(new Date())
                .uptime(ManagementFactory.getRuntimeMXBean().getUptime())
                .build();
    }
}
