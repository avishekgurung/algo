package design.problems.utils.problem06;

public class Thousand  implements Currency{

  private Currency nextCurrency;

  Thousand(Currency nextCurrency) {
    this.nextCurrency = nextCurrency;
  }


  public void process(int sum) {

    int noteCount = sum / Constants.THOUSAND;
    int sumLeft = sum % Constants.THOUSAND;

    if(noteCount != 0) {
      System.out.println("Dispense " + noteCount + " * " + Constants.THOUSAND + " notes");
    }

    if(sumLeft != 0) {
      nextCurrency.process(sumLeft);
    }
  }
}
