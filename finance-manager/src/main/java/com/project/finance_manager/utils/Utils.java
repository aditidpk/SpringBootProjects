package com.project.finance_manager.utils;

import java.text.DecimalFormat;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {
    public boolean isValidEmailAddress(String email) {
        if(email.length()<1) return false;
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    public String generateOTP(){
        return new DecimalFormat("000000").format(new Random().nextInt(999999));
    }
}
