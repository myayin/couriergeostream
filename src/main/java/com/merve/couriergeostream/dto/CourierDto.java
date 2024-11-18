package com.merve.couriergeostream.dto;

import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

import java.math.BigDecimal;

@Getter
@Setter
public class CourierDto {
    private Long id;

    private BigDecimal totalTravelDistance;

    private String city;

    private String distinct;

    private Point lastLocation;

    @Version
    private int version;
}
