package com.inter6.example.api;

import com.inter6.example.response.HealthCheck;
import com.inter6.example.service.HealthService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;

@RunWith(PowerMockRunner.class)
public class HealthApiTest {

    @InjectMocks
    private HealthApi healthApi;

    @Mock
    private HealthService healthService;

    @Test
    public void health_200() throws Exception {
        HealthCheck healthCheck = HealthCheck.builder()
                .timestamp(new Date())
                .uptime(10_000L)
                .build();

        Mockito.when(healthService.check())
                .thenReturn(healthCheck);

        ResponseEntity<Object> result = healthApi.health();
        Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assert.assertEquals(healthCheck, result.getBody());
    }

    @Test
    public void health_500() throws Exception {
        Mockito.when(healthService.check())
                .thenThrow(new RuntimeException("test"));

        ResponseEntity<Object> result = healthApi.health();
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
    }
}
