package practice;

import java.util.*;

public class LabTest {

  public static void main(String args[]){
    long res = 1;
    int n = 20;

    while(n != 0) {
      res = res * n;
      n--;
    }

    System.out.println(res);
  }

}
