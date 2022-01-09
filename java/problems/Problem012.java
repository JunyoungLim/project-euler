/**
 *
 */
package problems;

/**
 * Problem012.java
 * @author JunyoungLim
 *
 * @version 1.00
 * @since Dec 17, 2014
 */
public class Problem012 {

  public static void run() {
    int i = 1;
    for (int count = 0; count <= 500; i++) {
      if (i % 2 == 1) {
        count = countFactor((i + 1) / 2) * countFactor(i);
      } else {
        count = countFactor(i / 2) * countFactor(i + 1);
      }
    }
    System.out.println(
        (i - 1) * i / 2); //to get rid of extra increment of i at the end of the for loop
  }

  public static int countFactor(int n) {
    int count = 0, two = 1;
    while (n % 2 == 0) {
      two++;
      n /= 2;
    }
    int sqrt = (int) Math.sqrt(n);
    for (int i = 1; i <= sqrt; i += 2) {
      if (n % i == 0) {
        count += 2;
      }
    }
    if (n == sqrt * sqrt) {
      count--;
    }
    return count * two;
  }
}

// Answer is 76576500
// Execution time is 8.203672 ms

