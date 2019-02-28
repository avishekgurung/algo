package graph.problems;

/**
 * Solution a.
 * Let n be the number of vertices in a graph. Lets assume that we have named the nodes from 1
 * to n.
 *
 * Node 1 can connect to n-1 nodes
 * Node 2 can connect to n-2 nodes
 * Node 3 can connect to n-3 nodes
 * .
 * .
 * Node n can connect to 0 nodes.
 *
 * Draw a diagram to get a clearer view. (Draw a directed graph actually).
 *
 * Total edges = (n -1) + (n-2) + (n-3) + ... + (n-n)
 *  = n + n + n + .... n times - ( 1 + 2 + ... n)
 *
 * Now n + n + n + .... n times = n * n
 * How, n + n = 2n
 * n + n + n = 3n
 * n + n + n + n = 4n
 * n + n + ... + n = nn = n^2
 *
 * Total edges = n^2 - n(n-1)/2
 * =(2n^2 - n^2 + n )/2
 * = n(n-1)/2
 *
 * This is applicable for both directed(without cycle) and un-directed graphs.
 */


/**
 * Solution b.
 * Adjacency list is best to identify if a vertex is isolated. Given a vertex, find its
 * index in a adj list. If the list is empty then the vertex is not connected to any other
 * vertices.
 */


/**
 * Solution c.
 * One vertex can connect to n-1 vertices without cycle. So total number of graphs is n(n-1)
 */


/**
 * Solution D.
 * We can take the negative of the weights and use the same formulae to create Minimum Spanning
 * Tree.
 */
public class Problem007 {
}
