package com.gmatieso.ems.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponseEntity {

    public static <T> ResponseEntity<?> success(String message, T data){
        ApiResponse<T> response = new ApiResponse<>(HttpStatus.OK.value(), message, data);
        return ResponseEntity.ok(response);
    }

    public static <T> ResponseEntity<?> error(String message, T data){
        ApiResponse<T> response = new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), message, data);
        return ResponseEntity.badRequest().body(response);
    }
}
