package com.merve.couriergeostream.controller;

import com.merve.couriergeostream.dto.BaseResponse;
import com.merve.couriergeostream.dto.GetGeoDTO;
import com.merve.couriergeostream.dto.Result;
import com.merve.couriergeostream.exception.CourierGeoStreamException;
import com.merve.couriergeostream.service.CourierDistanceService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/v0/courierDistance", produces = MediaType.APPLICATION_JSON_VALUE)
public class CourierDistanceController {

    private final CourierDistanceService courierDistanceService;

    @PostMapping
    public ResponseEntity<BaseResponse> saveGeo(@RequestBody GetGeoDTO request)
            throws CourierGeoStreamException {
        courierDistanceService.saveGeo(request);
        BaseResponse response = new BaseResponse();
        response.setResult(Result.success());
        return ResponseEntity.ok(response);
    }
}
