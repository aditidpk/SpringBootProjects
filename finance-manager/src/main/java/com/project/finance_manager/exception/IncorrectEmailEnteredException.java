package com.project.finance_manager.exception;

public class IncorrectEmailEnteredException extends Exception {
    public IncorrectEmailEnteredException(){
        super(ErrorMessages.INCORRECT_EMAIL);
    }
}
