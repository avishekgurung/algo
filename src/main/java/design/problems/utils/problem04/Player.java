package design.problems.utils.problem04;

public class Player {
  String name;
  int score;
  boolean winner;

  Player(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public boolean isWinner() {
    return winner;
  }

  public void setWinner(boolean winner) {
    this.winner = winner;
  }
}
