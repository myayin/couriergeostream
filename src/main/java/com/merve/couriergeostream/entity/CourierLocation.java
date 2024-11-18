package com.merve.couriergeostream.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

@Entity
@Table()
@Getter
@Setter
public class CourierLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long courierId;

    @Column(columnDefinition = "Geometry(Point, 4326)")
    private Point location;
}
