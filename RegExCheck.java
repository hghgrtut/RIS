import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExCheck {

    public static void main(String args[]) {
        //General task
        {
            String[] generalCheck = {"abcdefghijklmnopqrstuv5320736",
                    "abcdefghijklmnoasdfasdpqrstuv5320736",
                    "abcdefghijklmnopqrstuv5320736 t"};
            String generalRegex = "abcdefghijklmnopqrstuv5320736";
            System.out.println("\n - General task\nRegex: " + generalRegex);
            check(generalRegex, generalCheck);
        }

        //Individual task - Variant 8
        {
            String[] individualCheck = {"C00l_Pass",
                    "SupperPas1",
                    "Cool_pass",
                    "C001",
                    "Wrong pa55"};
            String individualRegex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(\\w){8,}";
            System.out.println("\n - Individual task\nRegex: " + individualRegex);
            check(individualRegex, individualCheck);
        }
    }

    public static boolean match(String regex, String input)
    {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        return m.matches();
    }

    public static void check(String regex, String[] inputArray)
    {
        System.out.println("Matches:");
        for(String input : inputArray) {
            System.out.println(input +
                    (match(regex, input) ? " +" : " -"));
        }
    }
}
