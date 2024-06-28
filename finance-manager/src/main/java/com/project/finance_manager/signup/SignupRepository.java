package com.project.finance_manager.signup;

import org.springframework.stereotype.Repository;

import com.project.finance_manager.signup.entity.RegisterOTP;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface SignupRepository extends JpaRepository<RegisterOTP, String> {
    boolean existsByUuid(String uuid);
    
    @Query(value = "select COUNT(1) from RegisterOTP where uuid=:uuid and otp=:otp and isExpired=false and expiryDateTime > NOW()")
    Long findByUUIDAndOtp(String uuid, String otp);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "update register_otp set is_expired=1, is_validated=1 where uuid=:uuid", nativeQuery=true)
    void updateIsValidatedByUUID(String uuid);
}
