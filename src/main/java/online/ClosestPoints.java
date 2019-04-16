package online;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;


public class ClosestPoints {



  // Complete the closestSquaredDistance function below.
  static long closestSquaredDistance(List<Integer> x, List<Integer> y) {
    long closest = Long.MAX_VALUE;
    List<Point> points = new ArrayList<Point>();
    for (int i = 0; i < x.size(); i++) {
      Point point = new Point(x.get(i), y.get(i));
      points.add(point);
    }

    for (int i = 0; i < x.size(); i++) {
      for (int j = i + 1; j < y.size(); j++) {
        Point X = points.get(i);
        Point Y = points.get(j);
        long distanceX = (Y.x - X.x) * (Y.x - X.x);
        long distanceY = (Y.y - X.y) * (Y.y - X.y);
        long distance = distanceX + distanceY;
        closest = Math.min(closest, distance);
      }
    }
    return closest;
  }

  private static class Point {
    int x;
    int y;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) {
    List<Integer> l1 = new ArrayList<Integer>();
    l1.add(543243);
    l1.add(5000);


    List<Integer> l2 = new ArrayList<Integer>();
    l2.add(0);
    l2.add(322);


    long distance = closestSquaredDistance(l1, l2);
    System.out.println(distance);
  }
}
