package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PasswordValidateTest {
    //Validate Password Length
    @Test
    void validatePasswordLength_returnsTrue_OnSendingPasswordA123() {
        String password = "Password@12";
        boolean expected = PasswordValidate.validatePasswordLength(password);
        assertEquals(true, expected);
    }

    @Test
    void validatePasswordLength_returnsTrue_OnLenghth8_OnSending12345678() {
        String password = "12345678";
        boolean expected = PasswordValidate.validatePasswordLength(password);
        assertEquals(true, expected);
    }

    @Test
    void validatePasswordLength_returnsFalse_OnLenghth7_OnSending1234567() {
        String password = "1234567";
        boolean expected = PasswordValidate.validatePasswordLength(password);
        assertEquals(false, expected);
    }

    //Validate String Contain number
    @Test
    void validatePasswordContainNumber_returnsTrue_OnSendingTestthis1() {
        String password = "Testthis1";
        boolean expected = PasswordValidate.validatePasswordLength(password);
        assertEquals(true, expected);
    }

    @Test
    void validatePasswordContainNumber_returnsTrue_OnSendingAllNumbers123456789() {
        String password = "123456789";
        boolean expected = PasswordValidate.validatePasswordLength(password);
        assertEquals(true, expected);
    }

    @Test
    void validatePasswordContainNumber_returnsTrue_OnSending1Test234AtTheRate5() {
        String password = "1Test@234";
        boolean expected = PasswordValidate.validatePasswordLength(password);
        assertEquals(true, expected);
    }

    @Test
    void validatePasswordContainNumber_returnsTrue_OnSendingTestfailed() {
        String password = "Testfailed";
        boolean expected = PasswordValidate.validatePasswordContainNumber(password);
        assertEquals(false, expected);
    }

    //check if needed:
    @Test
    void validatePasswordContainNumber_returnsFalse_OnSending1234() {
        String password = "1234";
        boolean expected = PasswordValidate.validatePasswordContainNumber(password);
        assertEquals(true, expected);
    }
    //Ensure uppercase and lowercase

    @Test
    void validatePasswordContainUperAndLowerCase_returnsTrue_OnSendingTestPassword() {
        String password = "TestPassword";
        boolean expected = PasswordValidate.validatePasswordContainUpperAndLowerCase(password);
        assertEquals(true, expected);
    }

    @Test
    void validatePasswordContainUperAndLowerCase_returnsTrue_OnSendingTestPass1AtTheRate123() {
        String password = "TestPass1@123";
        boolean expected = PasswordValidate.validatePasswordContainUpperAndLowerCase(password);
        assertEquals(true, expected);
    }

    @Test
    void validatePasswordContainUperAndLowerCase_returnsFalse_OnLowerCaseOnly_OnSendinglowercase() {
        String password = "lowercase";
        boolean expected = PasswordValidate.validatePasswordContainUpperAndLowerCase(password);
        assertEquals(false, expected);
    }

    @Test
    void validatePasswordContainUperAndLowerCase_returnsFalse_OnUperCaseOnly_OnSendinglowercase() {
        String password = "UPPERCASE";
        boolean expected = PasswordValidate.validatePasswordContainUpperAndLowerCase(password);
        assertEquals(false, expected);
    }

    //Validate Frequently used password.
    //if last two passwords same as current
    @Test
    void validateFrequentlyUsedPassword_returnsFalse_OnSendingLastTwoPasswordsSame_Test12345TEst12345Test12345() {
        String password = "Test12345";
        boolean expected = PasswordValidate.validateFrequentlyUsedPassword(password, password, password);
        assertEquals(false, expected);
    }
    //if last one is different but before that is same as current password
    @Test
    void validateFrequentlyUsedPassword_returnsFalse_OnSendingLastPasswordDifferentAndBeforeThatSameAsCurrent_Test12345abcdefghiTest12345() {
        String password = "Test12345";
        String differentdPassword = "abcdefghi";
        boolean expected = PasswordValidate.validateFrequentlyUsedPassword(password, differentdPassword, password);
        assertEquals(false, expected);
    }
    @Test
    void validateFrequentlyUsedPassword_returnsFalse_OnSendingLastPasswordSameAsBeforeabcdefghiTest12345Test12345() {
        String password = "Test1234";
        String differentdPassword = "abcdefghi";
        boolean expected = PasswordValidate.validateFrequentlyUsedPassword(differentdPassword, password, password);
        assertEquals(false, expected);
    }
    @Test
    void validateFrequentlyUsedPassword_returnsTrue_OnSendingAllThreePasswordDifferentTest1234ATestABCDE1Test12345() {
        String password = "Test12345";
        String differentdPassword1 = "Test1234A";
        String differentdPassword2 = "TestABCDE1";
        boolean expected = PasswordValidate.validateFrequentlyUsedPassword(differentdPassword2, differentdPassword1, password);
        assertEquals(true, expected);
    }
    //Check Weather password is week
    //Greater than 8
    @Test
    void validateWeakPassword_returnsFalse_OnSendingLessThanEightTestAtTheRate1e() {
        String password = "Test@1e";
        boolean expected = PasswordValidate.validateWeakPassword(password);
        assertEquals(false, expected);
    }
    @Test
    void validateWeakPassword_returnsTrue_OnSendingGreaterThanEightTestAtTheRate13e() {
        String password = "Test@13e";
        boolean expected = PasswordValidate.validateWeakPassword(password);
        assertEquals(true, expected);
    }
    //empty string
    @Test
    void validateWeakPassword_returnsFalse_OnSendingEmpty() {
        String password = "";
        boolean expected = PasswordValidate.validateWeakPassword(password);
        assertEquals(false, expected);
    }
    //if common words exists in
    @Test
    void validateWeakPassword_returnsFalse_OnSendingcommonWordPassword1() {
        String password = "Password1";
        boolean expected = PasswordValidate.validateWeakPassword(password);
        assertEquals(false, expected);
    }
    @Test
    void validateWeakPassword_returnsFalse_OnSendingStringContainCommonWordhello1a2e() {
        String password = "hello1a2e";
        boolean expected = PasswordValidate.validateWeakPassword(password);
        assertEquals(false, expected);
    }
    @Test
    void validateWeakPassword_returnsFalse_OnSendingStringContainNotCommonWordTesab142H() {
        String password = "Tesab142H";
        boolean expected = PasswordValidate.validateWeakPassword(password);
        assertEquals(true, expected);
    }
    //contain One Upper and one Lower Case
    @Test
    void validateWeakPassword_returnsFalse_OnSendingStringContainNoLowerCaseTEST12TE() {
        String password = "TEST12TE";
        boolean expected = PasswordValidate.validateWeakPassword(password);
        assertEquals(false, expected);
    }
    @Test
    void validateWeakPassword_returnsFalse_OnSendingStringContainNoUpperCasetest12te() {
        String password = "test12te";
        boolean expected = PasswordValidate.validateWeakPassword(password);
        assertEquals(false, expected);
    }
    @Test
    void validateWeakPassword_returnsFalse_OnSendingStringContainNoLowerAndUpperCasetest12346421() {
        String password = "12346421";
        boolean expected = PasswordValidate.validateWeakPassword(password);
        assertEquals(false, expected);
    }
    @Test
    void validateWeakPassword_returnsTrue_OnSendingStringContainLowerAndUpperCaseTestPass() {
        String password = "TestPass";
        boolean expected = PasswordValidate.validateWeakPassword(password);
        assertEquals(true, expected);
    }
    //sequence - check consecutive 3 values
    @Test
    void validateWeakPassword_returnsFalse_ThreeInSequenceTesabc142H() {
        String password = "Tesabc142H";
        boolean actual = PasswordValidate.validateWeakPassword(password);
        assertEquals(false, actual);
    }
    @Test
    void validateWeakPassword_returnsFalse_ThreeInSequenceTes1232H() {
        String password = "Tes1232H";
        boolean actual = PasswordValidate.validateWeakPassword(password);
        assertEquals(false, actual);
    }
    @Test
    void validateWeakPassword_returnsFalse_ThreeInSequenceTabc123H() {
        String password = "Tabc123H";
        boolean actual = PasswordValidate.validateWeakPassword(password);
        assertEquals(false, actual);
    }
    @Test
    void validateWeakPassword_returnsTrue_NoThreeInSequenceTess122H() {
        String password = "Tes1212H";
        boolean actual = PasswordValidate.validateWeakPassword(password);
        assertEquals(true, actual);
    }

    //for repetation 3 times
    @Test
    void validateWeakPassword_returnsFalse_ThreeInSequenceTesaaa2H() {
        String password = "Tesaaa2H";
        boolean actual = PasswordValidate.validateWeakPassword(password);
        assertEquals(false, actual);
    }
    @Test
    void validateWeakPassword_returnsFalse_ThreeInSequenceTes1112H() {
        String password = "Tes1112H";
        boolean actual = PasswordValidate.validateWeakPassword(password);
        assertEquals(false, actual);
    }
    @Test
    void validateWeakPassword_returnsFalse_ThreeInSequenceTabc111H() {
        String password = "Tabc111H";
        boolean actual = PasswordValidate.validateWeakPassword(password);
        assertEquals(false, actual);
    }
    @Test
    void validateWeakPassword_returnsTrue_NotThreeInSequenceT11aa11aa() {
        String password = "T11aa11aa";
        boolean actual = PasswordValidate.validateWeakPassword(password);
        assertEquals(true, actual);
    }
    //All together
    @Test
    void validateWeakPassword_NotNULLLengthGreaterThanEightNotCommonContainUpperAndLowerCaseNoCosecutiveAndRepeateThree_shouldReturnTrue_OnSendingTe11aa2H() {
        String password = "Te11aa2H";
        boolean actual = PasswordValidate.validatePasswordLength(password) && PasswordValidate.validatePasswordContainNumber(password)
                && PasswordValidate.validatePasswordContainUpperAndLowerCase(password) && PasswordValidate.validateWeakPassword(password);
        assertTrue( actual);
    }

}
