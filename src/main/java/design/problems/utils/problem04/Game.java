package design.problems.utils.problem04;

import java.util.List;
import java.util.Random;

public class Game {
  static int totalThrows = 0;
  Node[] nodes;
  Snake[] snakes;
  Ladder[] ladders;
  List<Player> players;

  Game() {
    nodes = new Node[101];
    for(int i=1; i <= 100; i++) {
      nodes[i] = new Node(i);
    }
  }

  public void addSnake(Snake snake) {
    int steps = snake.generateSteps();
    nodes[snake.end].setNext(steps);
    nodes[snake.end].snakeHead = true;
  }

  public void addLadder(Ladder ladder) {
    int steps = ladder.generateSteps();
    nodes[ladder.start].setNext(steps);
    nodes[ladder.start].ladderTail = true;
  }

  public void computeScore(Player player, int currentThrow) {
    int score = player.score + currentThrow;
    if(score <= 100) {
      Node node = nodes[score];
      if(node.ladderTail) {
        score = score + node.getNext();
      }
      if(node.snakeHead) {
        score = score + node.getNext();
      }
      player.setScore(score);
    }
  }

  public boolean play(Player player) {

    while(true) {
      int currentThrow = getDiceThrow();
      computeScore(player, currentThrow);
      totalThrows++;
      if(currentThrow != 6) {
        break;
      }
    }

    if(player.score == 100) return true;
    return false;
  }

  public void start(List<Player> players, List<Ladder> ladders, List<Snake> snakes) {
    for(Ladder ladder : ladders) addLadder(ladder);
    for(Snake snake : snakes) addSnake(snake);

    System.out.println("Game started!");

    while(true) {
      boolean exit = false;
      for(Player player : players) {
        if(play(player)) exit = true;
      }
      if(exit) break;
    }
    computeResult(players);
  }

  public static void computeResult(List<Player> players) {
    Player winner = null;
    for(Player player : players) {
      if(player.getScore() == 100) {
        winner = player;
      }
      System.out.println(player.getName() + " : " + player.getScore());
    }
    System.out.println("The winner is " + winner.getName());
    System.out.println("The total throws in the game is " + totalThrows );
  }

  public int getDiceThrow() {
    Random random = new Random();
    return random.nextInt(6) + 1;
  }
}
