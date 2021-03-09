import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordCheckTests {

    @BeforeAll
    static void init() {}

    @BeforeEach
    void setUp() {}

    @Test
    void checkPasswordLength1() {
        //check if PW too short
        PasswordCheck pw = new PasswordCheck();
        boolean b = pw.checkPassword("AAAAAA");
        assertFalse(b);
    }

    @Test
    void checkPasswordLength2() {
        //check if PW too long
        PasswordCheck pw = new PasswordCheck();
        boolean b = pw.checkPassword("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        assertFalse(b);
    }

    @Test
    void checkPasswordUpperCase() {
        //check if it checks for Uppercase
        PasswordCheck pw = new PasswordCheck();
        boolean b = pw.checkPassword("aaa1!aaa");
        assertFalse(b);
    }

    @Test
    void checkPasswordLowerCase() {
        //check if it checks for Lowercase
        PasswordCheck pw = new PasswordCheck();
        boolean b = pw.checkPassword("AAA1!AAA");
        assertFalse(b);
    }

    @Test
    void checkPasswordDigit() {
        //check if it checks Numbers
        PasswordCheck pw = new PasswordCheck();
        boolean b = pw.checkPassword("AAAa!AAA");
        assertFalse(b);
    }

    @Test
    void checkPasswordSpecialChar() {
        //check if it checks for Special Characters
        PasswordCheck pw = new PasswordCheck();
        boolean b = pw.checkPassword("AAAa1AAA");
        assertFalse(b);
    }

    @Test
    void checkPasswordRepeatingNumbers() {
        //check if it checks for Special Characters
        PasswordCheck pw = new PasswordCheck();
        boolean b = pw.checkPassword("1111AAAa1AA!");
        assertFalse(b);
    }

    @Test
    void checkPasswordRisingNumbers() {
        //check if it checks for Special Characters
        PasswordCheck pw = new PasswordCheck();
        boolean b = pw.checkPassword("123AAAa1AAA");
        assertFalse(b);
    }
}
