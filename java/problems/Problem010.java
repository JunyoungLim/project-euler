/**
 *
 */
package problems;

import java.util.Arrays;

/**
 * Problem010.java
 * @author JunyoungLim
 *
 * @version 1.00
 * @since Dec 16, 2014
 */
public class Problem010 {

  private static final int LIMIT = 2000000;
  private static boolean[] isPrime = primeList(LIMIT);

  public static void run() {
    long sum = 2;
    for (int n = 3; n < isPrime.length; n += 2) {
      if (isPrime[n]) {
        sum += n;
      }
    }
    System.out.println(sum);
  }


  public static boolean[] primeList(int n) {
    //sieve of Eratosthenes
    boolean[] prime = new boolean[n + 1];
    Arrays.fill(prime, 2, prime.length, true);
    for (int i = 4; i < prime.length; i += 2) {
      prime[i] = false;
    }
    for (int i = 3, end = (int) Math.sqrt(n); i <= end; i += 2) {
      if (prime[i]) {
        for (int j = i * i; j <= n; j += 2 * i) {
          prime[j] = false;
        }
      }
    }
    return prime;
  }

}

// Answer is 142913828922
// Execution time is 15.336160 ms


