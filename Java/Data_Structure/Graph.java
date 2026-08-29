import java.util.*;

/**
 * Graph — directed graph stored as an adjacency list, with DFS (Depth-First Search).
 *
 * Adjacency list idea:
 *   adj[0] = list of vertices reachable from 0 by one edge
 *   adj[1] = list of vertices reachable from 1
 *   ...
 *
 * Example graph built in main (4 vertices: 0, 1, 2, 3):
 *
 *      0 ----→ 1
 *      ↑ \     |
 *      |  \    ↓
 *      |   →→  2 ----→ 3
 *      |       ↑       |
 *      └───────┘       └→ (self-loop at 3)
 *
 * Edges: 0→1, 0→2, 1→2, 2→0, 2→3, 3→3
 *
 * DFS from 2 visits as deep as possible before backtracking.
 * One possible output: 2 0 1 3
 */
public class Graph {
    private int V;                         // number of vertices (0 .. V-1)
    private LinkedList<Integer> adj[];     // adj[i] = neighbors of vertex i

    // Create a graph with v vertices and no edges yet
    @SuppressWarnings("unchecked")
    Graph(int v) {
        V = v;                             // store vertex count
        adj = new LinkedList[v];           // create array of lists (one list per vertex)
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();   // each vertex starts with an empty neighbor list of Integers
    }

    // Add a directed edge from v to w (v → w)
    // Example: addEdge(2, 3) means from 2 you can go to 3
    void addEdge(int v, int w) {
        adj[v].add(w); // append w to the neighbor list of v
    }

    /**
     * Recursive DFS helper: visit vertex v, then explore its unvisited neighbors.
     *
     * Steps for vertex v:
     *   1. Mark v as visited
     *   2. Print v
     *   3. For each neighbor n of v: if n is not visited, recurse into n
     *
     * Example starting DFSUtil(2, visited) on the main graph:
     *   visit 2 → print "2 "
     *   neighbors of 2: 0, then 3
     *     go to 0 → print "0 "
     *       neighbors of 0: 1, then 2
     *         go to 1 → print "1 "
     *           neighbors of 1: 2 (already visited) → skip
     *         2 already visited → skip
     *     go to 3 → print "3 "
     *       neighbor of 3: 3 (already visited) → skip
     *   Output: 2 0 1 3
     */
    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;                 // mark current vertex as visited
        System.out.print(v + " ");         // process / print the vertex

        // Get an iterator over all neighbors of v
        Iterator<Integer> i = adj[v].listIterator();

        while (i.hasNext()) {              // while there are more neighbors
            int n = i.next();              // next neighbor
            if (!visited[n])               // if this neighbor has not been visited yet
                DFSUtil(n, visited);       // go deep into that neighbor (recursion)
        }
        // When all neighbors are done, return (backtrack to the caller)
    }

    /**
     * Start DFS from vertex v.
     * Creates a visited[] array (all false), then calls the recursive helper.
     *
     * visited[i] = true  means vertex i has already been explored
     * visited[i] = false means vertex i has not been visited yet
     */
    void DFS(int v) {
        boolean visited[] = new boolean[V]; // all entries start as false
        DFSUtil(v, visited);                // begin recursion from starting vertex v
    }

    // Demo: build the example graph and run DFS from vertex 2
    public static void main(String args[]) {
        Graph g = new Graph(4); // 4 vertices: 0, 1, 2, 3

        g.addEdge(0, 1); // 0 → 1
        g.addEdge(0, 2); // 0 → 2
        g.addEdge(1, 2); // 1 → 2
        g.addEdge(2, 0); // 2 → 0
        g.addEdge(2, 3); // 2 → 3
        g.addEdge(3, 3); // 3 → 3 (self-loop)

        System.out.println("DFS traversal of the graph starting from vertex 2: ");
        g.DFS(2); // Depth-First Search starting at 2
        // Expected: 2 0 1 3
    }
}
