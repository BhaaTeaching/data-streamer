package com.shekel.data_streamer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SensorDataScheduler {
    @Value("${runtime}")
    private int runtime;

    private final DataGenerator dataGenerator;
    @Scheduled(fixedRateString = "#{${runtime}}")
    public void fetchDataFromSensor() {
        dataGenerator.generate();
    }
}
