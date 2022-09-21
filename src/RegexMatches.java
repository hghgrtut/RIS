import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {

    private static void isValidString(String pattern, String str) {
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(str);
        System.out.println(matcher.matches());
    }

    private final static String STRING_PATTERN = "abcdefghijklmnoasdfasdpqrstuv5320736";
    private final static String TWO_DIGIT_HEX_NUMBER = "[0-9A-Fa-f]{2}";
    private final static String MAC_PATTERN = "(" + TWO_DIGIT_HEX_NUMBER + ":){5}" + TWO_DIGIT_HEX_NUMBER;

    public static void main(String[] args) {

        String VALID_STRING = "abcdefghijklmnoasdfasdpqrstuv5320736";
        String NOT_VALID_STRING = "qqqqqq";

        String VALID_MAC = "11:11:11:11:11:11";
        String NOT_VALID_MAC = "1113311241121";

        isValidString(STRING_PATTERN, VALID_STRING);
        isValidString(STRING_PATTERN, NOT_VALID_STRING);
        isValidString(MAC_PATTERN, VALID_MAC);
        isValidString(MAC_PATTERN, NOT_VALID_MAC);
    }


}