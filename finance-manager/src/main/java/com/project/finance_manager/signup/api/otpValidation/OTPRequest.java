package com.project.finance_manager.signup.api.otpValidation;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OTPRequest {
    @JsonProperty("otp")
    private String otp;

    @JsonProperty("id")
    private String uuid;
}
