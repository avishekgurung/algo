package design.problems.utils.problem06;

public class Atm {

  private Currency hundred;
  private Currency twoHundred;
  private Currency thousand;


  private boolean validate(int sum) {

    if(sum % Constants.HUNDRED != 0) {
      return false;
    }
    return true;
  }

  Atm() {
    hundred = new Hundred();
    twoHundred = new TwoHundred(hundred);
    thousand = new Thousand(twoHundred);
  }

  public void dispense(int sum) {
    System.out.println("Transaction processing for " + sum);
    if(!validate(sum)) {
      System.out.println("Invalid sum entered. Please enter denominations of " + Constants.HUNDRED
          + "," + Constants.TWO_HUNDRED + " and " + Constants.THOUSAND);
      return;
    }
    thousand.process(sum);
    System.out.println("-------------------------\n");
  }

}
