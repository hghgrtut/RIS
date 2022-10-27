import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Pattern p1 = Pattern.compile("([a-f]+[A-F]+:){3}+([0-9]{2}+:){2}+[0-9]{2}");
        Matcher m1 = p1.matcher( "aE:dC:cA:56:76:54" );
        boolean b = m1.matches();
        System.out.println(b);
    }

}
