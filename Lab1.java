import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab1 {

    public static void main(String args[]) {
        String str = "123456";
        String pattern = "[1-9][0-9]{5}";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        System.out.println(m.matches());
    }

}