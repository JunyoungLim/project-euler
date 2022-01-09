/**
 *
 */
package problems;

/**
 * Problem033.java
 * @author JunyoungLim
 *
 * @version 1.00
 * @since Feb 1, 2015
 */
public class Problem033 {

  public static void run() {
    int denom = 1, numer = 1;
    int count = 0;

    for (int n = 11; n <= 89; n++) {
      if (n % 10 == 0) {
        continue;
      }
      for (int d = n + 10; d <= 99; d++) {
        if (d % 10 == 0) {
          continue;
        }
        if (n % 10 == d / 10) {
          if ((n / 10) * d == n * (d % 10)) {
            numer *= n;
            denom *= d;
            count++;
          }
        }
      }
      if (count == 4) {
        break;
      }
    }
    System.out.println(denom / gcd(denom, numer));
  }

  public static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    } else {
      return gcd(b, a % b);
    }
  }
}

// Answer is 100
// Execution time is .771314 ms

