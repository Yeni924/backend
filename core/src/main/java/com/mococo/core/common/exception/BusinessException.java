package com.mococo.core.common.exception;

import com.mococo.core.common.constants.ErrorCode;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
     private final ErrorCode errorCode;

     public BusinessException(ErrorCode errorCode) {
          super(errorCode.getMessage());
          this.errorCode = errorCode;
     }

     public BusinessException(ErrorCode errorCode, String extraMessage) {
          super(String.format(errorCode.getMessage(), extraMessage));
          this.errorCode = errorCode;
     }

     public int getStatus() {
          return this.errorCode.getStatus();
     }
}