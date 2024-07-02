package backtracking.problems;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.*;

/**
 * @author ~ Avishek Gurung
 */
public class Problem004 {
    public static void main(String[] args) {
        new Problem004().driver();
    }

    private void driver() {
        int arr[][] = {
            {1,1,1,1,1},
            {0,1,1,0,1},
            {0,1,1,1,1},
            {0,0,0,0,0},
            {0,0,0,0,0},
        };
        Node source = new Node(0,0);
        Node target = new Node(2,1);
        shortestPath(arr, source, target);

        //System.out.println("Longest path: " + longestPath(arr, source, target));

        System.out.println("Unique path: " + uniquePaths(arr, source, target, new HashMap<>()));

    }


    @Data
    @EqualsAndHashCode
    @AllArgsConstructor
    class Node {
        int i;
        int j;

        @Override
        public String toString() {
            return "("+i+","+j+")";
        }
    }

    /**
     * The shortest path has to be solved by BFS of Graph alone and we cannot use depth search as we have used in
     * longest distance.
     */
    private void shortestPath(int arr[][], Node source, Node target) {
        Map<Node, Integer> distance = new HashMap<>();
        Map<Node, String> path = new HashMap<>();
        distance.put(source, 0);
        path.put(source, source.toString());
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(source);

        while(!queue.isEmpty()) {
            Node node = queue.remove();
            if(node == target) break;
            if(!visited.contains(node)) {
                visited.add(node);
                List<Node> neighbors = new ArrayList<>();
                int i = node.i;
                int j = node.j;
                if(i-1 >= 0 && arr[i-1][j] == 1) neighbors.add(new Node(i-1, j));
                if(i+1 < arr.length && arr[i+1][j] == 1) neighbors.add(new Node(i+1, j));
                if(j-1 >=0 && arr[i][j-1] == 1) neighbors.add(new Node(i,j-1));
                if(j+1 < arr.length && arr[i][j+1] == 1) neighbors.add(new Node(i, j+1));

                for(Node neighbor : neighbors) {
                    if(!visited.contains(neighbor)) {
                        Integer newDistance = distance.get(node) + 1;
                        Integer oldDistance = distance.get(neighbor);
                        if(oldDistance == null || newDistance < oldDistance) {
                            distance.put(neighbor, newDistance);
                            path.put(neighbor, path.get(node) + " -> " + neighbor);
                            queue.add(neighbor);
                        }
                    }
                }
            }
        }
        System.out.println("Shortest Path: " + distance.get(target) + " : " + path.get(target));
    }


    /**
     * We cannot modify the shortest path problem here but we need to use depth first approach.
     */
    private int longestPath(int arr[][], Node source, Node target) {
        if(source == target) return 0;
        int i = source.i;
        int j = source.j;
        if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length) return 0;
        if(arr[i][j] == 0 || arr[i][j] == 2) return 0;
        arr[i][j] = 2;

        int top = longestPath(arr, new Node(i-1, j), target);
        int down = longestPath(arr, new Node(i+1, j), target);
        int left = longestPath(arr, new Node(i, j-1), target);
        int right = longestPath(arr, new Node(i, j+1), target);
        return top + left + right + down + 1;
    }

    private int uniquePaths(int arr[][], Node source, Node target, Map<String, Integer> map) {
        if(source.equals(target)) return 1;
        if(map.containsKey(source.toString())) return map.get(source.toString());
        int i = source.i;
        int j = source.j;
        if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length) return 0;
        if(arr[i][j] == 0 || arr[i][j] == 2) return 0;
        arr[i][j] = 2;

        int top = uniquePaths(arr, new Node(i-1, j), target, map);
        int down = uniquePaths(arr, new Node(i+1, j), target, map);
        int left = uniquePaths(arr, new Node(i, j-1), target, map);
        int right = uniquePaths(arr, new Node(i, j+1), target, map);
        int path = top + left + right + down;
        map.put(source.toString(), path);
        return path;
    }

}
