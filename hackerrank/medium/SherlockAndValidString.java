/**
 * https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SherlockAndValidString {

    // Complete the isValid function below.
    static String isValid(String s) {
        if (s.isEmpty()) {
            return "YES";
        }
        
        s = s.toLowerCase();
        
        // Count character frequencies
        int[] charFrequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charFrequency[s.charAt(i) - 'a']++;
        }
        
        // Count unique characters and find largest frequency
        int unique = 0;
        int highestFreq = 0;
        int lowestFreq = Integer.MAX_VALUE;
        int highestFreqOcc = 0;
        int lowestFreqOcc = 0;
        for (int i = 0; i < charFrequency.length; i++) {
            int currFreq = charFrequency[i];
            if (currFreq > 0) {
                unique++;
                if (currFreq > highestFreq) {
                    // Found new highest frequency character
                    highestFreq = currFreq;
                    highestFreqOcc = 1;
                } else if (currFreq < lowestFreq) {
                    // Found new lowest frequency character
                    lowestFreq = currFreq;
                    lowestFreqOcc = 1;
                } else if (currFreq == highestFreq) {
                    highestFreqOcc++;
                } else if (currFreq == lowestFreq) {
                    lowestFreqOcc++;
                }
            }
        }
                                
        // Left with cases where there are only two unique frequencies 
        // case 1: all equal, i.e. aabbcc
        // case 2: remove 1 from largest freq, i.e. aaabbcc
        // case 3: remove 1 from lowest freq, i.e. aabbc
        if (highestFreq == lowestFreq
            || (highestFreqOcc == 1 && (highestFreq - 1) * unique == s.length() - 1)
            || (lowestFreqOcc == 1 && highestFreq * (unique - 1) == s.length() - 1)) {
            return "YES";
        }
        
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
