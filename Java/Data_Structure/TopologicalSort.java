import java.util.*;

/**
 * Directed Acyclic Graph (DAG) with Topological Sort.
 *
 * Topological sort = an ordering of vertices such that for every edge u → v,
 * u appears before v in the order.
 * (Like: finish prerequisites before a course.)
 *
 * Only works on a DAG (no cycles).
 *
 * Algorithm used here (DFS + stack):
 *   1. Do DFS from each unvisited vertex
 *   2. After all neighbors of a vertex are done, push that vertex onto a stack
 *   3. Pop the stack — that gives the topological order
 *
 * Why push after neighbors?
 *   Finish all neighbors first, then push the current node.
 *   So neighbors are pushed earlier (deeper in the stack).
 *   When we pop, the current node comes out before its neighbors —
 *   which matches "u before v" for every edge u → v.
 *
 * Example graph in main (vertices A..F):
 *   F → C → D → B
 *   F → A
 *   E → A
 *   E → B
 *
 * One valid topological order: F E C A D B  (or similar)
 *
 * Indexing trick:
 *   'A' has ASCII 65, so ('A' - 65) = 0, ('B' - 65) = 1, ... ('F' - 65) = 5
 *   Vertices are stored at those indices in adjList / visited.
 */
class DirectedAcyclicGraph {
    private int noOfVertices;                          // number of vertices (here 6: A..F)
    private ArrayList<ArrayList<Character>> adjList;   // adjList.get(i) = neighbors of vertex (char)(i+65)

    // Create a DAG with noOfNodes vertices; each starts with an empty neighbor list
    DirectedAcyclicGraph(int noOfNodes) {
        noOfVertices = noOfNodes;
        adjList = new ArrayList<ArrayList<Character>>(noOfNodes);
        for (int i = 0; i < noOfNodes; ++i) {
            adjList.add(new ArrayList<Character>()); // empty list for vertex at index i
        }
    }

    // Add a directed edge v → w
    // Example: createEdge('F', 'C') means F must come before C
    // (v - 65) converts letter to index: 'F' → 5, so adjList.get(5) gets 'C'
    void createEdge(Character v, Character w) {
        adjList.get((v - 65)).add(w);
    }

    /**
     * DFS helper for topological sort.
     *
     * Steps for node:
     *   1. Mark node visited
     *   2. Recursively visit all unvisited neighbors
     *   3. After all neighbors are finished, push node onto the stack
     *
     * Example for edge C → D:
     *   DFS visits C, then recurses into D, finishes D, pushes D
     *   then finishes C, pushes C
     *   Stack top is C. Pop order starts with C before D — correct.
     */
    void topologicalSortUtility(char node, boolean visited[], Stack<Character> stk) {
        visited[(node - 65)] = true; // mark this letter as visited (e.g. 'C' → index 2)

        Character j;
        // Iterate over all neighbors of node
        Iterator<Character> itr = adjList.get((node - 65)).iterator();
        while (itr.hasNext()) {
            j = itr.next(); // next neighbor letter
            if (visited[(j - 65)] == false) {
                // neighbor not visited yet — go deeper (DFS)
                topologicalSortUtility(j, visited, stk);
            }
        }

        // All neighbors done — push current node
        // (nodes that must come earlier end up higher when we pop)
        stk.push(node);
    }

    /**
     * Runs topological sort for the whole graph and prints the order.
     *
     * 1. Create empty stack and visited[] (all false)
     * 2. For every unvisited vertex, run DFS utility
     *    (needed if the graph has several disconnected parts)
     * 3. Pop stack until empty — that is the topological order
     */
    void topologicalSorting() {
        Stack<Character> stk = new Stack<Character>(); // stores finish order

        boolean visited[] = new boolean[noOfVertices];

        // Explicitly set all vertices as not visited
        for (int i = 0; i < noOfVertices; i++) {
            visited[i] = false;
        }

        // Run DFS from every unvisited vertex (covers disconnected components)
        // j = 0 → 'A', j = 1 → 'B', ... j = 5 → 'F'
        for (int j = 0; j < noOfVertices; j++) {
            if (visited[j] == false) {
                topologicalSortUtility((char) (j + 65), visited, stk);
            }
        }

        // Pop and print: this is the topological order
        while (stk.empty() == false) {
            System.out.print(stk.pop() + " ");
        }
    }
}

/**
 * Demo: build a small DAG and print one topological ordering of A..F.
 */
public class TopologicalSort {
    public static void main(String argvs[]) {
        DirectedAcyclicGraph g = new DirectedAcyclicGraph(6); // vertices A B C D E F

        g.createEdge('F', 'C'); // F before C
        g.createEdge('F', 'A'); // F before A
        g.createEdge('E', 'A'); // E before A
        g.createEdge('E', 'B'); // E before B
        g.createEdge('C', 'D'); // C before D
        g.createEdge('D', 'B'); // D before B

        // Graph sketch:
        //   F → C → D → B
        //   F → A ← E
        //         E → B

        System.out.println("Topological sort of the nodes in the graph: ");
        g.topologicalSorting(); // e.g. F E C D A B  (any valid order is OK)
    }
}
