package com.project.finance_manager.signup.entity;

import java.util.Date;

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

    private Date expiryDateTime;

    private boolean isExpired;

    public RegisterOTP(){

    }

    public RegisterOTP(String uuid, String email, String otp, Date expiryDateTime, boolean isExpired){
        System.out.println();
        this.uuid = uuid;
        this.email = email;
        this.otp = otp;
        this.expiryDateTime = expiryDateTime;
        this.isExpired = isExpired;
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

    public Date getExpiryDateTime() {
        return this.expiryDateTime;
    }

    public void setExpiryDateTime(Date expiryDateTime) {
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
}
