import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Laba1 {

    public static void main(String args[]) {
        String str = "#FFFFFF";
        String pattern = "#[0-9a-fA-F]{6}";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        System.out.println(m.matches());
    }

}