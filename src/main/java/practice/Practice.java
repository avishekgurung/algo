package practice;


import java.util.*;


public class Practice {

    private class Graph {
        char[] vertices;
        int[][] adjMatrix;
        Map<Character, Integer> indexMap = new HashMap<>();
        Map<Character, LinkedList<Node>> adjList = new HashMap<>();
        boolean isDirected = false;

        Graph(char[] vertices, boolean isDirected) {
            this(vertices);
            this.isDirected = isDirected;
        }

        Graph(char[] vertices) {
            this.vertices = vertices;
            this.adjMatrix = new int[vertices.length][vertices.length];
            for(int i=0; i < vertices.length; i++) {
                indexMap.put(vertices[i], i);
                adjList.put(vertices[i], new LinkedList<>());
            }
        }

        void addEdge(char a, char b) {
            adjMatrix[indexMap.get(a)][indexMap.get(b)] = 1;
            adjList.get(a).add(new Node(b, 1));
            if(!isDirected) {
                adjMatrix[indexMap.get(b)][indexMap.get(a)] = 1;
                adjList.get(b).add(new Node(a, 1));
            }
        }

        void addEdge(char a, char b, int weight) {
            adjMatrix[indexMap.get(a)][indexMap.get(b)] = weight;
            adjList.get(a).add(new Node(b, weight));
            if(!isDirected) {
                adjMatrix[indexMap.get(b)][indexMap.get(a)] = weight;
                adjList.get(b).add(new Node(a, weight));
            }
        }

        void showMatrix() {
            System.out.println("\t" + Arrays.toString(vertices) + "\n");
            for(int i=0; i < vertices.length; i++) {
                System.out.println(vertices[i] + "\t" + Arrays.toString(adjMatrix[i]));
            }
        }

        void showList() {
            System.out.println();
            for(int i=0; i < vertices.length; i++) {
                System.out.println(vertices[i] + "\t" + adjList.get(vertices[i]));
            }
        }
    }

    private class Node {
        char label;
        int weight;
        String extra;

        Node(char label, int weight) {
            this.label = label;
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return "(" + label + "," + weight + ")";
        }
    }

    public static void main(String[] args) {
        new Practice().run();
    }

    private void run() {
        char[] vertices = {'A', 'B', 'C', 'D', 'E'};
        Graph graph = new Graph(vertices);
        graph.addEdge('A', 'B', 2);
        graph.addEdge('A', 'C', 15);
        graph.addEdge('C', 'D', 3);
        graph.addEdge('B', 'E', 2);
        graph.addEdge('A', 'E', 2);
        graph.addEdge('D', 'E', 2);

        /*char[] vertices = {'A', 'B', 'C', 'D'};
        Graph graph = new Graph(vertices);
        graph.addEdge('A', 'B', 2);
        graph.addEdge('B', 'D', 1);
        graph.addEdge('C', 'D', -2);
        graph.addEdge('A', 'C', 4);*/

        minimalSpanningTree(graph, 'A');
        //shortestPathWithNegativeWeight(graph, 'A');

        //dfsWithList(graph, 'A', new HashSet<>());
        //bfsWithList(graph, 'A');
        //topologicalSort(graph);
        //shortestPathNonWeighted(graph, 'A');
    }

    private void minimalSpanningTree(Graph graph, char vertex) {
        int size = graph.vertices.length;
        Comparator<Node> comparator = Comparator.comparing(Node::getWeight);
        PriorityQueue<Node> heap = new PriorityQueue<>(comparator);
        heap.add(new Node(vertex, 0));
        Set<Character> visited = new HashSet<>();
        List<String> minTree = new LinkedList<>();


        while(!heap.isEmpty()) {
            Node node = heap.remove();
            int vertexIndex = graph.indexMap.get(node.label);
            if(!visited.contains(node.label)) {
                visited.add(node.label);
                minTree.add(node.extra);
                for(int i=0; i < size; i++) {
                    if(graph.adjMatrix[vertexIndex][i] !=0 && !visited.contains(graph.vertices[i])) {
                        Node adjNode = new Node(graph.vertices[i], graph.adjMatrix[vertexIndex][i]);
                        adjNode.extra = node.label + " - " + graph.vertices[i];
                        heap.add(adjNode);
                    }
                }
            }
        }

        System.out.println("The edges to generate the tree are: ");
        System.out.println(minTree);
    }

