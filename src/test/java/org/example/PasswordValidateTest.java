package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PasswordValidateTest {
    //Validate Password Length
    @Test
    void validatePasswordLength_returnsTrue_OnSendingPasswordA123() {
        String password = "Password@123";
        boolean expected = PasswordValidate.validatePasswordLength(password);
        assertEquals(true, expected);
    }
    @Test
    void validatePasswordLength_returnsTrue_OnSending123456789() {
        String password = "123456789";
        boolean expected = PasswordValidate.validatePasswordLength(password);
        assertEquals(true, expected);
    }
    @Test
    void validatePasswordLength_returnsFalse_OnLenghth8_OnSending12345678() {
        String password = "12345678";
        boolean expected = PasswordValidate.validatePasswordLength(password);
        assertEquals(false, expected);
    }
    @Test
    void validatePasswordLength_returnsFalse_OnLenghth7_OnSendingTestit1() {
        String password = "12345678";
        boolean expected = PasswordValidate.validatePasswordLength(password);
        assertEquals(false, expected);
    }
}