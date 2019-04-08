package dp.general;

public class Problem001 {

  public static int catalanRecursion(int n) {
    if(n <= 0) return 1;

    int result = 0;

    for(int i=0; i < n; i++) {
      result = result + catalanRecursion(i) * catalanRecursion(n - i - 1);
    }
    return result;
  }

  public static int catalanIteration(int n) {
    int mem[] = new int[n + 1];
    mem[0] = 1;
    mem[1] = 1;

    for(int i=2; i <= n; i++) {
      for(int j=0; j < i; j++) {
        mem[i] = mem[i] + mem[j] * mem[i-j-1];
      }
    }
    return mem[n];
  }

  public static void main(String[] args) {
    System.out.println(catalanRecursion(4));
    System.out.println(catalanIteration(4));
  }

}
