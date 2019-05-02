package design.problems.utils.problem04;

//Represents every box in a board.
public class Node {
  int value;
  int next;
  boolean snakeHead;
  boolean snakeTail;
  boolean ladderHead;
  boolean ladderTail;

  Node(int value) {
    this.value = value;
  }

  public int getNext() {
    return next;
  }

  public void setNext(int next) {
    this.next = next;
  }

  public void setSnakeHead(boolean snakeHead) {
    this.snakeHead = snakeHead;
  }

  public void setSnakeTail(boolean snakeTail) {
    this.snakeTail = snakeTail;
  }

  public void setLadderHead(boolean ladderHead) {
    this.ladderHead = ladderHead;
  }

  public void setLadderTail(boolean ladderTail) {
    this.ladderTail = ladderTail;
  }
}
