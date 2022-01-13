package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FileIO {

  private static final String baseDir = System.getProperty("user.dir");
  private static final String resourcesDir = Paths.get(baseDir, "resources").toString();

  public static int[][] readSquareMatrix(int N, String fileName) {
    return readMatrix(N, N, fileName);
  }

  public static int[][] readMatrix(int numRows, int numCols, String fileName) {
    return readGrid(numRows, numCols, fileName, "\\s+");
  }

  public static List<int[][]> readSudokuGrids(int numGrids, String fileName) {
    List<String> lines = readLines(fileName);
    List<int[][]> sudokuGrids = new LinkedList<>();
    for (int i = 0; i < numGrids; i++) {
      sudokuGrids.add(readGrid(9, 9, lines.subList(1 + i * 10, 10 + i * 10), "(?!^)"));
    }
    return sudokuGrids;
  }

  private static int[][] readGrid(int numRows, int numCols, String fileName, String delimiter) {
    return readGrid(numRows, numCols, readLines(fileName), delimiter);
  }

  private static int[][] readGrid(int numRows, int numCols, List<String> lines, String delimiter) {
    int[][] text = new int[numRows][numCols];
    for (int i = 0; i < numRows; i++) {
      String[] splits = lines.get(i).trim().split(delimiter);
      for (int j = 0; j < numCols; j++) {
        text[i][j] = Integer.parseInt(splits[j]);
      }
    }
    return text;
  }

  public static byte[] readBytes(String fileName) {
    List<String> lines = readLines(fileName);
    String[] splits = lines.get(0).split(",");
    byte[] bytes = new byte[splits.length];
    for (int i = 0; i < bytes.length; i++) {
      bytes[i] = (byte) Integer.parseInt(splits[i]);
    }
    return bytes;
  }

  public static Map<Integer, String> readAnswers() {
    List<String> lines = readLines("answers.txt");
    Map<Integer, String> answers = new HashMap<>();
    for (String line : lines) {
      if (line.isEmpty()) continue;
      String[] splits = line.trim().split("\\.\\s+");
      answers.put(Integer.parseInt(splits[0]), splits[1]);
    }
    return answers;
  }

  public static List<String> readLines(String fileName) {
    String filePath = Paths.get(resourcesDir, fileName).toString();
    List<String> lines = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        lines.add(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return lines;
  }
}
