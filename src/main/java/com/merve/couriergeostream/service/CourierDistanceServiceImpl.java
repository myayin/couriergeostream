package com.merve.couriergeostream.service;

import com.merve.couriergeostream.dto.GetGeoDTO;
import com.merve.couriergeostream.queue.CourierLocationProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourierDistanceServiceImpl implements CourierDistanceService {

    private final CourierLocationProducer courierLocationProducer;

    public void saveGeo(GetGeoDTO request) {
        courierLocationProducer.sendMessage(request);
    }

}
