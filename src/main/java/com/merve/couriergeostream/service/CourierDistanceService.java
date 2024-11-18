package com.merve.couriergeostream.service;

import com.merve.couriergeostream.dto.GetGeoDTO;
import com.merve.couriergeostream.exception.CourierGeoStreamException;

public interface CourierDistanceService {

    void saveGeo(GetGeoDTO request)
            throws CourierGeoStreamException;
}
