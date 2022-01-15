package problems;

import utils.FileIO;

public class Problem345 extends Solution {

  private static final int N = 15;

  public static void main(String[] args) {
    new Problem345().run();
  }

  @Override
  public String solve() {
    int[][] matrix = FileIO.readSquareMatrix(15, "p345.txt");
    int[] y = new int[N];
    for (int i = 0; i < N; i++) {
      y[i] = i;
    }

    for (int i = 0; i < N; i++) {
      int maxGain = Integer.MIN_VALUE;
      int maxJ = -1;
      for (int j = 0; j < N; j++) {
        int gain = (matrix[i][y[j]] + matrix[j][y[i]]) - (matrix[i][y[i]] + matrix[j][y[j]]);
        if (gain > maxGain) {
          maxGain = gain;
          maxJ = j;
        }
      }
      if (maxGain <= 0) {
        continue;
      }
      int temp = y[maxJ];
      y[maxJ] = y[i];
      y[i] = temp;
    }
    int sum = 0;
    for (int i = 0; i < N; i++) {
      sum += matrix[i][y[i]];
    }
    System.out.println(sum);
    return null;
  }

  public static void printCoordinates(int[][] matrix, int[] y) {
    for (int i = 0; i < N; i++) {
      System.out.print("(" + i + ", " + y[i] + ") ");
    }
    System.out.println();
    for (int i = 0; i < N; i++) {
      System.out.print(matrix[i][y[i]] + " ");
    }
    System.out.println();
  }

}
