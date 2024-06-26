package com.project.finance_manager.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.project.finance_manager.exception.ErrorMessages;
import com.project.finance_manager.signup.api.emailValidation.EmailRequest;
import com.project.finance_manager.signup.api.emailValidation.EmailResponse;
import com.project.finance_manager.signup.api.otpValidation.OTPRequest;
import com.project.finance_manager.signup.api.userRegistration.UserRegRequest;
import com.project.finance_manager.utils.Utils;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class SignupController {
    @Autowired
    private SignupService signupService;
    private Utils utils;

    public SignupController(SignupService signupService, Utils utils) {
        this.signupService = signupService;
        this.utils = utils;
    }

    @PostMapping("/verify-email")
    public ResponseEntity<EmailResponse> verifyEmail(@RequestBody EmailRequest request) throws Exception {
        try {
            String email = request.getEmail();
            if (!utils.isValidEmailAddress(email))
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

            String uuid = signupService.getVerifiedEmailUUID(email);
            EmailResponse emailResponse = new EmailResponse();
            emailResponse.setUuid(uuid);

            return new ResponseEntity<EmailResponse>(emailResponse, HttpStatus.OK);
        } catch (Exception e) {
            if (e.getMessage().equals(ErrorMessages.USER_ALREADY_EXISTS))
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/validate-otp")
    public ResponseEntity<?> validateOTP(@RequestBody OTPRequest request) throws Exception {
        try {
            signupService.isValidOTP(request);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            switch (e.getMessage()) {
                case ErrorMessages.INVALID_OTP:
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                default:
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @PostMapping("/register-user")
    public ResponseEntity<?> registerUser(@RequestBody UserRegRequest request) {
        try {
            signupService.registerUser(request);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            switch (e.getMessage()) {
                case ErrorMessages.USER_ALREADY_EXISTS:
                    return new ResponseEntity<>(HttpStatus.CONFLICT);
                case ErrorMessages.INCORRECT_EMAIL:
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                default:
                    return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }

}
