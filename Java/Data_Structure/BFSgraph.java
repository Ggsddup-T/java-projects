import java.util.*;

/**
 * Graph with BFS (Breadth-First Search).
 *
 * Same adjacency-list idea as DFS:
 *   adj[i] = list of vertices you can reach from i in one step
 *
 * BFS vs DFS:
 *   DFS  — go as deep as possible (uses recursion / stack)
 *   BFS  — visit level by level, nearest neighbors first (uses a queue)
 *
 * Example graph in main (same as the DFS program):
 *
 *   Edges: 0→1, 0→2, 1→2, 2→0, 2→3, 3→3
 *
 *   adj[0] → [1, 2]
 *   adj[1] → [2]
 *   adj[2] → [0, 3]
 *   adj[3] → [3]
 *
 * BFS starting at 2:
 *   Visit 2 first
 *   Then its neighbors: 0, then 3
 *   Then neighbors of 0 that are new: 1
 *   Output: 2 0 3 1
 */
public class BFSgraph {
    private int V;                         // number of vertices (0 .. V-1)
    private LinkedList<Integer> adj[];     // adj[i] = neighbors of vertex i

    // Create a graph with v vertices; each starts with an empty neighbor list
    @SuppressWarnings("unchecked")
    BFSgraph(int v) {
        V = v;                             // store how many vertices we have
        adj = new LinkedList[v];           // array of lists (one list per vertex)
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();   // empty LinkedList<Integer> for vertex i
    }

    // Add a directed edge v → w (append w to adj[v])
    // Example: addEdge(2, 3) makes adj[2] contain 3
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    /**
     * Breadth-First Search starting from vertex s.
     *
     * Idea: use a queue (FIFO — first in, first out).
     *   1. Mark start s as visited and put it in the queue
     *   2. While queue is not empty:
     *        - Remove (poll) the front vertex
     *        - Print it
     *        - For each unvisited neighbor: mark it visited and add to queue
     *
     * Example: BFS(2) on the main graph
     *
     *   Start: visited[2]=true, queue = [2]
     *
     *   Step 1: poll 2, print "2 "
     *           neighbors of 2: 0, 3
     *           enqueue 0, enqueue 3
     *           queue = [0, 3]
     *
     *   Step 2: poll 0, print "0 "
     *           neighbors of 0: 1, 2
     *           2 already visited; enqueue 1
     *           queue = [3, 1]
     *
     *   Step 3: poll 3, print "3 "
     *           neighbor of 3: 3 (already visited)
     *           queue = [1]
     *
     *   Step 4: poll 1, print "1 "
     *           neighbor of 1: 2 (already visited)
     *           queue = []
     *
     *   Done. Output: 2 0 3 1
     */
    void BFS(int s) {
        // visited[i] = true means we have already discovered vertex i
        boolean visited[] = new boolean[V];

        // Queue of vertices waiting to be processed (FIFO)
        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;  // mark the start vertex as discovered
        queue.add(s);       // put start vertex into the queue

        // Keep going until every discovered vertex has been processed
        while (queue.size() != 0) {
            s = queue.poll();          // remove front of queue (next vertex to visit)
            System.out.print(s + " "); // process / print that vertex

            // Look at all neighbors of the current vertex
            Iterator<Integer> i = adj[s].listIterator();

            while (i.hasNext()) {
                int n = i.next();      // next neighbor
                if (!visited[n]) {     // if we have not discovered n yet
                    visited[n] = true; // mark it now (so we don't enqueue it twice)
                    queue.add(n);      // add it to the back of the queue
                }
            }
        }
    }

    // Demo: build the sample graph and run BFS from vertex 2
    public static void main(String args[]) {
        BFSgraph g = new BFSgraph(4); // 4 vertices: 0, 1, 2, 3

        g.addEdge(0, 1); // 0 → 1
        g.addEdge(0, 2); // 0 → 2
        g.addEdge(1, 2); // 1 → 2
        g.addEdge(2, 0); // 2 → 0
        g.addEdge(2, 3); // 2 → 3
        g.addEdge(3, 3); // 3 → 3 (self-loop)

        System.out.println("BFS traversal of the graph starting from vertex 2: ");
        g.BFS(2); // expected output: 2 0 3 1
    }
}
