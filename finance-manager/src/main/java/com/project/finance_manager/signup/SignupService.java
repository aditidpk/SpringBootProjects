package com.project.finance_manager.signup;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.finance_manager.signup.api.otpValidation.OTPRequest;
import com.project.finance_manager.signup.api.userRegistration.UserRegRequest;
import com.project.finance_manager.signup.entity.RegisterOTP;
import com.project.finance_manager.user.UserService;
import com.project.finance_manager.utils.Utils;

@Service
public class SignupService {
    @Autowired
    private Utils utils;
    private SignupRepository signupRepository;
    private UserService userService;

    public SignupService(UserService userService, SignupRepository signupRepository) {
        this.userService = userService;
        this.signupRepository = signupRepository;
    }

    public String getVerifiedEmailUUID(String email) throws Exception {
        if (userService.doesEmailExists(email))
            throw new Exception("User already exists!");

        return saveOTPInfo(email);
    }

    public String saveOTPInfo(String email) {
        String uuid = UUID.randomUUID().toString();
        String otp = utils.generateOTP();
        RegisterOTP registerOTP = new RegisterOTP(uuid, email, otp, false, false);

        signupRepository.save(registerOTP);
        return uuid;
    }

    public boolean isValidOTP(OTPRequest otpRequest) throws Exception {
        if (signupRepository.findByUUIDAndOtp(otpRequest.getUuid(), otpRequest.getOtp()) == 0) {
            throw new Exception("Invalid OTP");
        }
        signupRepository.updateIsValidatedByUUID(otpRequest.getUuid());
        return true;
    }

    public void registerUser(UserRegRequest userRegRequest) throws Exception {
        try {
            if (signupRepository.existsByEmail(userRegRequest.getEmail()) == 0)
                throw new Exception("Incorrect email entered");
            userService.registerNewUser(userRegRequest);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
