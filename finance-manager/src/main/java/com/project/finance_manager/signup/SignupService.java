package com.project.finance_manager.signup;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.finance_manager.signup.api.otpValidation.OTPRequest;
import com.project.finance_manager.signup.entity.RegisterOTP;
import com.project.finance_manager.user.service.UserService;
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
        Date date = new Date();
        RegisterOTP registerOTP = new RegisterOTP(uuid, email, otp, date, false);

        signupRepository.save(registerOTP);
        return uuid;
    }

    public boolean hasOTPExpired(RegisterOTP registerOTPFromDB) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        LocalDateTime specificDateTime = LocalDateTime.parse(registerOTPFromDB.getExpiryDateTime().toString(),
                formatter);
        LocalDateTime currentDateTime = LocalDateTime.now();
        return (registerOTPFromDB.getIsExpired()
                || Duration.between(specificDateTime, currentDateTime).toMinutes() > 3);
    }

    public boolean isValidOTP(OTPRequest request) throws Exception {
        if (!signupRepository.existsByUuid(request.getUuid()))
            throw new Exception("UUID does not exist");
        RegisterOTP registerOTPFromDB = signupRepository.findByUuidAndOtp(request.getUuid(), request.getOtp());
        if (registerOTPFromDB==null || hasOTPExpired(registerOTPFromDB))
            throw new Exception("Invalid OTP");
        registerOTPFromDB.setIsExpired(true);
        return true;
    }
}
