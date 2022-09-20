package org.example;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main( String[] args ) {
        System.out.println(isMatcher("^abcdefghijklmnopqrstuv5320736$", "abcdefghijklmnopqrstuv5320736"));
        System.out.println(isMatcher("\\b(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\b", "255.255.255.0"));
    }

    public static boolean isMatcher(String regEx, String line) {
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(line);
        return matcher.matches();
    }
}
