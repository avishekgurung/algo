package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test {

  private static Queue<String> queue = new LinkedList<String>();
  public static void receive(List<String> files) {
    for(String file : files) {
      queue.add(file);
    }
  }

  public static void give() {
    for(int i=0; i < 1000; i++) {
      if(!queue.isEmpty()) {
        try {
          System.out.println(queue.remove());
          Thread.sleep(5000);
        }
        catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }

  public static void main(String[] args) {

    List<String> files = new ArrayList<String>();
    files.add("myfile1.csv.gz");
    files.add("myfile2.csv.gz");
    files.add("myfile3.csv.gz");
    files.add("myfile4.csv.gz");
    files.add("myfile5.csv.gz");
    files.add("myfile6.csv.gz");
    receive(files);
    new Thread() {
      @Override public void run() {
        give();
      }
    }.start();

  }

}
