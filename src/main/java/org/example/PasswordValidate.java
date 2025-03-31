package org.example;

public class PasswordValidate {
    public static boolean validatePasswordLength(String password) {
        if (password.length() > 8) {
            return true;
        }
        else {
            return false;
        }
        //Return String;
    }
}
