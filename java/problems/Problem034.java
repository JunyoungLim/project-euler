/**
 *
 */
package problems;

/**
 * Problem034.java
 * @author JunyoungLim
 *
 * @version 1.00
 * @since Feb 3, 2015
 */
public class Problem034 {

  private static final int LIMIT = 1000000;
  private static int[] fact = new int[10];
  private static int[] factorialSum = new int[LIMIT];

  public static void run() {
    java.util.Arrays.fill(fact, 1);
    for (int i = 2; i < fact.length; i++) {
      fact[i] = fact[i - 1] * i;
    }

    for (int i = 0; i < fact.length; i++) {
      factorialSum[i] = fact[i];
    }

    int sum = 0;
    for (int i = 10; i < LIMIT; i++) {
      if (isFactorialSum(i)) {
        sum += i;
      }
    }

    System.out.println(sum);
  }

  public static boolean isFactorialSum(int n) {
    int sum = factorialSum[n / 10] + fact[n % 10];
    factorialSum[n] = sum;
    return n == sum;
  }
}

// Answer is 40730
// Execution time is 14.765319 ms

