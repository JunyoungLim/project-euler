package problems;

import utils.FileIO;

public class Problem089 extends Solution {
  private static final char[] ones  = new char[]{'I', 'X', 'C'};
  private static final char[] fives = new char[]{'V', 'L', 'D'};

  public static void main(String[] args) {
    new Problem089().run();
  }

  /**
   * Replace VIIII => IX (save 3 chars). Else, replace IIII => IV (save 2 chars).
   * Same for all other (one, five) pairs: (I, V), (X, L), (C, D), etc.
   */
  @Override
  public String solve() {
    String[] replacements = new String[ones.length];
    String[] altReplacements = new String[ones.length];
    for (int i = 0; i < ones.length; i++) {
      altReplacements[i] = String.valueOf(ones[i]).repeat(4);
      replacements[i] = fives[i] + altReplacements[i];
    }

    int numCharSaved = 0;
    for (String numeral : FileIO.readLines("p089.txt")) {
      for (int i = 0; i < replacements.length; i++) {
        if (numeral.contains(replacements[i])) numCharSaved += 3;
        else if (numeral.contains(altReplacements[i])) numCharSaved += 2;
      }
    }
    return String.valueOf(numCharSaved);
  }
}
