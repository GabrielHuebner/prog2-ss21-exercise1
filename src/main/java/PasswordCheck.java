import java.lang.*;

public class PasswordCheck {



    public PasswordCheck(){
    }

    public boolean checkPassword(String password){
        if(password == null){
            return false;
        }

        char[] c = password.toCharArray();
        boolean upper = false;
        boolean lower = false;
        boolean number = false;
        boolean specialSign = false;
        boolean repeatingNumbers = false;
        boolean risingNumbers = false;

        if(password.length() < 8 || password.length() > 25){
            return false;
        }

        for(int i = 0; i < password.length(); i++){
            if(Character.isUpperCase(c[i])){
                upper = true;
            }
            else if(Character.isLowerCase(c[i])){
                lower = true;
            }
            else if(Character.isDigit(c[i])){
                number = true;
            }
            else if(c[i] != '(' && c[i] != ')' && c[i] != '#' && c[i] != '$' && c[i] != '?' && c[i] != '!' && c[i] != '%' && c[i] != '/' && c[i] != '@' && !Character.isUpperCase(c[i]) && !Character.isLowerCase(c[i]) && !Character.isDigit(c[i])){
                return false;
            }

            switch (c[i]){
                case '(':
                case ')':
                case '#':
                case '$':
                case '?':
                case '!':
                case '%':
                case '/':
                case '@':
                    specialSign = true;
                    break;
            }
        }

        //Repeating Numbers
        for(int i = 0; i < password.length() -3; i++){
            if(Character.isDigit(c[i]) && Character.isDigit(c[i+1]) && Character.isDigit(c[i+2]) && Character.isDigit(c[i+3]) && c[i] == c[i+1] && c[i] == c[i+2] && c[i] == c[i+3]){
                repeatingNumbers = true;
            }
        }

        //Rising Numbers
        for(int i = 0; i < password.length() - 2; i++){
            if(Character.isDigit(c[i]) && Character.isDigit(c[i+1]) && Character.isDigit(c[i+2]) && c[i] + 1 == c[i+1] && c[i+1] + 1 == c[i+2]){
                risingNumbers = true;
            }
        }

        return upper && lower && number && specialSign && !repeatingNumbers && !risingNumbers;
    }
}
