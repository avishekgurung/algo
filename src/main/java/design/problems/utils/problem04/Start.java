package design.problems.utils.problem04;

import java.util.ArrayList;
import java.util.List;

public class Start {

  public static void main(String[] args) {
    Game game = new Game();

    List<Player> players = new ArrayList<Player>();
    Player p1 = new Player("Avishek");
    Player p2 = new Player("Sandhya");
    Player p3 = new Player("Bidhya");
    players.add(p1);
    players.add(p2);
    players.add(p3);

    Ladder l1 = new Ladder(1, 10);
    Ladder l2 = new Ladder(2, 11);
    Ladder l3 = new Ladder(3, 12);
    Ladder l4 = new Ladder(4, 13);
    Ladder l5 = new Ladder(5, 14);
    Ladder l6 = new Ladder(6, 15);
    List<Ladder> ladders = new ArrayList<Ladder>();
    ladders.add(l1);
    ladders.add(l2);
    ladders.add(l3);
    ladders.add(l4);
    ladders.add(l5);
    ladders.add(l6);


    Snake s1 = new Snake(15, 30);
    Snake s2 = new Snake(2, 58);
    Snake s3 = new Snake(6, 90);
    Snake s4 = new Snake(12, 38);
    Snake s5 = new Snake(27, 85);
    Snake s6 = new Snake(13, 77);
    List<Snake> snakes = new ArrayList<Snake>();
    snakes.add(s1);
    snakes.add(s2);
    snakes.add(s3);
    snakes.add(s4);
    snakes.add(s5);
    snakes.add(s6);

    game.start(players, ladders, snakes);
  }

}
