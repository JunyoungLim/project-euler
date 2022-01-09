/**
 *
 */
package problems;

/**
 * Problem046.java
 * @author JunyoungLim
 *
 * @version 1.00
 * @since Mar 24, 2015
 */
public class Problem046 {
  // Because we don't know the limit of our calculation
  // we cannot make a sieve with definite length
  // I made a prime array with length 100 and gradually increased limit by factor of 10
  // 2D-array has first row of primality, and second row of whether the number is already checked

  private static boolean[][] isPrime = new boolean[2][100];

  public static void run() {
    for (int i = 35; ; i += 2) // all number up to 33 is explained in the problem
    {
      if (!isGoldbach(i)) {
        System.out.println(i);
        break;
      }
    }
  }

  public static boolean isGoldbach(int n) {
    if (isPrime(n)) {
      return true;
    } else {
      for (int i = 1, end = (int) Math.sqrt(n / 2); i <= end; i++) {
        if (isPrime(n - 2 * i * i)) {
          return true;
        }
      }
    }
    return false;
  }

  public static boolean isPrime(int n) {
    if (n >= isPrime[0].length) {
      boolean[][] temp = new boolean[2][isPrime[0].length * 10];
      System.arraycopy(isPrime[0], 0, temp[0], 0, isPrime[0].length);
      System.arraycopy(isPrime[1], 0, temp[1], 0, isPrime[1].length);
      isPrime = temp;
    }
    if (isPrime[1][n]) {
      return isPrime[0][n];
    } else {
      isPrime[0][n] = isP(n);
      isPrime[1][n] = true;
      return isPrime[0][n];
    }
  }

  public static boolean isP(int n) {
    if (n % 3 == 0) {
      return false;
    } else {
      for (int i = 5, end = (int) Math.sqrt(n); i <= end; i += 6) {
        if (n % i == 0 || n % (i + 2) == 0) {
          return false;
        }
      }
    }
    return true;
  }
}

// Answer is 5777
// Execution time is 1.878125 ms



