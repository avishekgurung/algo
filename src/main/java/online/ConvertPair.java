package online;

public class ConvertPair {

  public static boolean convert(int a, int b, int c, int d) {
    if(a == c && b == d) return true;
    if(a > c || b > d) return false;

    boolean first = convert(a, a + b, c, d);
    boolean second = convert(a + b, b, c, d);
    return first || second;
  }


  public static void main(String[] args) {
    System.out.println(convert(1,4 ,5 ,9 ));
    System.out.println(convert(1,2 ,3 ,6 ));
  }

}
