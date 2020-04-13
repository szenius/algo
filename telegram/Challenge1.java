/**
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 * Can you do this in one pass?
 */
import java.util.*;
class Challenge1 {
    private static boolean hasPairWithKSum(int[] arr, int k) {
        Set<Integer> unpaired = new HashSet<Integer>();
        for (int num : arr) {
            int complement = k - num;
            if (unpaired.contains(complement)) {
                return true;
            } else {
                unpaired.add(num);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasPairWithKSum(new int[]{10, 15, 2, 7}, 17));
    }
}