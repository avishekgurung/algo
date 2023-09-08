package graph.utils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author ~ Avishek Gurung
 *
 * An implementation of Graph with both AdjMatrix and List
 */

public class GraphAdt {
    public char[] vertices;
    public int[][] adjMatrix;
    public Map<Character, LinkedList<Character>> adjList = new HashMap<>();
    public boolean isDirected;
    public Map<Character, Integer> indexMap;

    GraphAdt(char[] vertices, boolean isDirected) {
        this.vertices = vertices;
        this.isDirected = isDirected;
        for(int i=0; i < vertices.length; i++) {
            indexMap.put(vertices[i], i);
            adjList.put(vertices[i], new LinkedList<>());
        }
        adjMatrix = new int[vertices.length][vertices.length];
    }

    public void addEdge(char a, char b) {
        adjMatrix[indexMap.get(a)][indexMap.get(b)] = 1;
        if(!isDirected) {
            adjMatrix[indexMap.get(b)][indexMap.get(a)] = 1;
        }
        adjList.get(a).add(b);
    }

    public void addEdge(char a, char b, int weight) {

    }

}
