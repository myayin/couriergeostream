package com.merve.couriergeostream.service;

import com.merve.couriergeostream.entity.CourierLocation;
import com.merve.couriergeostream.repository.CourierLocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourierLocationService {

    private final CourierLocationRepository courierLocationRepository;

    public CourierLocation save(CourierLocation courierLocation) {
        return courierLocationRepository.save(courierLocation);
    }
}
