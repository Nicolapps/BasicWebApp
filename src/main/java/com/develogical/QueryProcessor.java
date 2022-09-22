package com.develogical;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        if (query.toLowerCase().contains("name")) {
            return "NE BC";
        }
        if (query.toLowerCase().contains("lorem")) {
            return "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        }

        Matcher m1 = Pattern.compile("what is (\\d+) plus (\\d+)").matcher(query);
        if (m1.find()) {
            String s1 = m1.group(1);
            String s2 = m1.group(2);
            int res = (Integer.parseInt(s1) + Integer.parseInt(s2));
            return Integer.toString(res);
        }

        Matcher m2 = Pattern.compile("which of the following numbers is the largest: (.+)").matcher(query);
        if (m2.find()) {
            String numbers = m2.group(1);
            String[] numbersStr = numbers.split(", ");

            int largest = Integer.MIN_VALUE;
            for (String x : numbersStr) {
                int toInt = Integer.parseInt(x);
                if (toInt > largest) largest = toInt;
            }

            return Integer.toString(largest);
        }


        return "";
    }
}
