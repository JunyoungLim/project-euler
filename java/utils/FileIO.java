package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FileIO {

  private static final String baseDir = System.getProperty("user.dir");
  private static final String resourcesDir = Paths.get(baseDir, "resources").toString();

  public static int[][] readMatrix(int N, String fileName) {
    String filePath = Paths.get(resourcesDir, fileName).toString();
    int[][] text = new int[N][N];
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      String line;
      for (int i = 0; (line = br.readLine()) != null && i < N; i++) {
        String[] splits = line.trim().split("\\s+");
        for (int j = 0; j < N; j++) {
          text[i][j] = Integer.parseInt(splits[j]);
        }
      }
    } catch (IOException e) {
      System.err.println(e);
    }
    return text;
  }

  public static Map<Integer, String> readAnswers() {
    String filePath = Paths.get(resourcesDir, "answers.txt").toString();
    Map<Integer, String> answers = new HashMap<Integer, String>();
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] splits = line.trim().split("\\.\\s+");
        answers.put(Integer.parseInt(splits[0]), splits[1]);
      }
    } catch (IOException e) {
      System.err.println(e);
    }
    return answers;
  }
}
