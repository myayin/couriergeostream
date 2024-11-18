package com.merve.couriergeostream.mapper;

import com.merve.couriergeostream.dto.CourierDto;
import com.merve.couriergeostream.entity.Courier;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourierMapper {

    CourierMapper INSTANCE = Mappers.getMapper(CourierMapper.class);

    CourierDto toDto(Courier courier);

    Courier toEntity(CourierDto courierDto);
}
