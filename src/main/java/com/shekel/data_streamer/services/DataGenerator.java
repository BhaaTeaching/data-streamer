package com.shekel.data_streamer.services;

import com.shekel.data_streamer.mapper.DataStreamerMapper;
import com.shekel.data_streamer.models.SensorData;
import com.shekel.data_streamer.repository.SensorDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class DataGenerator {

    private final DataStreamerMapper dataStreamerMapper;
    private final DataPublishService dataPublishService;

    public void generate() {
        Random random = new Random();

        double temperature = Math.round(50 * random.nextDouble() * 10.0) / 10.0;
        double humidity = Math.round((20 + (80 * random.nextDouble())) * 10.0) / 10.0;

        log.info("Generated random data - Temperature: {}, Humidity: {}", temperature, humidity);

        SensorData sensorData = dataStreamerMapper.toSensorData(temperature, humidity);

        if (sensorData != null) {
            log.info("Mapped SensorData: {}", sensorData);
            dataPublishService.saveAndPublishData(sensorData);
            log.info("Sensor data successfully saved and published.");
        } else {
            log.warn("Failed to map SensorData. Generated values might be invalid.");
        }
    }

}
