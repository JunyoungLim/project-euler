/**
 *
 */
package problems;

import java.math.BigInteger;

/**
 * Problem015.java
 * @author JunyoungLim
 *
 * @version 1.00
 * @since Dec 18, 2014
 */
public class Problem015 {

  public static void run() {
    BigInteger num = BigInteger.ONE;

    for (int i = 21; i <= 40; i++) {
      num = num.multiply(BigInteger.valueOf(i));
    }

    for (int i = 2; i <= 20; i++) {
      num = num.divide(BigInteger.valueOf(i));
    }

    System.out.println(num);
  }
}

// Answer is 137846528820
// Execution time is 3.516281 ms

