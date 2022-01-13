package problems;

import utils.FileIO;

public class Problem059 extends Solution {
  private byte[] key;
  private byte[] decoded;

  public static void main(String[] args) {
    new Problem059().run();
  }

  @Override
  public String solve() {
    byte[] codes = FileIO.readBytes("p059.txt");
    this.key = findKey(codes);
    this.decoded = decrypt(codes, this.key);

    int asciiSum = 0;
    for (byte b : this.decoded) asciiSum += b;
    return String.valueOf(asciiSum);
  }

  @Override
  public void printExtraOutput() {
    System.out.println("[key]: " + byteArrayToAsciiString(this.key));
    System.out.println("[text]: " + byteArrayToAsciiString(this.decoded));
  }

  private static byte[] decrypt(byte[] codes, byte[] key) {
    byte[] text = new byte[codes.length];
    for (int i = 0; i < codes.length; i++) {
      text[i] |= codes[i] ^ key[i % 3];
    }
    return text;
  }

  private static byte[] findKey(byte[] codes) {
    int maxScore = 0;
    byte[] bestKey = null;
    for (byte a = 'a'; a <= 'z'; a++) {
      for (byte b = 'a'; b <= 'z'; b++) {
        for (byte c = 'a'; c <= 'z'; c++) {
          byte[] key = new byte[]{a, b, c};
          int score = score(codes, key);
          if (score > maxScore) {
            maxScore = score;
            bestKey = key;
          }
        }
      }
    }
    return bestKey;
  }

  private static int score(byte[] codes, byte[] key) {
    int score = 0;
    for (int i = 0; i < codes.length; i++) {
      int enc = codes[i];
      int dec = enc ^ key[i % 3];
      if (dec <= 31 || 127 <= dec) {
        return -1;
      } else if ('A' <= dec && dec <= 'Z') {
        score += 1;
      } else if ('a' <= dec && dec <= 'z') {
        score += 2;
      }
    }
    return score;
  }

  private static String byteArrayToAsciiString(byte[] bytes) {
    StringBuilder asciiText = new StringBuilder();
    for (byte b : bytes) asciiText.append((char) b);
    return asciiText.toString();
  }
}
