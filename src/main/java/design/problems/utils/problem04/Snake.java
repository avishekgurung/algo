package design.problems.utils.problem04;

public class Snake extends Crawler {

  Snake(int start, int end) {
    super(start, end);
    super.isSnake = true;
  }

  @Override
  public int generateSteps() {
    return -start;
  }
}
