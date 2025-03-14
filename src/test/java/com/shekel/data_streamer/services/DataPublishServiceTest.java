package com.shekel.data_streamer.services;

import com.shekel.data_streamer.models.SensorData;
import com.shekel.data_streamer.repository.SensorDataRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.kafka.core.KafkaTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DataPublishServiceTest {
    @Mock
    private SensorDataRepository sensorDataRepository;

    @Mock
    private KafkaTemplate<String, SensorData> kafkaTemplate;

    @InjectMocks
    private DataPublishService dataPublishService;

    @Test
    void saveAndPublishData_ShouldSaveDataAndPublishToKafka() {
        // Arrange
        SensorData mockSensorData = SensorData.builder()
                .id(1L)
                .temperature(25.5)
                .humidity(60.0)
                .build();

        when(sensorDataRepository.save(any(SensorData.class))).thenReturn(mockSensorData);
        dataPublishService.saveAndPublishData(mockSensorData);
        verify(sensorDataRepository, times(1)).save(mockSensorData);
        verify(kafkaTemplate, times(1)).send(eq("uart.sim.data"), eq(mockSensorData));
    }

    @Test
    void saveAndPublishData_ShouldHandleExceptionsGracefully() {
        SensorData mockSensorData = SensorData.builder()
                .temperature(30.0)
                .humidity(70.0)
                .build();

        when(sensorDataRepository.save(any(SensorData.class))).thenThrow(new RuntimeException("Database error"));
        assertThrows(RuntimeException.class, () -> dataPublishService.saveAndPublishData(mockSensorData));

    }
}