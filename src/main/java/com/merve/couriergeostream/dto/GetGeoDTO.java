package com.merve.couriergeostream.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor

public class GetGeoDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @JsonCreator
    public GetGeoDTO(@JsonProperty("courierId") Long courierId, @JsonProperty("coordinateDTO") CoordinateDTO coordinateDTO) {
        this.courierId = courierId;
        this.coordinateDTO = coordinateDTO;
    }

    @JsonProperty
    private Long courierId;

    @JsonProperty
    private CoordinateDTO coordinateDTO;

}
