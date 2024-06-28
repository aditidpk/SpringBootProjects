package com.project.finance_manager.signup.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "register_otp")
public class RegisterOTP {
    @Id
    private String uuid;
    
    private String email;

    private String otp;

    private LocalDateTime expiryDateTime;

    private boolean isExpired;

    private boolean isValidated;

    public boolean isIsValidated() {
        return this.isValidated;
    }

    public RegisterOTP(){

    }

    public RegisterOTP(String uuid, String email, String otp, boolean isExpired, boolean isValidated){
        System.out.println();
        this.uuid = uuid;
        this.email = email;
        this.otp = otp;
        this.expiryDateTime = LocalDateTime.now().plusMinutes(10);
        this.isExpired = isExpired;
        this.isValidated = isValidated;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOtp() {
        return this.otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public LocalDateTime getExpiryDateTime() {
        return this.expiryDateTime;
    }

    public void setExpiryDateTime(LocalDateTime expiryDateTime) {
        this.expiryDateTime = expiryDateTime;
    }

    public boolean isIsExpired() {
        return this.isExpired;
    }

    public boolean getIsExpired() {
        return this.isExpired;
    }

    public void setIsExpired(boolean isExpired) {
        this.isExpired = isExpired;
    }

    public boolean getIsValidated() {
        return this.isValidated;
    }

    public void setIsValidated(boolean isValidated) {
        this.isValidated = isValidated;
    }

}
