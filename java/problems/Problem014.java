/**
 *
 */
package problems;

/**
 * Problem014.java
 * @author JunyoungLim
 *
 * @version 1.00
 * @since Dec 17, 2014
 */
public class Problem014 {

  private static final int LIMIT = 1000000;
  private static int[] collatz = new int[LIMIT + 1];
  private static final int MAX = Integer.MAX_VALUE / 3;

  public static void run() {
    int num = 0, maxLength = 0;

    collatz[1] = 1;
    for (int i = LIMIT / 2 + 1; i <= LIMIT; i++) {
      fillCollatz(i);
      if (collatz[i] >= maxLength) {
        maxLength = collatz[i];
        num = i;
      }
    }
    System.out.println(num);
  }


  // fill the collatz array : memorization
  public static void fillCollatz(int n) {
    int count = 0;
    int current = n;
    for (; current >= n; count++) {
      if (current % 2 == 0) {
        current /= 2;
      } else if (current >= MAX) {
        long cur = current;
        for (; cur >= MAX; count++) {
          if (cur % 2 == 0) {
            cur /= 2;
          } else {
            cur += (cur + 1) / 2;
            count++;
          }
        }
        current = (int) cur;
        count--;
      } else {
        current += (current + 1) / 2;
        count++;
      }
    }
    collatz[n] = collatz[current] + count;
  }
}

// Answer is 837799
// Execution time is 38.619629 ms

