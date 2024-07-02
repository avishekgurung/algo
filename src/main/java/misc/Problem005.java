package misc;

public class Problem005 {

  public static int getSetBits(int n) {
    int setBitCount = 0;

    int bitCount = getBitCount(n);
    int flip = 1;
    while(bitCount != 0) {
      boolean flag = false;
      int counter = 1;
      for(int i=0; i < n; i++) {

        if(counter <= flip) {
          flag = false;
          counter++;
        }

        else if(counter > flip && counter <= 2*flip) {
          flag = true;
          setBitCount++;
          if(counter == 2*flip) {
            counter = 1;
          }
          counter++;
        }
      }
      flip = flip * 2;
      bitCount--;
    }
    return setBitCount;
  }

  //Number of bits needed to represent a number
  public static int getBitCount(int n) {
    int k = 0;
    while(n != 0) {
      n = n / 2;
      k++;
    }
    return k;
  }

  public static void util(int n) {
    System.out.println("The number of set bits from 1 to " + n + " is " + getSetBits(n));
  }

  public static void main(String[] args) {
    //util(5);
    util(3);
    //util(17);
  }

}
