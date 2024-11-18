package com.merve.couriergeostream.util;

import com.merve.couriergeostream.dto.CoordinateDTO;
import lombok.experimental.UtilityClass;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

@UtilityClass
public class PointUtil {

    public static Point createPoint(CoordinateDTO dto) {
        GeometryFactory geometryFactory = new GeometryFactory();
        return geometryFactory.createPoint(
                new Coordinate(dto.getLatitude(), dto.getLongitude()));
    }
}
