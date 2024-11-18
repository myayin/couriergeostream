package com.merve.couriergeostream.constants;

import lombok.Getter;

@Getter
public enum ResponseCode {
    SUCCESS("Success"),
    SYSTEM_ERROR(
            "İşleminizi şimdi gerçekleştiremiyoruz, lütfen daha sonra tekrar deneyiniz."),
    E_COURIER_NOT_FOUND("Kurye bulunamadı.");

    private final String message;

    ResponseCode(String message) {
        this.message = message;
    }
}
