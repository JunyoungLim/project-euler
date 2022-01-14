package problems;

import java.math.BigInteger;
import java.util.List;
import utils.FileIO;

/**
 * Problem013.java
 * @author JunyoungLim
 *
 * @version 1.00
 * @since Dec 17, 2014
 */
public class Problem013 extends Solution {

  public static void main(String[] args) {
    new Problem013().run();
  }

  @Override
  public String solve() {
    List<String> nums = FileIO.readLines("p013.txt");
    BigInteger  sum = BigInteger.ZERO;
    for (String num : nums) {
      sum = sum.add(new BigInteger(num));
    }
    return sum.toString().substring(0, 10);
  }
}
