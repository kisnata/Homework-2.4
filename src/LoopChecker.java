public class LoopChecker implements Checker {

    private static final String ALLOWED_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_";

    @Override
    public boolean check(String s) {
        char[] chars = s.toCharArray();
        for (char symbol : chars) {
            if (ALLOWED_CHARACTERS.contains(Character.toString(symbol))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isValid(String login) {
        return false;
    }
}
