package com.shekel.data_streamer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SensorDataScheduler {
    private final DataGenerator dataGenerator;
    @Scheduled(fixedRate = 2000)
    public void fetchDataFromSensor() {
        dataGenerator.generate();
    }
}
