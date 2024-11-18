package com.merve.couriergeostream.service;

import com.merve.couriergeostream.entity.CourierStoreEntrance;
import com.merve.couriergeostream.repository.CourierStoreEntranceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class CourierStoreEntranceService {

    private final CourierStoreEntranceRepository courierStoreEntranceRepository;

    public CourierStoreEntrance findByCourierIdAndStoreIdAndDateAfter(Long courierId, Long storeId, Instant date) {
        return courierStoreEntranceRepository.findByCourierIdAndStoreIdAndDateAfter(courierId, storeId, date);
    }

    public CourierStoreEntrance save(CourierStoreEntrance courierStoreEntrance){
        return courierStoreEntranceRepository.save(courierStoreEntrance);
    }

}
