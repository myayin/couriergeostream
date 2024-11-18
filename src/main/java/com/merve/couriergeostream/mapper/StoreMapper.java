package com.merve.couriergeostream.mapper;

import com.merve.couriergeostream.dto.StoreDto;
import com.merve.couriergeostream.entity.Store;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StoreMapper {
    StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);

    StoreDto toDto(Store store);
}
