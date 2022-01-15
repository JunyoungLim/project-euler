package problems;

import java.math.BigInteger;

public class Problem057 extends Solution {
  private BigInteger n;
  private BigInteger d;

  public static void main(String[] args) {
    new Problem057().run();
  }

  @Override
  public String solve() {
    n = BigInteger.valueOf(3);
    d = BigInteger.valueOf(2);
    int count = 0;
    for (int i = 0; i < 1000; i++) {
      if (n.toString().length() > d.toString().length()) count++;
      BigInteger tmp = d;
      d = n.add(d);
      n = d.add(tmp);
    }
    return String.valueOf(count);
  }

  @Override
  public void printExtraOutput() {
    System.out.println("n: " + n);
    System.out.println("d: " + d);
    System.out.println("Number of digits in n: " + n.toString().length());
    System.out.println("Number of digits in d: " + d.toString().length());
  }
}
