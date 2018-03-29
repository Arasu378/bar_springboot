package com.arasu.bar.bar.utils;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotNull;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class Utils {
    private static final String ALPABHETS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public static final String SUBJECT = "Welcome to BarApp by Kyros";
    public static final String BODY = "Your Password for controller is:  ";
    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 5*60*60;
    public static final String SIGNING_KEY = "arasuKyros";
    public static final String TOKEN_PREFIX = "Kyros";
    public static final String HEADER_STRING = "Authorization";

    public static String RandomPassword() {
        SecureRandom secureRandom = new SecureRandom();
        String randomPassword = null;
        StringBuilder stringBuilder = new StringBuilder( 5 );
        for (int i = 0; i < 5; i++) {
            stringBuilder.append(ALPABHETS.charAt(secureRandom.nextInt(ALPABHETS.length())));
            randomPassword = stringBuilder.toString();
        }
        return randomPassword;
    }
    @NotNull
    public static String encodedString(String value) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
   String hashedPassword = passwordEncoder.encode(value);
      //  byte[] encodedBytes = Base64.getEncoder().encode(value.getBytes());
//        return new String(encodedBytes);
        return hashedPassword;
    }
    @NotNull
    public static String decodedString(String value) {
        byte[] decodedBytes = Base64.getDecoder().decode(value.getBytes());
        return new String(decodedBytes);
    }
    public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
