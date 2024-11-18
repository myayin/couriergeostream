package com.merve.couriergeostream.repository;

import com.merve.couriergeostream.entity.Store;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    @Query(value = "SELECT * FROM store s WHERE ST_DWithin(s.location, :courierLocation, :radius) AND s.city = :city AND s.district = :district", nativeQuery = true)
    List<Store> findByCityAnDistrict(@Param("courierLocation") Point courierLocation,
                                       @Param("radius") double radius,
                                       @Param("city") String city,
                                       @Param("district") String district);
}
