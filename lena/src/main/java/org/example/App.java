package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main( String[] args ) {
       // System.out.println(isMatcher("abcdefghijklmnopqrstuv5320736", "abcdefghijklmnopqrstuv5320736")); //Task 0.
       // System.out.println(isMatcher("^[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}$", "e02fd0e400fd090Aca300d00a0038ba0"));//Task1.
      
    }

    public static boolean isMatcher(String regEx, String str) {
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

}
