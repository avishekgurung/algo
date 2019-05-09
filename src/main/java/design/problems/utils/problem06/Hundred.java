package design.problems.utils.problem06;

public class Hundred implements Currency{

  public void process(int sum) {

    int noteCount = sum / Constants.HUNDRED;

    if(noteCount != 0) {
      System.out.println("Dispense " + noteCount + " * " + Constants.HUNDRED + " notes");
    }
  }
}
