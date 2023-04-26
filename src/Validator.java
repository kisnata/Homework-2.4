import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Validator {
    private Validator() {
    }

    public static boolean validate(String login, String password, String confirmPassword) {
        try {
            check(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException s) {
            System.out.println(s.getMessage());
            return false;
        }
    }

    private static void check(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        if (Objects.isNull(login) || login.length() > 20) {
            throw new WrongLoginException("Длина логина должна быть меньше или равна 20!");
        }
        if (Objects.isNull(password) || password.length() >= 20) {
            throw new WrongPasswordException("Длина пароля должна быть меньше 20!");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли должны совпадать!");
        }
        Checker checker = ThreadLocalRandom.current().nextBoolean() ?
                new LoopChecker() :
                new RegexpChecker();
        if (!checker.isValid(login)) {
            throw new WrongLoginException("Логин содержит некорректные символы!");
        }
        if (!checker.isValid(password)) {
            throw new WrongPasswordException("Пароль содержит некорректные символы!");
        }
    }
}