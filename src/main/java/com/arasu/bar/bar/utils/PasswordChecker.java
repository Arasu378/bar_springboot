package com.arasu.bar.bar.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordChecker {
    private static int workload = 12;

    public static String encodedPassword(String password) {
        String salt = BCrypt.gensalt(workload);
        return BCrypt.hashpw(password, salt);
    }
    public static boolean checkPassword(String password, String encodedPassword) {
        boolean passwordVerified = false;
        if (null == encodedPassword || !encodedPassword.startsWith("$2a$"))
            throw new IllegalArgumentException("Invalid encoded Password provided for comparison");
        passwordVerified = BCrypt.checkpw(password, encodedPassword);
        return passwordVerified;
    }
}
