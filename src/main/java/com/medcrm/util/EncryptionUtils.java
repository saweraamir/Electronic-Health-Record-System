package com.medcrm.util;

import org.mindrot.jbcrypt.BCrypt;

public class EncryptionUtils {

    // Hash the password using BCrypt
    public static String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    // Verify input password against stored hash
    public static boolean verifyPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}