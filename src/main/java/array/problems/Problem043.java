package array.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Soln. We take two numbers at a time n1 and n2 and compare them as follows.
 * n1+n2 > n2+n1. Whichever is bigger is considered as a result.
 *
 * BUT first we need to sort and reverse the array so that we can start taking the largest numbers. Else, we will
 * not get correct answers.
 *
 * This will not work.
 *
 */
public class Problem043 {

  class StringComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
      String order1 = s1 + s2;
      String order2 = s2 + s1;
      return order2.compareTo(order1);
    }
  }


  public String largestNumber(Integer[] nums) {
    String arr[] = new String[nums.length];
    for(int i=0; i < arr.length; i++) arr[i] = nums[i] + "";
    System.out.println(Arrays.toString(arr));
    Arrays.sort(arr, new StringComparator());
    System.out.println(Arrays.toString(arr));
    String result = String.join("", Arrays.asList(arr));
    if(result.charAt(0) == '0') return "0";
    return result;
  }

  public void util() {
    System.out.println(largestNumber(new Integer[]{54, 546, 548, 60}));;
    System.out.println(largestNumber(new Integer[]{1, 34, 3, 98, 9, 76, 45, 4}));;
    System.out.println(largestNumber(new Integer[]{3,30,34,5,9}));
  }

  public static void main(String[] args) {
    new Problem043().util();
  }
}

/**
 * This problem comes with a variation that it can have large size integers which when compared using arithmetic
 * operation will be out of bound of the datatype. So we need to solve them based on string manipulation alone.
 */
