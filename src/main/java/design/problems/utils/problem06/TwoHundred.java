package design.problems.utils.problem06;

public class TwoHundred implements Currency {

  private Currency nextCurrency;

  TwoHundred(Currency nextCurrency) {
    this.nextCurrency = nextCurrency;
  }

  public void process(int sum) {

    int noteCount = sum / Constants.TWO_HUNDRED;
    int sumLeft = sum % Constants.TWO_HUNDRED;

    if(noteCount != 0) {
      System.out.println("Dispense " + noteCount + " * " + Constants.TWO_HUNDRED + " notes");
    }

    if(sumLeft != 0) {
      nextCurrency.process(sumLeft);
    }
  }
}
