package com.mococo.api.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse <T>{

     private T data;
     private String message;

     public static <T> ApiResponse<T> create(T data) {
          return new ApiResponse<>(data, Strings.EMPTY);
     }

     public static <T> ApiResponse<T> create(T data, String message) {
          return new ApiResponse<>(data, message);
     }
     
}
