package com.medcrm.model;
import com.medcrm.util.EncryptionUtils;

import java.util.Date;

public abstract class User {
    protected String id;
    protected String name;
    protected String email;
    protected String passwordHash;
    protected String role;
    protected Date lastLogin;

    public User(String id, String name, String email, String plainPassword, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passwordHash = EncryptionUtils.hashPassword(plainPassword);
        this.role = role;
        this.lastLogin = null;
    }

    public boolean login(String inputPassword) {
        if (EncryptionUtils.verifyPassword(inputPassword, this.passwordHash)) {
            this.lastLogin = new Date();
            System.out.println(name + " logged in successfully.");
            return true;
        } else {
            System.out.println("Login failed for " + email);
            return false;
        }
    }
    public void logout() {
        System.out.println(name + " logged out successfully.");
        // Optional: clear session info in future
    }

    public void changePassword(String oldPwd, String newPwd) {
        if (EncryptionUtils.verifyPassword(oldPwd, this.passwordHash)) {
            this.passwordHash = EncryptionUtils.hashPassword(newPwd);
            System.out.println("Password updated successfully for " + name);
        } else {
            System.out.println("Old password is incorrect for " + name);
        }
    }


    public String getId(){

        return id;
    }
    public String getName(){

        return name;
    }
    public String getEmail(){

        return email;
    }
    public String getPasswordHash(){

        return passwordHash;
    }
    public void setRole(String role){
        this.role = role;

    }
    public String getRole(){

        return role;
    }
    public Date getLastLogin(){

        return lastLogin;
    }

}
