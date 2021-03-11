import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Link to repository: https://github.com/GabrielHuebner/prog2-ss21-exercise1.git

public class PasswordCheckTests {
    private PasswordCheck pw = new PasswordCheck();

    @BeforeAll
    static void init() {}

    @BeforeEach
    void setUp() {}

    @DisplayName("Check if a valid password is accepted")
    @Test
    void checkPasswordTrue() {
        boolean b = pw.checkPassword("Aa1!aaw2j");
        assertTrue(b);
    }

    @DisplayName("Check if too short password is accepted")
    @Test
    void checkPasswordLength1() {
        boolean b = pw.checkPassword("AAA1!a");
        assertFalse(b);
    }

    @DisplayName("Check if too long password is accepted")
    @Test
    void checkPasswordLength2() {
        boolean b = pw.checkPassword("AAAAAAAAAAAAAAAAAAAAA1!aAAAAAA");
        assertFalse(b);
    }

    @DisplayName("Check all lowercase password is accepted")
    @Test
    void checkPasswordUpperCase() {
        boolean b = pw.checkPassword("aaa1!aaa");
        assertFalse(b);
    }

    @DisplayName("Check if all uppercase password is accepted")
    @Test
    void checkPasswordLowerCase() {
        //check if it checks for Lowercase
        boolean b = pw.checkPassword("AAA1!AAA");
        assertFalse(b);
    }

    @DisplayName("Check if password without digits is accepted")
    @Test
    void checkPasswordDigit() {
        boolean b = pw.checkPassword("AAAa!AAA");
        assertFalse(b);
    }

    @DisplayName("Check if password without special sign is accepted")
    @Test
    void checkPasswordSpecialChar() {
        boolean b = pw.checkPassword("AAAa1AAA");
        assertFalse(b);
    }

    @DisplayName("Check if password with 4 repeating numbers is accepted")
    @Test
    void checkPasswordRepeatingNumbers() {
        boolean b = pw.checkPassword("1111AAAa1AA!");
        assertFalse(b);
    }

    @DisplayName("Check if password with 3 rising numbers is accepted")
    @Test
    void checkPasswordRisingNumbers() {
        boolean b = pw.checkPassword("123AAAa1AAA");
        assertFalse(b);
    }

    @DisplayName("Check null value is accepted")
    @Test
    void checkPasswordNullValue() {
        boolean b = pw.checkPassword(null);
        assertFalse(b);
    }

    @DisplayName("Check if password with space is accepted")
    @Test
    void checkPasswordOtherCharacter1() {
        boolean b = pw.checkPassword("Aa1! aaw2j");
        assertFalse(b);
    }

    @DisplayName("Check if password with invalid character is accepted")
    @Test
    void checkPasswordOtherCharacter2() {
        boolean b = pw.checkPassword("Aa1!{aaw2j");
        assertFalse(b);
    }
}
