package test;

import java.util.Map;
import problems.*;
import org.junit.Test;
import utils.FileIO;

import static org.junit.Assert.assertEquals;

public class SolutionCheck {

  private static final Map<Integer, String> answers = FileIO.readAnswers();

  @Test public void checkProblem001() { assertEquals(answers.get(  1), new Problem001().solve()); }
  @Test public void checkProblem002() { assertEquals(answers.get(  2), new Problem002().solve()); }
  @Test public void checkProblem003() { assertEquals(answers.get(  3), new Problem003().solve()); }
  @Test public void checkProblem004() { assertEquals(answers.get(  4), new Problem004().solve()); }
  @Test public void checkProblem005() { assertEquals(answers.get(  5), new Problem005().solve()); }
  @Test public void checkProblem006() { assertEquals(answers.get(  6), new Problem006().solve()); }

  @Test public void checkProblem011() { assertEquals(answers.get( 11), new Problem011().solve()); }

  @Test public void checkProblem021() { assertEquals(answers.get( 21), new Problem021().solve()); }

  @Test public void checkProblem076() { assertEquals(answers.get( 76), new Problem076().solve()); }

  @Test public void checkProblem085() { assertEquals(answers.get( 85), new Problem085().solve()); }

  @Test public void checkProblem089() { assertEquals(answers.get( 89), new Problem089().solve()); }

  @Test public void checkProblem092() { assertEquals(answers.get( 92), new Problem092().solve()); }

  @Test public void checkProblem095() { assertEquals(answers.get( 95), new Problem095().solve()); }
  @Test public void checkProblem096() { assertEquals(answers.get( 96), new Problem096().solve()); }
}
