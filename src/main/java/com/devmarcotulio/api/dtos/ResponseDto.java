package com.devmarcotulio.api.dtos;

import lombok.Data;

@Data
public class ResponseDto {

    private String statusCode;
    private String message;

    public ResponseDto(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
