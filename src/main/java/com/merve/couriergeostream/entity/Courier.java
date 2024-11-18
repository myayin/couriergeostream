package com.merve.couriergeostream.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

import java.math.BigDecimal;

@Entity
@Table()
@Getter
@Setter
public class Courier extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal totalTravelDistance = BigDecimal.ZERO;

    private String city;

    private String district;

    @Column(columnDefinition = "Geometry(Point, 4326)")
    private Point lastLocation;

    @Version
    private int version;
}
