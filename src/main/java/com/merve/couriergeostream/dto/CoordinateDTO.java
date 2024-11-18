package com.merve.couriergeostream.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor

public class CoordinateDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @JsonProperty
    private double latitude;
    @JsonProperty
    private double longitude;

    @JsonCreator
    public CoordinateDTO(@JsonProperty("latitude") double latitude, @JsonProperty("longitude") double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

}
