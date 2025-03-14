package com.shekel.data_streamer.repository;

import com.shekel.data_streamer.models.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorDataRepository extends JpaRepository<SensorData, Long> {
}
