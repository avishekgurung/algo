package dp.general;

public class Problem007 {

  static int []areaX = new int[]{3,2};
  static int []areaY = new int[]{-5,-10};
  static int []areaZ = new int[]{-20,5};

  /**
   * The logic is similar to finding a height of a tree.
   * If we have traversed one area then we will not traverse the other area.
   *
   * Some subproblems are solved multiple times so we will use the DP table.
   * This table should be generated for each area and for power A and power B.
   * Left as an exercise.
   */

  static int dp_X[][];
  static int dp_Y[][];
  static int dp_Z[][];

  public static int choiceOfArea(int powerA, int powerB, char area) {
    if(powerA < 0 || powerB < 0) return 0;
    if(area == 'Y')
    System.out.println(area + " " + powerA + " , " + powerB);
    int survivalCount = 0;
    if(area == 'X') {
      powerA += areaX[0];
      powerB += areaX[1];
      int ySurvivalCount = choiceOfArea(powerA,powerB, 'Y');
      int zSurvivalCount = choiceOfArea(powerA,powerB, 'Z');
      survivalCount = 1 + Math.max(ySurvivalCount,zSurvivalCount);
    }
    else if(area == 'Y') {
      powerA += areaY[0];
      powerB += areaY[1];
      int xSurvivalCount = choiceOfArea(powerA,powerB, 'X');
      int zSurvivalCount = choiceOfArea(powerA,powerB, 'Z');
      survivalCount = 1 + Math.max(xSurvivalCount,zSurvivalCount);
    }
    else if(area == 'Z') {
      powerA += areaZ[0];
      powerB += areaZ[1];
      int xSurvivalCount = choiceOfArea(powerA,powerB, 'X');
      int zSurvivalCount = choiceOfArea(powerA,powerB, 'Z');
      survivalCount = 1 + Math.max(xSurvivalCount,zSurvivalCount);
    }
    return survivalCount;
  }

  public static void choiceOfAreaUtil(int power[]) {
    int survivalCountStartingWithX = choiceOfArea(power[0], power[1], 'X');
    int survivalCountStartingWithY = choiceOfArea(power[0], power[1], 'Y');
    int survivalCountStartingWithZ = choiceOfArea(power[0], power[1], 'Z');
    int maxSurvivalCount = Math.max(Math.max(survivalCountStartingWithX,
        survivalCountStartingWithY),survivalCountStartingWithZ);
    System.out.println("The maximum survival is " + (maxSurvivalCount - 1));
  }

  public static void main(String[] args) {
    choiceOfAreaUtil(new int[]{20,8});
    //choiceOfAreaUtil(new int[]{5,10});
    //choiceOfAreaUtil(new int[]{0,0});
  }

}
