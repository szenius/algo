/**
 * https://leetcode.com/problems/multiply-strings/
 * TODO: can be more elegant
 */

 import java.util.*;

 class MultiplyStrings {

    private static String multiplyStrings(String s1, String s2) {
        List<String> intermediateResults = new ArrayList<>();

        // Collect all intermediate results
        for (int i = s1.length() - 1; i >= 0; i--) {
            StringBuilder tempResultBuilder = new StringBuilder();
            int carry = 0;
            for (int k = 0; k < s1.length() - 1 - i; k++) {
                tempResultBuilder.append("0");
            }
            for (int j = s2.length() - 1; j >= 0; j--) {
                // Pad end with zeroes
                // Compute multiplication for current bit
                int product = multiply(s1.charAt(j), s2.charAt(i)) + carry;
                carry = product / 10;
                tempResultBuilder.insert(0, product % 10);
            }
            intermediateResults.add(tempResultBuilder.toString());
        }

        // Add intermediate results together
        String result = "";
        for (int i = 0; i < intermediateResults.size(); i++) {
            result = addStrings(result, intermediateResults.get(i));
        }

        return result;
    }

    private static String addStrings(String s1, String s2) {
        StringBuilder resultBuilder = new StringBuilder();
        int length = Math.max(s1.length(), s2.length());
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int sum = add(s1.charAt(i), s2.charAt(j)) + carry;
            carry = sum / 10;
            resultBuilder.insert(0, sum % 10);
            i--;
            j--;
        }
        while (i >= 0) {
            int sum = Integer.parseInt(String.valueOf(s1.charAt(i))) + carry;
            carry = sum / 10;
            resultBuilder.insert(0, sum % 10);
            i--;
        }
        while (j >= 0) {
            int sum = Integer.parseInt(String.valueOf(s2.charAt(j))) + carry;
            carry = sum / 10;
            resultBuilder.insert(0, sum % 10);
            j--;
        }
        if (carry > 0) {
            resultBuilder.insert(0, String.valueOf(carry));
        }
        return resultBuilder.toString();
    }

    private static int add(char c1, char c2) {
        return Integer.parseInt(String.valueOf(c1)) + Integer.parseInt(String.valueOf(c2));
    }

    private static int multiply(char c1, char c2) {
        return Integer.parseInt(String.valueOf(c1)) * Integer.parseInt(String.valueOf(c2));
    }

     public static void main(String args[]) {
        System.out.println(multiplyStrings("123", "456"));
     }
 }