public class RegexpChecker implements Checker {

    @Override
    public boolean check(String s) {
        return s.matches("^\\w+$");
    }

    @Override
    public boolean isValid(String login) {
        return false;
    }
}
