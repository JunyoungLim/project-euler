package problems;

import java.util.Arrays;
import utils.Benchmark;

/**
 * Problem004.java
 * @author JunyoungLim
 *
 * @version 1.00
 * @since Dec 14, 2014
 */
public class Problem004 implements Solution {

  public static void main(String[] args) {
    System.out.println(new Problem004().solve());
  }

  @Override
  public String solve() {
    int ans = 0;
    for (int i = 999; i >= Math.sqrt(ans); i--) {
      for (int j = i; j >= 100; j--) {
        int prod = i * j;
        if (prod < ans) {
          break;
        } else if (isPalindrome(prod)) {
          ans = prod;
        }
      }
    }
    return String.valueOf(ans);
  }

  public boolean isPalindrome(int n) {
    if (n < 0) return false;
    if (n == 0) return true;
    int divisor = (int) Math.pow(10, (int) Math.log10(n));
    while (n > 0) {
      if (n / divisor != n % 10) return false;
      n %= divisor;
      n /= 10;
      divisor /= 100;
    }
    return true;
  }

  public boolean isPalindromeArray(int n) {
    if (n < 0) return false;
    if (n == 0) return true;
    int[] num = new int[(int) Math.log10(n) + 1];
    for (int i = 0; i < num.length; i++, n /= 10) {
      num[i] = n % 10;
    }
    for (int i = 0; i < (num.length + 1) / 2; i++) {
      if (num[i] != num[num.length - i - 1]) return false;
    }
    return true;
  }

  public boolean isPalindromeString(String n) {
    return (new StringBuffer(n).reverse().toString().equals(n));
  }

}