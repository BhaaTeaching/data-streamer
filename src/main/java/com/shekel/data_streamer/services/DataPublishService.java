package com.shekel.data_streamer.services;

import com.shekel.data_streamer.models.SensorData;
import com.shekel.data_streamer.repository.SensorDataRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DataPublishService {
    private final SensorDataRepository sensorDataRepository;
    private final KafkaTemplate<String, SensorData> kafkaTemplate;

    @Transactional
    public void saveAndPublishData(SensorData sensorData) {
        log.info("saveAndPublishData started");
        SensorData savedSensorData = sensorDataRepository.save(sensorData);
        kafkaTemplate.send("uart.sim.data", savedSensorData);
    }
}
