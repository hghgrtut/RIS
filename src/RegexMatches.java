import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {

    public static void main(String args[]) {
        String str = "http://a.com";
        String pattern = "^https?:[0-9]{0,4}//[a-z]{2,}.[a-z(?=)#/^:]{1,}";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        System.out.println(m.matches());
    }

}

