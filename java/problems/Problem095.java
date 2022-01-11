package problems;

import java.util.HashSet;
import java.util.Set;

public class Problem095 extends Solution {

  private static final int N = 1000000;

  public static void main(String[] args) {
    new Problem095().run();
  }

  @Override
  public String solve() {
    // Compute divisor sum of each number not exceeding N.
    int[] divisorSum = new int[N + 1];
    for (int i = 2; i <= N; i++) {
      divisorSum[i] = 1;
      int sqrt = (int) Math.sqrt(i);
      for (int j = 2; j < sqrt; j++) {
        if (i % j == 0) divisorSum[i] += j + i / j;
      }
      if (i % sqrt == 0) divisorSum[i] += sqrt;
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
    for (int i = 0; i < longestChainLength; i++) {
      smallestNumOfLongestChain = Math.min(curNum, smallestNumOfLongestChain);
      curNum = divisorSum[curNum];
    }
    return String.valueOf(smallestNumOfLongestChain);
  }
}
