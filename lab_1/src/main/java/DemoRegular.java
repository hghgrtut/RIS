import java.util.regex.*;
public class DemoRegular {
public static void main(String[] args) {
// проверка на соответствие строки шаблону
    String str = "as39598fgh";
    String pattern = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[_]).{8,}";

    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(str);
    System.out.println(str + " " +m.matches());
}
}