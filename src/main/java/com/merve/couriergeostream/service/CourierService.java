package com.merve.couriergeostream.service;

import com.merve.couriergeostream.dto.CourierDto;
import com.merve.couriergeostream.entity.Courier;
import com.merve.couriergeostream.exception.CourierGeoStreamException;
import com.merve.couriergeostream.mapper.CourierMapper;
import com.merve.couriergeostream.repository.CourierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.merve.couriergeostream.constants.ResponseCode.E_COURIER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CourierService {

    private final CourierRepository courierRepository;

    public CourierDto findById(Long id) throws CourierGeoStreamException {
        Courier courier = courierRepository.findById(id).orElseThrow(
                () -> new CourierGeoStreamException(E_COURIER_NOT_FOUND.name(), E_COURIER_NOT_FOUND.getMessage()));
        return CourierMapper.INSTANCE.toDto(courier);
    }

    public Courier save(Courier courier) {
       return courierRepository.save(courier);
    }
}
