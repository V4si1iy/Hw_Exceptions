import Exceptions.WrongLoginException;
import Exceptions.WrongPasswordException;

public class UserHandler {

    public static boolean signUp(String login, String password, String confirmPassword) {
        try {
            if(login.length()> 20) throw new WrongLoginException();
            if(password.length()>= 20) throw new WrongPasswordException();
            if(password != confirmPassword) throw new WrongPasswordException();
            return true;

        }
        catch (WrongLoginException exception)
        {
            System.out.println("Неверный ввод логина");
            return false;
        }
        catch (WrongPasswordException exception)
        {
            System.out.println("Неверный ввод пароля");
            return false;
        }
    }
}
