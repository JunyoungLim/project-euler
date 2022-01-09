/**
 *
 */
package problems;

/**
 * Problem007.java
 * @author JunyoungLim
 *
 * @version 1.00
 * @since Dec 15, 2014
 */
public class Problem007 {

  private static final int TARGET = 10001;

  public static void run() {
    int count = 1, num = 0;
    for (int i = 3; count != TARGET; i += 2) {
      if (isPrime(i)) {
        count++;
      }
      if (count == TARGET) {
        num = i;
      }
    }
    System.out.println(num);
  }

  public static boolean isPrime(int n) {
    if (n <= 3) {
      return n > 1;
    } else if (n % 2 == 0 || n % 3 == 0) {
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

// Answer is 104743
// Execution time is 8.283012 ms
