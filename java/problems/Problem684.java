package problems;

import java.util.ArrayList;
import java.util.List;

public class Problem684 {

  private static final int N = 90;
  private static final long mod = 1000000007;

  public static void main(String[] args) {
    sSequence(fibSequence(N)[N]);
  }
  public static void madin(String[] args) {
    long[] fib = fibSequence(N);
    long sum = 0;
    long s = 0;
    long S = 0;
    int fibIndex = 2;
    for (long n = 1, inc = 1, incCount = 1; fibIndex <= N; n++, incCount++) {
      s = (s + inc) % mod;
      S = (S + s) % mod;
      System.out.println(n + ": " + s + " " + S);
      if (incCount == 9) {
        inc = (inc * 10) % mod;
        incCount = 0;
      }
      if (n == fib[fibIndex]) {
        sum = (sum + S) % mod;
        fibIndex++;
      }
    }
    System.out.println(sum);
  }

  private static List<Long> SSequence(List<Long> s, long n) {
    List<Long> S = new ArrayList<>();
    S.add(s.get(0));
    for (int i = 1; i < n + 1; i++) {
      S.add((S.get(i - 1) + s.get(i)) % mod);
    }
    return S;
  }

  private static List<Long> sSequence(long n) {
    List<Long> s = new ArrayList<>();
    s.add(0L);
    for (int i = 1, inc = 1, incCount = 1; i <= n; i++, incCount++) {
      s.add((s.get(i - 1) + inc) % mod);
      if (incCount == 9) {
        inc *= 10;
        incCount = 0;
      }
    }
    return s;
  }

  private static long[] fibSequence(int n) {
    long[] fib = new long[n + 1];
    fib[1] =  1;
    for (int i = 2; i <= n; i++) {
      fib[i] = fib[i - 2] + fib[i - 1];
    }
    return fib;
  }
}
