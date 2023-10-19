package backtracking.problems;

import java.util.Arrays;

/**
 * @author ~ Avishek Gurung
 */
public class Problem004 {
    private static boolean pathExists = false;


    private int longestPath(int i, int j, int endX, int endY, int arr[][]) {
        if(i < 0 || j < 0 || i >= arr.length || j >= arr[i].length) return 0;
        if(arr[i][j] == 1 && i == endX && j == endY) {
            pathExists = true;
            return 1;
        }
        if(arr[i][j] == 2 || arr[i][j] == 0) return 0;
        arr[i][j] = 2;

        int top = longestPath(i - 1, j, endX, endY, arr);
        int bottom = longestPath(i + 1, j, endX, endY, arr);
        int right = longestPath(i, j + 1, endX, endY, arr);
        int left = longestPath(i, j - 1, endX, endY, arr);

        int distances[] = new int[]{top, bottom, left, right};
        int maxDistance = 0;

        for(int k=0; k < distances.length; k++) {
            maxDistance = Math.max(maxDistance, distances[k]);
        }

        return maxDistance + 1;
    }

    private int shortestPath(int i, int j, int endX, int endY, int arr[][]) {
        if(i < 0 || j < 0 || i >= arr.length || j >= arr[i].length) return 0;
        if(arr[i][j] == 1 && i == endX && j == endY) {
            pathExists = true;
            return 1;
        }
        if(arr[i][j] == 2 || arr[i][j] == 0) return 0;

        arr[i][j] = 2;
        //System.out.println(i + " " + j);

        int top = shortestPath(i - 1, j, endX, endY, arr);
        int bottom = shortestPath(i + 1, j, endX, endY, arr);
        int right = shortestPath(i, j + 1, endX, endY, arr);
        int left = shortestPath(i, j - 1, endX, endY, arr);

        int distances[] = new int[]{top, bottom, left, right};
        int minDistance = Integer.MAX_VALUE;

        for(int k=0; k < distances.length; k++) {
            if(distances[k] > 0) minDistance = Math.min(minDistance, distances[k]);
        }

        if(minDistance == Integer.MAX_VALUE) minDistance = 0;
        return minDistance + 1;
    }

    private class Distance {
        String path;
        int distance;
        Distance(String path, int distance) {
            this.path = path;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "Distance: " + distance + ", Path: " + path;
        }
    }

    private Distance shortestPathWithPath(int i, int j, int endX, int endY, int arr[][], Distance distance) {
        if(i < 0 || j < 0 || i >= arr.length || j >= arr[i].length) return null;
        if(arr[i][j] == 1 && i == endX && j == endY) {
            pathExists = true;
            return new Distance("("+i+","+j+")", 1);
        }
        if(arr[i][j] == 2 || arr[i][j] == 0) return null;

        arr[i][j] = 2;
        //System.out.println(i + " " + j);

        Distance top = shortestPathWithPath(i - 1, j, endX, endY, arr, distance);
        Distance bottom = shortestPathWithPath(i + 1, j, endX, endY, arr, distance);
        Distance right = shortestPathWithPath(i, j + 1, endX, endY, arr, distance);
        Distance left = shortestPathWithPath(i, j - 1, endX, endY, arr, distance);

        Distance distances[] = new Distance[]{top, bottom, left, right};
        int minDistance = Integer.MAX_VALUE;
        String minPath = "";

        for(int k=0; k < distances.length; k++) {
            if(distances[k] != null && minDistance < distances[k].distance) {
                minDistance = distances[k].distance;
                minPath = distances[k].path;
            }
        }

        if(minDistance == Integer.MAX_VALUE) {
            minDistance = 0;
            minPath = "";
        }
        distance.path = minPath + " - " + distance.path;
        distance.distance = minDistance + 1;
        return distance;
    }

    public static void main(String[] args) {

        Problem004 _instance = new Problem004();
        int arr[][] = {
                {1, 0, 0, 0, 0, 0, 0, 0 },
                {1, 0, 0, 0, 0, 0, 0, 0 },
                {1, 0, 0, 0, 0, 0, 0, 0 },
                {1, 1, 1, 1, 1, 1, 0, 0 },
                {1, 0, 0, 0, 0, 1, 0, 0 },
                {1, 0, 0, 0, 0, 1, 0, 0 },
                {1, 1, 1, 1, 1, 1, 0, 0 }};

        int sx = 0;
        int sy = 0;
        int ex = 3;
        int ey = 2;

        /*int minDistance = _instance.shortestPath(sx, sy, ex, ey, arr);
        if(pathExists) {
            System.out.println("Minimum distance = " + (minDistance - 1));
        } else {
            minDistance = -1;
            System.out.println("Minimum distance = " + (minDistance));
        }*/

        /*
        int maxDistance = _instance.longestPath(sx, sy, ex, ey, arr);
        if(pathExists) {
            System.out.println("Maximum distance: " + (maxDistance - 1));
        } else {
            maxDistance = -1;
            System.out.println("Maximum distance: " + maxDistance);
        }*/


        //_instance.util();
        _instance.uniquePathsUtil();


    }

    private int uniquePaths(int i, int j, int iEnd, int jEnd, int arr[][]) {
        if(i < 0 || j < 0 || i >= arr.length || j >= arr[i].length) return 0;

        // If the path is blocked with 0 or 2 (cell marker)
        if(arr[i][j] != 1) return 0;

        //We reached the destination and it should not be marked as visited for other paths.
        if(i == iEnd && j == jEnd) return 1;

        arr[i][j] = 2; // Marking the visited cell.

        int top     = uniquePaths(i-1, j, iEnd, jEnd, arr);
        int right   = uniquePaths(i, j+1, iEnd, jEnd, arr);
        int bottom  = uniquePaths(i+1, j, iEnd, jEnd, arr);
        int left    = uniquePaths(i, j-1, iEnd, jEnd, arr);

        return top + right + bottom + left;
    }

    private void uniquePathsUtil() {
        Problem004 _instance = new Problem004();
        int arr[][] = {
                {1, 0, 0, 0, 0, 0, 0, 0 },
                {1, 0, 0, 0, 0, 0, 0, 0 },
                {1, 0, 0, 0, 0, 0, 0, 0 },
                {1, 1, 1, 1, 1, 1, 0, 0 },
                {1, 0, 0, 0, 0, 1, 0, 0 },
                {1, 0, 0, 0, 0, 1, 0, 0 },
                {1, 1, 1, 1, 1, 1, 0, 0 }};
        int sx = 0;
        int sy = 0;
        int ex = 3;
        int ey = 2;

        int uniquePaths = _instance.uniquePaths(sx, sy, ex, ey, arr);
        System.out.println("The number of unique paths are: " + uniquePaths);

    }

    private void util() {

        Problem004 _instance = new Problem004();
        int arr[][] = {
                {1, 0, 0, 0, 0, 0, 0, 0 },
                {1, 0, 0, 0, 0, 0, 0, 0 },
                {1, 0, 0, 0, 0, 0, 0, 0 },
                {1, 1, 1, 1, 1, 1, 0, 0 },
                {1, 0, 0, 0, 0, 1, 0, 0 },
                {1, 0, 0, 0, 0, 1, 0, 0 },
                {1, 1, 1, 1, 1, 1, 0, 0 }};

        int sx = 0;
        int sy = 0;
        int ex = 1;
        int ey = 1;

        Distance distance = _instance.shortestPathWithPath(sx, sy, ex, ey, arr, new Distance("", 0));
        System.out.println(distance);

    }

}
