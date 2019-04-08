package crucial.problems;


public class Problem002 {

  /**
   * The arrival array should always be sorted else we should sort it.
   * If i == j, means that arrival and dep of same train so we keep the count as 1.
   * if dep > arr of next train then we need to increase our platform count.
   * else
   *    we reset the logic.
   *
   * Time complexity = m + n = 2n (since m = n) = n;
   */
  public static int minPlatform(float arr[], float dep[]) {
    int i=0, j=0, count=0, minPlatform=0;

    while(i != arr.length && j != dep.length) {
      if(i == j) {
        count = 1;
        i++;
      }
      else if(dep[j] > arr[i]) {
        count++;
        i++;
      }
      else {
        minPlatform = Math.max(minPlatform, count);
        j++;
        count = 0;
      }
    }
    return minPlatform;
  }

  public static void util(float arr[], float dep[]) {
    System.out.println("Arr\t\tDep");
    for(int i=0; i < arr.length; i++) {
      System.out.println(arr[i] + "\t\t" + dep[i]);
    }
    System.out.println("Min Platform: " + minPlatform(arr, dep));
    System.out.println();
  }

  public static void main(String[] args) {
    util(
        new float[]{9.00f,  9.40f, 9.50f,  11.00f, 15.00f, 18.00f},
        new float[]{9.10f, 12.00f, 11.20f, 11.30f, 19.00f, 20.00f});

    util(
        new float[]{ 2.00f, 2.10f, 3.00f, 3.20f, 3.50f, 5.00f},
        new float[]{2.30f, 3.40f, 3.20f, 4.30f, 4.00f, 5.20f});

    util(
        new float[]{1.00f, 1.40f, 1.50f, 2.00f, 2.15f, 4.00f},
        new float[]{1.10f, 3.00f, 2.20f, 2.30f, 3.15f, 6.00f});
  }

}
/**
 * Another solution that requires nlogn is as follows:
 *
 arr[]  = {9:00,  9:40, 9:50,  11:00, 15:00, 18:00}
 dep[]  = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}

 All events sorted by time.
 Total platforms at any time can be obtained by subtracting total
 departures from total arrivals by that time.
 Time     Event Type     Total Platforms Needed at this Time
 9:00       Arrival                  1
 9:10       Departure                0
 9:40       Arrival                  1
 9:50       Arrival                  2
 11:00      Arrival                  3
 11:20      Departure                2
 11:30      Departure                1
 12:00      Departure                0
 15:00      Arrival                  1
 18:00      Arrival                  2
 19:00      Departure                1
 20:00      Departure                0

 Minimum Platforms needed on railway station = Maximum platforms
 needed at any time
 = 3
 Or the contigious arrivals or departure can give us the platform count as well.
 */

