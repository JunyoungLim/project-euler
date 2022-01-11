package problems;

import java.util.List;
import utils.FileIO;

public class Problem096 extends Solution {

  public static void main(String[] args) {
    new Problem096().run();
  }

  @Override
  public String solve() {
    List<int[][]> sudokuGrids = FileIO.readSudokuGrids(50, "p096.txt");
    int sum = 0;
    for (int[][] sudoku : sudokuGrids) {
      solve(sudoku, 0);
      sum += sudoku[0][0] * 100 + sudoku[0][1] * 10 + sudoku[0][2];
    }
    return String.valueOf(sum);
  }

  private boolean solve(int[][] sudoku, int index) {
    if (index == 81) return true;
    int r = index / 9, c = index % 9;
    if (sudoku[r][c] != 0) {
      return solve(sudoku, index + 1);
    } else {
      for (int d = 1; d <= 9; d++) {
        if (isValid(sudoku, r, c, d)) {
          sudoku[r][c] = d;
          if (solve(sudoku, index + 1)) return true;
        }
      }
      sudoku[r][c] = 0;
      return false;
    }
  }

  private boolean isValid(int[][] sudoku, int r, int c, int d) {
    int br = r / 3 * 3, bc = c / 3 * 3;
    for (int i = 0; i < 9; i++) {
      if (sudoku[r][i] == d) return false;
      if (sudoku[i][c] == d) return false;
      if (sudoku[br + i / 3][bc + i % 3] == d) return false;
    }
    return true;
  }
}
