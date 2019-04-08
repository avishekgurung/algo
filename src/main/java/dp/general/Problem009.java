package dp.general;

import java.util.HashMap;
import java.util.Map;

public class Problem009 {

  private class Station {
    String name;
    int line;
    int time;

    Station(String name, int line, int time) {
      this.name = name;
      this.line = line;
      this.time = time;
    }
  }

  Station[] assemblyLine1 = new Station[3];
  Station[] assemblyLine2 = new Station[3];

  int entryTimeForA1 = 2;
  int entryTimeForA2 = 2;

  int exitTimeForA1 = 2;
  int exitTimeForA2 = 1;

  int transferTime = 2;

  Map<String, Integer> dp = new HashMap<String, Integer>();


  public void initiate() {
    Station ef1 = new Station("Engine fitting - 1", 1, 3);
    Station bf1 = new Station("Body fitting - 1", 1, 2);
    Station pn1 = new Station("Painting - 1", 1, 4);

    Station ef2 = new Station("Engine fitting - 2", 2, 6);
    Station bf2 = new Station("Body fitting - 2", 2, 1);
    Station pn2 = new Station("Painting - 2", 2, 1);

    assemblyLine1[0] = ef1;
    assemblyLine1[1] = bf1;
    assemblyLine1[2] = pn1;

    assemblyLine2[0] = ef2;
    assemblyLine2[1] = bf2;
    assemblyLine2[2] = pn2;
  }

  public int minChassisTime(Station[] assemblyLine, int index,boolean isAssembly1) {
    if(index >= assemblyLine.length) {
      return 0;
    }

    if(dp.get(assemblyLine[index].name) != null) return dp.get(assemblyLine[index].name);
    System.out.println(assemblyLine[index].name);
    int processingTime = assemblyLine[index].time;

    int time1, time2;

    time1 = minChassisTime(assemblyLine1, index + 1,true);
    time2 = minChassisTime(assemblyLine2, index + 1, false);
    if(isAssembly1) {
      time2 = time2 + transferTime;
    }
    else {
      time1 = time1 + transferTime;
    }

    if(index == assemblyLine.length - 1) {
      if(isAssembly1) {
        processingTime = processingTime + exitTimeForA1;
      }
      else {
        processingTime = processingTime + exitTimeForA2;
      }
    }
    int res = processingTime + Math.min(time1, time2);
    dp.put(assemblyLine[index].name, res);
    return res;
  }


  public static void main(String[] args) {
    Problem009 obj = new Problem009();
    obj.initiate();

    int assembly1Time = obj.minChassisTime(obj.assemblyLine1, 0, true) +
        obj.entryTimeForA1;
    int assembly2Time = obj.minChassisTime(obj.assemblyLine2, 0, false) +
        obj.entryTimeForA2;
    System.out.println("Minimum Time: " + Math.min(assembly1Time, assembly2Time));
  }

}
