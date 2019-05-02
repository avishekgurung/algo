package design.problems.utils.problem04;

abstract class Crawler {

  int start;
  int end;
  boolean isSnake;
  boolean isLadder;

  Crawler(int start, int end) {
    this.start = start;
    this.end = end;
  }

  public void setSnake(boolean snake) {
    isSnake = snake;
  }

  public void setLadder(boolean ladder) {
    isLadder = ladder;
  }

  public abstract int generateSteps();
}
