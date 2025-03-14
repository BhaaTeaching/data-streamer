package com.shekel.data_streamer.mapper;

import com.shekel.data_streamer.models.SensorData;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DataStreamerMapper {

    @BeanMapping(ignoreByDefault = true) // Suppresses unwanted checks
    @Mapping(target = "temperature", source = "temperature")
    @Mapping(target = "humidity", source = "humidity")
    SensorData toSensorData(Double temperature, Double humidity);

}
