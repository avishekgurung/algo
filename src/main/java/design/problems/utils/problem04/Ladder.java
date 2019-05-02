package design.problems.utils.problem04;

public class Ladder extends Crawler {

  Ladder(int start, int end) {
    super(start, end);
    super.isLadder = true;
  }

  @Override
  public int generateSteps() {
    return end;
  }
}
