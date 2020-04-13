import java.util.*;

class Challenge2 {

    private static List<Integer> findPrimePairWithKSum(int num) {
        boolean[] isPrime = new boolean[num+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= num; i++) {
            if (isPrime(i)) {
                for (int j = 2; j * i <= num; j++) {
                    isPrime[j*i] = false;
                }
            }
        }

        List<Integer> resultPair = new ArrayList<>();
        for (int i = 1; i < isPrime.length; i++) {
            if (isPrime[i] && isPrime[num - i]) {
                resultPair.add(i);
                resultPair.add(num - i);
                break;
            }
        }
        return resultPair;
    }

    private static boolean isPrime(int num) {
        Set<Integer> primeNumbers = new HashSet<>(
            Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97)
        );
        return primeNumbers.contains(num);
    }

    private static void printPair(List<Integer> pair) {
        System.out.println(pair.get(0) + " " + pair.get(1));
    }
    public static void main(String[] args) {
        printPair(findPrimePairWithKSum(4));
        printPair(findPrimePairWithKSum(74));
        printPair(findPrimePairWithKSum(20));
    }
}