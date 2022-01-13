package problems;

import utils.Benchmark;

public abstract class Solution {

  public abstract String solve();

  public void run() {
    System.out.println(Benchmark.run(() -> {
      System.out.println(solve());
    }));
    printExtraOutput();
  }

  public void printExtraOutput() {}
}