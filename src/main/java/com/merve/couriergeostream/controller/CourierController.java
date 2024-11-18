package com.merve.couriergeostream.controller;

import com.merve.couriergeostream.dto.CourierDto;
import com.merve.couriergeostream.dto.GetCourierResponseDto;
import com.merve.couriergeostream.dto.Result;
import com.merve.couriergeostream.exception.CourierGeoStreamException;
import com.merve.couriergeostream.service.CourierService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/v0/courier", produces = MediaType.APPLICATION_JSON_VALUE)
public class CourierController {

    private final CourierService courierService;

    @GetMapping("/{courierId}")
    public ResponseEntity<GetCourierResponseDto> getCourier(@PathVariable Long courierId)
            throws CourierGeoStreamException {
        CourierDto courierDto = courierService.findById(courierId);
        GetCourierResponseDto response = new GetCourierResponseDto();
        response.setCourierDto(courierDto);
        response.setResult(Result.success());
        return ResponseEntity.ok(response);
    }
}
