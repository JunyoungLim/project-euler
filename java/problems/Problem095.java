package problems;

import java.util.HashSet;
import java.util.Set;
import utils.Benchmark;

public class Problem095 implements Solution {

  private static final int N = 1000000;

  public static void main(String[] args) {
    System.out.println(new Problem095().solve());
    System.out.println(Benchmark.run(new Problem095()::solve));
  }

  @Override
  public String solve() {
    // Compute divisor sum of each number under N.
    int[] divisorSum = new int[N + 1];
    for (int i = 2; i <= N; i++) {
      divisorSum[i] = 1;
      for (int j = 2, end = (int) Math.sqrt(i); j <= end; j++) {
        if (i % j == 0) divisorSum[i] += j + i / j;
      }
    }

    // Find the longest amicable chain.
    int longestChainLength = 0;
    int startNumOfLongestChain = 0;
    for (int startNum = 1; startNum <= N; startNum++) {
      Set<Integer> visited = new HashSet<>();
      int curNum = startNum;
      int curChainLength = 0;
      while (true) {
        curNum = divisorSum[curNum];
        curChainLength++;
        // If we find a cycle, break.
        if (curNum == startNum) {
          break;
        } // if an element exceeds N, or we get stuck in a local loop, skip this number.
        else if (N < curNum || visited.contains(curNum)) {
          curChainLength = -1;
          break;
        }
        visited.add(curNum);
      }
      if (curChainLength > longestChainLength) {
        longestChainLength = curChainLength;
        startNumOfLongestChain = startNum;
      }
    }

    // Find the smallest element in the longest chain found.
    int smallestNumOfLongestChain = startNumOfLongestChain;
    int curNum = startNumOfLongestChain;
    for (int i = 0; i < 28; i++) {
      smallestNumOfLongestChain = Math.min(curNum, smallestNumOfLongestChain);
      curNum = divisorSum[curNum];
    }
    return String.valueOf(smallestNumOfLongestChain);
  }
}
