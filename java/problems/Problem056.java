package problems;

import java.math.BigInteger;

public class Problem056 extends Solution {
  public static void main(String[] args) {
    new Problem056().run();
  }

  @Override
  public String solve() {
    int digitSum = 0;
    for (int a = 2; a < 100; a++) {
      BigInteger base = BigInteger.valueOf(a);
      BigInteger prod = base;
      for (int b = 2; b < 100; b++) {
        prod = prod.multiply(base);
        int sum = prod.toString().chars().map(i -> i - '0').sum();
        digitSum = Math.max(digitSum, sum);
      }
    }
    return String.valueOf(digitSum);
  }
}
