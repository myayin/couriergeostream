package com.merve.couriergeostream.service;

import com.merve.couriergeostream.dto.StoreDto;
import com.merve.couriergeostream.entity.Store;
import com.merve.couriergeostream.mapper.StoreMapper;
import com.merve.couriergeostream.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public List<StoreDto> findByCityAndDistinct(String city, String distinct, Point courierLocation, double radius) {
        List<Store> stores = storeRepository.findByCityAnDistrict(courierLocation, radius, city, distinct);
        return stores.stream().map(StoreMapper.INSTANCE::toDto).toList();
    }

    public void saveAll(List<Store> stores) {
        storeRepository.saveAll(stores);
    }
}
