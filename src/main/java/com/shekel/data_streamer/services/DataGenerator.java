package com.shekel.data_streamer.services;

import com.shekel.data_streamer.models.SensorData;
import com.shekel.data_streamer.repository.SensorDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class DataGenerator {
    private final SensorDataRepository sensorDataRepository;
    private final KafkaTemplate<String, SensorData> kafkaTemplate;

    public void generate() {
        Random random = new Random();
        double temperature = Math.round(50 * random.nextDouble() * 10.0) / 10.0;
        double humidity = Math.round((20 + (80 * random.nextDouble())) * 10.0) / 10.0;
        SensorData sensorData = SensorData.builder().
                temperature(temperature)
                .humidity(humidity)
                .build();

        SensorData savedSensorData = sensorDataRepository.save(sensorData);
        kafkaTemplate.send("uart.sim.data", savedSensorData);

    }

}
