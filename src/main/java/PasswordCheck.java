import java.lang.*;

public class PasswordCheck {


    public static final int MIN_SIZE_PWD = 8;
    public static final int MAX_SIZE_PWD = 25;

    public PasswordCheck(){
    }

    public boolean checkPassword(String password){
        if(password == null){
            return false;
        }

        char[] c = password.toCharArray();
        boolean upper;
        boolean lower;
        boolean number;
        boolean specialSign;
        boolean repeatingNumbers;
        boolean risingNumbers;

        if (checkLength(password)) return false;

        if (checkInvalidSign(password, c)) return false;

        upper = checkUpperCase(password, c);

        lower = checkLowerCase(password, c);

        number = checkDigit(password, c);

        specialSign = checkSpecialSign(password, c);

        repeatingNumbers = checkRepeatingNumbers(password, c);

        risingNumbers = checkRisingNumbers(password, c);

        return upper && lower && number && specialSign && !repeatingNumbers && !risingNumbers;
    }

    private boolean checkInvalidSign(String password, char[] c) {
        for(int i = 0; i < password.length(); i++){
            if(c[i] != '(' && c[i] != ')' && c[i] != '#' && c[i] != '$' && c[i] != '?' && c[i] != '!' && c[i] != '%' && c[i] != '/' && c[i] != '@' && !Character.isUpperCase(c[i]) && !Character.isLowerCase(c[i]) && !Character.isDigit(c[i])){
                return true;
            }
        }
        return false;
    }

    private boolean checkSpecialSign(String password, char[] c) {
        boolean specialSign = false;
        for(int i = 0; i < password.length(); i++){
            if (c[i] == '(' || c[i] == ')' || c[i] == '#' || c[i] == '$' || c[i] == '?' || c[i] == '!' || c[i] == '%' || c[i] == '/' || c[i] == '@') {
                specialSign = true;
                break;
            }
        }
        return specialSign;
    }

    private boolean checkDigit(String password, char[] c) {
        boolean number = false;
        for(int i = 0; i < password.length(); i++){
            if(Character.isDigit(c[i])){
                number = true;
            }
        }
        return number;
    }

    private boolean checkLowerCase(String password, char[] c) {
        boolean lower = false;
        for(int i = 0; i < password.length(); i++){
            if(Character.isLowerCase(c[i])){
                lower = true;
            }
        }
        return lower;
    }

    private boolean checkUpperCase(String password, char[] c) {
        boolean upper = false;
        for(int i = 0; i < password.length(); i++){
            if(Character.isUpperCase(c[i])){
                upper = true;
            }
        }
        return upper;
    }

    private boolean checkRisingNumbers(String password, char[] c) {
        boolean risingNumbers = false;
        for(int i = 0; i < password.length() - 2; i++){
            if(Character.isDigit(c[i]) && Character.isDigit(c[i+1]) && Character.isDigit(c[i+2]) && c[i] + 1 == c[i+1] && c[i+1] + 1 == c[i+2]){
                risingNumbers = true;
            }
        }
        return risingNumbers;
    }

    private boolean checkRepeatingNumbers(String password, char[] c) {
        boolean repeatingNumbers = false;
        for(int i = 0; i < password.length() -3; i++){
            if(Character.isDigit(c[i]) && Character.isDigit(c[i+1]) && Character.isDigit(c[i+2]) && Character.isDigit(c[i+3]) && c[i] == c[i+1] && c[i] == c[i+2] && c[i] == c[i+3]){
                repeatingNumbers = true;
            }
        }
        return repeatingNumbers;
    }

    private boolean checkLength(String password) {
        return (password.length() < MIN_SIZE_PWD || password.length() > MAX_SIZE_PWD);
    }
}
