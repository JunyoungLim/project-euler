package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class Utils {
  public static int[][] readMatrix(int N, URL fileURL) {
    int[][] text = new int[N][N];
    File file = new File(fileURL.getFile());
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line;
      for (int i = 0; (line = br.readLine()) != null && i < N; i++) {
        String[] temp = line.trim().split("\\s+");
        for (int j = 0; j < N; j++) {
          text[i][j] = Integer.parseInt(temp[j]);
        }
      }
    } catch (IOException e) {
      System.err.println(e);
    }
    return text;
  }
}
