import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        boolean result = Validator.validate("test_1234", " D_1hWiKjjP_9", " D_1hWiKjjP_9");
        if (result) {
            System.out.println("Логин и пароль корректные");
        } else {
            System.out.println("Логин и/или пароль некорректный");
        }
    }
}