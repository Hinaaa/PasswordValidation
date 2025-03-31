package org.example;

public class PasswordValidate {
    public static boolean validatePasswordLength(String password) {
        if (password.length() >= 8) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validatePasswordContainNumber(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    //validate upper and lowercase
    public static boolean validatePasswordContainUpperAndLowerCase(String password) {
        int counterU = 0, counterL = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                counterU++;
            }
            if (Character.isLowerCase(password.charAt(i))) {
                counterL++;
            }
        }
        if (counterU >= 1 && counterL >= 1) {
            return true;
        } else {
            return false;
        }
    }

    //Frequently Used Passwords
    public static boolean validateFrequentlyUsedPassword(String LastSavedPassword2, String LastSavedPassword1, String password) {
        //validating if last two password same
        if (password.equals(LastSavedPassword2) || password.equals(LastSavedPassword1)) {
            return false;
        } else {
            return true;
        }
    }

    //validate Week Password
    public static boolean validateWeakPassword(String password) {

        //if password is Null or empty
        if (password == null || password.isEmpty()) {
            return false; // Handle null or empty inputs
        }

        //Length greater than 8 then return false
        if (password.length() < 8) {
            return false;
        }
        // password contain one upper and 1 lower case
        if (!(password.chars().anyMatch(Character::isLowerCase) && password.chars().anyMatch(Character::isUpperCase))) {
            return false; // Handle null or empty inputs
        }
        //Common words, if exists password in it, return false
        String[] commonWords = new String[] {"Password","Password1","Aa345678","qwerty","password","password1","hello","hallo","welcome"};
        for (int i = 0; i < commonWords.length; i++) {
            if (password.contains(commonWords[i])) {
                return false;
            }
        }

        //if 3 characters same in sequence or number repeasted 3 times, return false
        int checker = 1;
        int maxCheck = 1;
        int sameValue = 1;
        int sameValueMax = 1;

        // Check for more than three consecutive characters or digits
        for (int i = 0; i < password.length() - 1; i++) {
            int value = password.charAt(i);
            int nextValue = password.charAt(i + 1);
            //for Sequence
            if (value + 1 == nextValue) {
                checker++;
                maxCheck = Math.max(maxCheck, checker);
            } else {
                checker = 1;
            }
            //for repeated numbers
            if(value == nextValue) {
                sameValue ++;
                sameValueMax = Math.max(sameValueMax, sameValue);
            }
            else {
                sameValue = 1;
            }
            }
        //checking sequence three times, return False
        if (maxCheck > 2) {
            return false;
        }

        //checking repeated three times, return False
        if (sameValueMax > 2) {
            return false;
        }
        return true;
    }
}