    private void shortestPathWithNegativeWeight(Graph graph, char vertex) {
        int size = graph.vertices.length;
        int[] distance = new int[size];
        String[] path = new String[size];

        for(int i=0; i < size; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        int vertexIndex = graph.indexMap.get(vertex);
        distance[vertexIndex] = 0;
        path[vertexIndex] = vertex + "";

        Queue<Character> queue = new LinkedList<>();
        queue.add(vertex);

        Set<Character> visited = new HashSet<>();

        while(!queue.isEmpty()) {
            vertex = queue.remove();
            vertexIndex = graph.indexMap.get(vertex);

            if(!visited.contains(vertex)) {
                visited.add(vertex);
                for(int i=0; i < size; i++) {
                    if(graph.adjMatrix[vertexIndex][i] != 0 && !visited.contains(graph.vertices[i])) {
                        int newDistance = graph.adjMatrix[vertexIndex][i] + distance[vertexIndex];
                        if(newDistance < distance[i]) {
                            distance[i] = newDistance;
                            path[i] = path[vertexIndex] + " -- " + graph.vertices[i];
                            queue.add(graph.vertices[i]);
                        }
                    }
                }
            }
        }
        for(int i=0; i < size; i++) {
            System.out.println(distance[i] + " : " + path[i]);
        }
    }

    private void shortestPathWithWeighted(Graph graph, char vertex) {
        int size = graph.vertices.length;
        int[] distance = new int[size];
        String[] path = new String[size];

        for(int i=0; i < size; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        int vertexIndex = graph.indexMap.get(vertex);
        distance[vertexIndex] = 0;
        path[vertexIndex] = vertex + "";

        Comparator<Node> comparator = Comparator.comparing(Node::getWeight);
        PriorityQueue<Node> heap = new PriorityQueue<>(comparator);
        heap.add(new Node(vertex, 0));
        Set<Character> visited = new HashSet<>();
        while(!heap.isEmpty()) {
            Node node = heap.remove();
            if(!visited.contains(node.label)) {
                visited.add(node.label);
                vertexIndex = graph.indexMap.get(node.label);

                for(int i=0; i < size; i++) {
                    if(graph.adjMatrix[vertexIndex][i] != 0 && !visited.contains(graph.vertices[i])) {
                        int newDistance = distance[vertexIndex] + graph.adjMatrix[vertexIndex][i];
                        if(newDistance < distance[i]) {
                            distance[i] = newDistance;
                            path[i] = path[vertexIndex] + " > " + graph.vertices[i];
                            heap.add(new Node(graph.vertices[i], newDistance));
                        }
                    }
                }

            }
        }
        for(int i=0; i < size; i++) {
            System.out.println(distance[i] + " : " + path[i]);
        }
    }

    private void shortestPathNonWeighted(Graph graph, char vertex) {
        int size = graph.vertices.length;
        int distance[] = new int[size];
        String path[] = new String[size];

        for(int i=0; i < size; i++) distance[i] = Integer.MAX_VALUE;
        int vertexIndex = graph.indexMap.get(vertex);
        distance[vertexIndex] = 0;
        path[vertexIndex] = vertex + "";

        Queue<Character> queue = new LinkedList<>();
        queue.add(vertex);
        Set<Character> visited = new HashSet<>();

        while(!queue.isEmpty()) {
            vertex = queue.remove();
            vertexIndex = graph.indexMap.get(vertex);
            if(!visited.contains(vertex)) {
                visited.add(vertex);
                for(int i=0; i < size; i++) {
                    if(graph.adjMatrix[vertexIndex][i] == 1 && !visited.contains(graph.vertices[i])) {
                        distance[i] = distance[vertexIndex] + 1;
                        path[i] = path[vertexIndex] + " -> " + graph.vertices[i];
                        queue.add(graph.vertices[i]);
                    }
                }
            }
        }

        for(int i=0; i < size; i++) {
            System.out.println(distance[i] + " : " + path[i]);
        }
    }

    private void topologicalSort(Graph graph) {
        int incident[] = new int [graph.vertices.length];
        for(Character vertex : graph.adjList.keySet()) {
            List<Node> adjList = graph.adjList.get(vertex);
            for(Node node : adjList) {
                int index = graph.indexMap.get(node.label);
                incident[index] = incident[index] + 1;
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for(int i=0; i < incident.length; i++) {
            if(incident[i] == 0) {
                queue.add(graph.vertices[i]);
            }
        }

        while(!queue.isEmpty()) {
            char vertex = queue.remove();
            System.out.print(vertex + " | ");
            List<Node> adj = graph.adjList.get(vertex);
            for(Node node : adj) {
                int index = graph.indexMap.get(node.label);
                incident[index] = incident[index] - 1;
                if(incident[index] == 0) queue.add(node.label);
            }
        }
    }

    private void bfsWithList(Graph graph, char vertex) {
        Queue<Character> queue = new LinkedList<>();
        queue.add(vertex);
        Set<Character> visited = new HashSet<>();

        while(!queue.isEmpty()) {
            vertex = queue.remove();
            if(!visited.contains(vertex)) {
                visited.add(vertex);
                System.out.print(vertex + " > ");
                for(Node node : graph.adjList.get(vertex)) {
                    if(!visited.contains(node.label)) {
                        queue.add(node.label);
                    }
                }
            }
        }
    }

    private void bfsWithMat(Graph graph, char vertex) {
        Queue<Character> queue = new LinkedList<>();
        queue.add(vertex);
        Set<Character> visited = new HashSet<>();

        while(!queue.isEmpty()) {
            vertex = queue.remove();
            if(!visited.contains(vertex)) {
                visited.add(vertex);
                System.out.print(vertex + " : ");
                int vertexIndex = graph.indexMap.get(vertex);
                for(int i=0; i < graph.vertices.length; i++) {
                    if(graph.adjMatrix[vertexIndex][i] == 1 && !visited.contains(graph.vertices[i])) {
                        queue.add(graph.vertices[i]);
                    }
                }
            }
        }
    }

    private void dfsWithList(Graph graph, char vertex, Set<Character> visited) {
        if(visited.contains(vertex)) {
            return;
        }
        visited.add(vertex);
        System.out.print(vertex + " > ");
        for(Node node : graph.adjList.get(vertex)) {
            if(!visited.contains(node.label)) {
                dfsWithList(graph, node.label, visited);
            }
        }
    }

    private void dfsWithMat(Graph graph, char vertex, Set<Character> visited) {
        if(visited.contains(vertex)) return;
        visited.add(vertex);
        System.out.print(vertex + " -> ");
        int vertexIndex = graph.indexMap.get(vertex);
        for(int i=0; i < graph.vertices.length; i++) {
            if(graph.adjMatrix[vertexIndex][i] == 1 && !visited.contains(graph.vertices[i])) {
                dfsWithMat(graph, graph.vertices[i], visited);
            }
        }
    }

}

