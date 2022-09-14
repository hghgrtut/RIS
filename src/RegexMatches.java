import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {

    private static void Match(String pattern) {
        String str;
        do {
            if(pattern.equals("([0-9A-Fa-f]{2}:){5}[0-9A-Fa-f]{2}"))
                System.out.println("Введите MAC-адрес:");
            else System.out.println("Введите строку "+ pattern +":");
            Scanner in = new Scanner(System.in);
            str = in.nextLine();
            if (str.equals("ВЫХОД")) {
                System.out.println("Вы вернулись в главное меню");
                break;
            }
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(str);
            if (m.matches()) {
                System.out.println("Всё так, как и должно быть");
            } else System.out.println("Не то, чего хотелось...");
            System.out.println("Если не хотите продолжать - введите 'Q'");
            in = new Scanner(System.in);
            String answer = in.nextLine();
            if  (answer.equals("Q")) {
                System.out.println("Вы вернулись в главное меню");
                break;
            }
            else System.out.println("Окей, продолжаем.");
        } while (true);
    }

    public static void main(String[] args) {
        String task;
        String[] patterns = {
                "abcdefghijklmnopqrstuv5320736",
                "([0-9A-Fa-f]{2}:){5}[0-9A-Fa-f]{2}"
        };
        do {
            System.out.println("Общее задание - 1\n" +
                    "Индивидуальное задание - 2\n" +
                    "(Для выхода введите \"ВЫХОД\")\n" +
                    "Введите номер задания:");
            Scanner in = new Scanner(System.in);
            task = in.nextLine();
            if (task.equals("1")) {
                Match(patterns[0]);
            }
            else if (task.equals("2")) {
                Match(patterns[1]);
            }
            else if (!task.equals("ВЫХОД")) System.out.println("Вы ввели кракозябру, попробуйте ещё раз:");
        } while (!task.equals("ВЫХОД"));
    }
}