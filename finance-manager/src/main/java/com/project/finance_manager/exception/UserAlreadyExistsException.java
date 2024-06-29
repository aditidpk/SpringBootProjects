package com.project.finance_manager.exception;

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(){
        super(ErrorMessages.USER_ALREADY_EXISTS);
    }
}
