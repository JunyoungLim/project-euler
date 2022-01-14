package problems;

public class Problem104 extends Solution {
  private static final int MOD = 1000000000;

  public static void main(String[] args) {
    new Problem104().run();
  }

  @Override
  public String solve() {
    double logPhi = Math.log10((1 + Math.sqrt(5)) / 2);
    double logSqrt5 = Math.log10(Math.sqrt(5));
    int n = 3;
    for (int f1 = 1, f2 = 1; true; n++) {
      int tmp = f2;
      f2 = (f2 + f1) % MOD;
      f1 = tmp;
      if (!isPandigital(f2)) continue;
      double t = n * logPhi - logSqrt5;
      if (isPandigital((int) Math.pow(10, t - Math.floor(t) + 8))) break;
    }
    return String.valueOf(n);
  }

  private boolean isPandigital(int n) {
    int digits = 0, count = 0;
    for (int prevDigits = digits; n > 0; prevDigits = digits, n /= 10, count++) {
      digits |= 1 << (n % 10 - 1);
      if (prevDigits == digits) return false;
    }
    return digits == (1 << count) - 1;
  }
}
