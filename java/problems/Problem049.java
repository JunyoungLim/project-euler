/**
 *
 */
package problems;

/**
 * Problem049.java
 * @author JunyoungLim
 *
 * @version 1.00
 * @since May 18, 2015
 */
public class Problem049 {

  private static final int LIMIT = 10000;
  private static final boolean[] isPrime = primeList(LIMIT);

  public static void run() {
    int num = 0, next1 = 0, next2 = 0;

    for (int i = 1489; i < LIMIT; i += 2) // 1487 already proven in the problem
    {
      if (isPrime[i]) {
        for (int j = 2, end = (LIMIT - i) / 2; j < end;
            j += 2) // All sequences are prime; increment by 2
        {
          int seq1 = i + j, seq2 = seq1 + j;

          if (isPrime[seq1] && isPrime[seq2]) {
            if (isPermutation(i, seq1) && isPermutation(i, seq2)) {
              num = i;
              next1 = seq1;
              next2 = seq2;
            }
          }
        }
      }
      if (num != 0) {
        break;
      }
    }
    System.out.println("" + num + next1 + next2);
  }

  public static boolean isPermutation(int n, int m) {
    int[] digit = new int[10];

    while (n > 0) {
      digit[n % 10]++;
      n /= 10;
    }

    while (m > 0) {
      digit[m % 10]--;
      m /= 10;
    }

    for (int i = 0; i < digit.length; i++) {
      if (digit[i] != 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean[] primeList(int n) {
    //sieve of Eratosthenes
    boolean[] prime = new boolean[n + 1];
    java.util.Arrays.fill(prime, 2, prime.length, true);
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

// Answer is 296962999629
// Execution time is 6.057546 ms



