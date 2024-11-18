package com.merve.couriergeostream.dto;

import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

@Getter
@Setter
public class StoreDto {

    private Long id;

    private String name;

    private Point location;

    private String city;

    private String distinct;
}
