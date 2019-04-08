package dp.classical;

public class Problem14 {

  public static int maxCut(int n) {
    if(n == 0 || n == 1)return 0;

    int maxVal = 0;

    for(int i=1; i < n; i++) {
      int val = Math.max(i * (n-i), maxCut(n - i) * i);
      maxVal = Math.max(maxVal, val);
    }

    return maxVal;
  }


  public static void main(String[] args) {
    int res = maxCut(10);
    System.out.println(res);
  }
}
