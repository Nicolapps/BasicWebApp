package com.develogical;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

        Matcher mplusplus = Pattern.compile("what is (\\d+) plus (\\d+) plus (\\d+)").matcher(query);
        if (mplusplus.find()) {
            String s1 = mplusplus.group(1);
            String s2 = mplusplus.group(2);
            String s3 = mplusplus.group(3);
            int res = (Integer.parseInt(s1) + Integer.parseInt(s2) + Integer.parseInt(s3));
            return Integer.toString(res);
        }

        Matcher mouhasfiiufasdhuiof = Pattern.compile("what is (\\d+) multiplied by (\\d+) plus (\\d+)").matcher(query);
        if (mouhasfiiufasdhuiof.find()) {
            String s1 = mouhasfiiufasdhuiof.group(1);
            String s2 = mouhasfiiufasdhuiof.group(2);
            String s3 = mouhasfiiufasdhuiof.group(3);
            int res = (Integer.parseInt(s1) * Integer.parseInt(s2) + Integer.parseInt(s3));
            return Integer.toString(res);
        }

        Matcher m1 = Pattern.compile("what is (\\d+) plus (\\d+)").matcher(query);
        if (m1.find()) {
            String s1 = m1.group(1);
            String s2 = m1.group(2);
            int res = (Integer.parseInt(s1) + Integer.parseInt(s2));
            return Integer.toString(res);
        }


        Matcher mfib = Pattern.compile("hat is the (\\d*).* number in the Fibonacci sequence").matcher(query);
        if (mfib.find()) {
            String s1 = mfib.group(1);
            return Integer.toString(fib(Integer.parseInt(s1)));
        }

        Matcher mmmmmm = Pattern.compile("what is (-?\\d+) minus (-?\\d+)").matcher(query);
        if (mmmmmm.find()) {
            String s1 = mmmmmm.group(1);
            String s2 = mmmmmm.group(2);
            int res = (Integer.parseInt(s1) - Integer.parseInt(s2));
            return Integer.toString(res);
        }


        Matcher asuhdahuidfihu = Pattern.compile("what is (-?\\d+) divided by (-?\\d+)").matcher(query);
        if (asuhdahuidfihu.find()) {
            String s1 = asuhdahuidfihu.group(1);
            String s2 = asuhdahuidfihu.group(2);
            int res = (Integer.parseInt(s1) / Integer.parseInt(s2));
            return Integer.toString(res);
        }

        Matcher poqwermorew = Pattern.compile("what is (-?\\d+) to the power of (-?\\d+)").matcher(query);
        if (poqwermorew.find()) {
            String s1 = poqwermorew.group(1);
            String s2 = poqwermorew.group(2);
            int res = (int)Math.pow(Integer.parseInt(s1), Integer.parseInt(s2));
            return Integer.toString(res);
        }


        Matcher mx = Pattern.compile("what is (\\d+) multiplied by (\\d+)").matcher(query);
        if (mx.find()) {
            String s1 = mx.group(1);
            String s2 = mx.group(2);
            int res = (Integer.parseInt(s1) * Integer.parseInt(s2));
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

        Matcher m3 = Pattern.compile("which of the following numbers is both a square and a cube: (.+)").matcher(query);
        if (m3.find()) {
            String numbers = m3.group(1);
            String[] numbersStr = numbers.split(", ");

            int largest = Integer.MIN_VALUE;

            List<String> res = new ArrayList<>();
            for (String x : numbersStr) {
                int toInt = Integer.parseInt(x);

                if ((Math.sqrt(toInt) % 1) == 0 && (Math.cbrt(toInt) % 1) == 0) {
                    res.add(String.valueOf(toInt));
                }

                if (toInt > largest) largest = toInt;
            }

            return res.stream().collect(Collectors.joining(", "));
        }

        Matcher mPrimes = Pattern.compile("which of the following numbers are primes: (.+)").matcher(query);
        if (mPrimes.find()) {
            String numbers = mPrimes.group(1);
            String[] numbersStr = numbers.split(", ");

            List<String> res = new ArrayList<>();
            for (String x : numbersStr) {
                int toInt = Integer.parseInt(x);

                if (isPrime(toInt)) {
                    res.add(String.valueOf(toInt));
                }
            }

            return res.stream().collect(Collectors.joining(", "));
        }


        if (query.contains("Eiffel tower")) return "Paris";
        if (query.contains("banana")) return "Yellow";
        if (query.contains("Theresa May")) return "2016";


        return "";
    }

    // https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
    static int fib(int n)
    {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

    // https://www.educative.io/answers/how-to-check-if-a-number-is-prime-in-java
    static  boolean isPrime(int num)
    {
        if(num<=1)
        {
            return false;
        }
        for(int i=2;i<=num/2;i++)
        {
            if((num%i)==0)
                return  false;
        }
        return true;
    }

}
