import java.util.*;

// Undirected graph using an adjacency list
// adj.get(i) = list of neighbors of vertex i
public class adjacencyList {

    // Add an undirected edge between u and v
    // Both sides are updated: u→v and v→u
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v); // add v to u's list
        adj.get(v).add(u); // add u to v's list
    }

    // Print each vertex and its neighbor list
    // Example: head -> 1 -> 4  means vertex 0 connects to 1 and 4
    static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print("Adjacency list of vertex " + i + "\nhead");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> " + adj.get(i).get(j));
            }
            System.out.println();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int V = 5; // number of vertices: 0, 1, 2, 3, 4

        // Create an empty list for each vertex
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        // Build the undirected graph
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);

        // Print the adjacency lists
        printGraph(adj);
    }
}
