package com.project.finance_manager.exception;

public class InvalidOTPException extends Exception {
    public InvalidOTPException(){
        super(ErrorMessages.INVALID_OTP);
    }
}
