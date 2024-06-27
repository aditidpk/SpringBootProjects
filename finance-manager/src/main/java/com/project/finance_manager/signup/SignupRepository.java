package com.project.finance_manager.signup;

import org.springframework.stereotype.Repository;

import com.project.finance_manager.signup.entity.RegisterOTP;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface SignupRepository extends JpaRepository<RegisterOTP, String> {
    boolean existsByUuid(String uuid);
    RegisterOTP findByUuidAndOtp(String uuid, String otp);
}
