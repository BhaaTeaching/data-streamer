package com.shekel.data_streamer.models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "uart_sim_db")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SensorData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double temperature;

    private double humidity;
}

