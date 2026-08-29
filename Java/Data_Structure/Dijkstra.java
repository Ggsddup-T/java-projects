import java.util.*;

/**
 * Dijkstra's Algorithm — finds shortest paths from one source to all other vertices.
 *
 * Works on a weighted graph with non-negative edge weights.
 *
 * Main idea:
 *   Keep distance[] = best known distance from source to each vertex.
 *   Repeatedly pick the unvisited vertex with the smallest distance,
 *   then try to improve (relax) distances to its neighbors.
 *
 * Graph representation: adjacency MATRIX
 *   graph[i][j] = weight of edge i → j
 *   graph[i][j] = -1 means no edge between i and j
 *
 * Example from main (source = 0):
 *   0 connects to 1 (weight 3) and 7 (weight 7)
 *   So after first updates: distance[1]=3, distance[7]=7, others still "infinity"
 */
public class Dijkstra {
    static final int totalVertex = 9; // number of vertices (0 .. 8)

    /**
     * Among vertices NOT yet finalized (spSet[vx] == false),
     * return the index of the one with the smallest distance[].
     *
     * Example: distance = [0, 3, ∞, ∞, ∞, ∞, ∞, 7, ∞], all spSet false except maybe some
     *   → returns 0 first time (distance 0), later returns 1 (distance 3), etc.
     */
    int minimumDistance(int distance[], Boolean spSet[]) {
        int m = Integer.MAX_VALUE; // smallest distance found so far (start at "infinity")
        int m_index = -1;          // index of that vertex

        for (int vx = 0; vx < totalVertex; vx++) {
            // Only consider vertices not yet in the shortest-path set
            if (spSet[vx] == false && distance[vx] <= m) {
                m = distance[vx];   // found a closer (or equal) candidate
                m_index = vx;       // remember its index
            }
        }
        return m_index; // vertex to process next
    }

    // Print the final shortest distance from the source to every vertex
    void print(int distance[], int n) {
        System.out.println("The shortest distance from the source node 0 to all other nodes is: ");
        for (int j = 0; j < n; j++)
            System.out.println("Shortest distance to node " + j + " is " + distance[j]);
    }

    /**
     * Run Dijkstra from source vertex s.
     *
     * Arrays:
     *   distance[i] — shortest known distance from s to i
     *   spSet[i]    — true if i's shortest distance is finalized
     *
     * Steps:
     *   1. Set all distances to infinity; set source distance to 0
     *   2. Repeat (V-1) times:
     *        - Pick unvisited vertex ux with smallest distance
     *        - Mark ux as finalized (spSet[ux] = true)
     *        - For each neighbor vx of ux:
     *            if going through ux gives a shorter path, update distance[vx]
     *
     * Relaxation formula:
     *   if distance[ux] + graph[ux][vx] < distance[vx]
     *      then distance[vx] = distance[ux] + graph[ux][vx]
     *
     * Example (source 0):
     *   Start: distance[0]=0, others = infinity
     *   Pick 0; edges 0→1 (3), 0→7 (7)
     *     distance[1] = 0+3 = 3
     *     distance[7] = 0+7 = 7
     *   Pick 1 (smallest among remaining); update its neighbors; and so on
     */
    void dijkstra(int graph[][], int s) {
        int distance[] = new int[totalVertex];     // best distance from s to each vertex
        Boolean spSet[] = new Boolean[totalVertex]; // true = shortest path to this vertex is done

        // Initialize: all distances infinity, none finalized
        for (int j = 0; j < totalVertex; j++) {
            distance[j] = Integer.MAX_VALUE; // "infinity" = not reachable yet
            spSet[j] = false;
        }

        distance[s] = 0; // distance from source to itself is 0

        // Main loop: finalize one vertex per iteration (do this V-1 times)
        for (int cnt = 0; cnt < totalVertex - 1; cnt++) {
            // ux = unvisited vertex with currently smallest distance
            int ux = minimumDistance(distance, spSet);
            spSet[ux] = true; // lock in shortest path to ux

            // Try to improve distances to neighbors of ux
            for (int vx = 0; vx < totalVertex; vx++)
                // Conditions to update vx:
                //   1. vx not yet finalized
                //   2. there is an edge ux → vx (graph[ux][vx] != -1)
                //   3. ux itself is reachable (distance[ux] is not infinity)
                //   4. path s → ux → vx is shorter than current distance[vx]
                if (!spSet[vx] && graph[ux][vx] != -1 && distance[ux] != Integer.MAX_VALUE
                        && distance[ux] + graph[ux][vx] < distance[vx]) {
                    distance[vx] = distance[ux] + graph[ux][vx]; // relax the edge
                }
        }

        print(distance, totalVertex); // show all shortest distances from s
    }

    // Demo: 9x9 weighted adjacency matrix; run Dijkstra from vertex 0
    public static void main(String argvs[]) {
        // grph[i][j] = weight of edge i → j; -1 means no edge
        // Example: grph[0][1] = 3  → edge 0 → 1 with weight 3
        //          grph[0][7] = 7  → edge 0 → 7 with weight 7
        int grph[][] = new int[][] {
                { -1, 3, -1, -1, -1, -1, -1, 7, -1 },
                { 3, -1, 7, -1, -1, -1, -1, 10, 4 },
                { -1, 7, -1, 6, -1, 2, -1, -1, 1 },
                { -1, -1, 6, -1, 8, 13, -1, -1, 3 },
                { -1, -1, -1, 8, -1, 9, -1, -1, -1 },
                { -1, -1, 2, 13, 9, -1, 4, -1, 5 },
                { -1, -1, -1, -1, -1, 4, -1, 2, 5 },
                { 7, 10, -1, -1, -1, -1, 2, -1, 6 },
                { -1, 4, 1, 3, -1, 5, 5, 6, -1 }
        };

        Dijkstra obj = new Dijkstra();
        obj.dijkstra(grph, 0); // find shortest paths from source vertex 0
    }
}
