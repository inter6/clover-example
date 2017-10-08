package com.inter6.example.service;

import com.inter6.example.response.HealthCheck;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.ResponseEntity;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
public class HealthServiceTest {

    @InjectMocks
    private HealthService healthService;

    @Test
    public void check() throws Exception {
        HealthCheck check = healthService.check();

        Assert.assertNotNull(check);
    }
}
