package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main( String[] args ) {

//        System.out.println(isMatcher("^([-+/*]\d+(\.\d+)?)*", "(3 + 5) – 9 × 4"));
//        System.out.println(getUsdRubEu("(\\d+\\.\\d{2} (USD|UA|RUB))", "30.06 USD 50,30 RUB 60.12 CHF 11,23 SEP 10000 UAH 100").toString());
//        System.out.println(isFind("[0-9]+[ ]*[+]", "(3 + 5) – 9 × 4");
        System.out.println(checkBracket("(3 + 5) – 9 × 4"));

    }
    // Task 0. RegEx: "abcdefghijklmnopqrstuv5320736"
    // Task 1. RegEx: "^[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}$"
    // Task 2. RegEx: "^([a-fA-F]{2}:){3}([0-9]{2}:){2}[0-9]{2}$"
    // Task 3. RegEx: "^(http|https)://(www.[a-zA-Z0-9]{2,}.[a-z]{2,3}|.[a-zA-Z0-9]{2,}.[a-z]{2,3})$"
    // Task 4. RegEx: "^#[fF0-9]{6}$"
    // Task 5. RegEx: "^(0[1-9]|[12]\d|3[01])/([0][1-9]|1[0-2])/((?:1[6-9]|[2-9]\d)\d{2})$"
    // Task 6. RegEx: "^([\\w]+)@([\\w]+).[a-zA-Z]{2,5}$"
    // Task 7. RegEx: "\\b(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\b"
    // Task 8. RegEx: "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[\\w]{8,}$"
    // Task 9. RegEx: "^[1-9]\d{5}$"
    // Task 12. RegEx: ??
    public static boolean isMatcher(String regEx, String line) {
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(line);
        return matcher.matches();
    }

    // Task 10. RegEx: "(\\d+\\.\\d{2} (USD|UA|RUB))"
    public static List<String> getUsdRubEu(String regEx, String line) {
        List<String> currency = new ArrayList<>();
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(line);
        while(matcher.find()){
            currency.add(matcher.group());
        }
        return currency;
    }

    // Task 11. RegEx: "[0-9]+[ ]*[+]"
    public static boolean isFind(String regEx, String line) {
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(line);
        return matcher.find();

    }

    public static boolean checkBracket(String str) {
        int a = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                a++;
            } else if(str.charAt(i) == ')') {
                a--;
            }
        }

        if(a == 0) {
            return true;
        } else {
            return false;
        }
    }
}
