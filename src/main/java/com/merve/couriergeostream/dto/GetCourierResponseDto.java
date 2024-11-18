package com.merve.couriergeostream.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetCourierResponseDto extends BaseResponse {
    private CourierDto courierDto;
}
