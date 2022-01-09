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
}
