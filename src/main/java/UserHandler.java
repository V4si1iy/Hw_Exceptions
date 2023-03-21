import Exceptions.WrongLoginException;
import Exceptions.WrongPasswordException;

import java.util.Locale;

import static org.apache.commons.lang3.StringUtils.*;

public class UserHandler {
   private static final Character[] allowedCharacters = {
            'q', 'w', 'r', 't', 'y', 'u', 'i', 'o', 'p',
            'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l',
            'z', 'x', 'c', 'v', 'b', 'n', 'm',
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '_'};

    public static boolean signUp(String login, String password, String confirmPassword) {
        try {
            if (login.length() > 20) throw new WrongLoginException();
            if (password.length() >= 20) throw new WrongPasswordException();
            if (password != confirmPassword) throw new WrongPasswordException();
            if(!containsOnly(login.toLowerCase(), String.valueOf(allowedCharacters))) throw new WrongLoginException();
            if(!containsOnly(password.toLowerCase(), String.valueOf(allowedCharacters))) throw new WrongPasswordException();
            return true;

        } catch (WrongLoginException exception) {
            System.out.println("Неверный ввод логина");

        } catch (WrongPasswordException exception) {
            System.out.println("Неверный ввод пароля");
        }
        return false;
    }
}
