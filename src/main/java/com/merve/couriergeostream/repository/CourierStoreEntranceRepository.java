package com.merve.couriergeostream.repository;

import com.merve.couriergeostream.entity.CourierStoreEntrance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
public interface CourierStoreEntranceRepository extends JpaRepository<CourierStoreEntrance, Long> {

    CourierStoreEntrance findByCourierIdAndStoreIdAndDateAfter(Long courierId, Long storeId, Instant date);
}
