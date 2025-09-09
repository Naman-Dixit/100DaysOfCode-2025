import java.util.*;

class Solution {
    private void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls) {
        // marking current node as visited
        vis[node] = true;
        ls.add(node);

        // traverse all its neighbours
        for (int it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, vis, adj, ls);
            }
        }
    }

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        ArrayList<Integer> ls = new ArrayList<>();
        int start = 0;
        vis[start] = true;
        dfs(start, vis, adj, ls);
        return ls;
    }
}

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of vertices: ");
        int V = sc.nextInt();
        
        // Initialize adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.print("Enter the number of edges: ");
        int E = sc.nextInt();
        
        System.out.println("Enter " + E + " edges (source and destination):");
        for (int i = 0; i < E; i++) {
            System.out.print("Edge " + (i + 1) + " (source destination): ");
            int src = sc.nextInt();
            int dest = sc.nextInt();
            adj.get(src).add(dest); // Add edge
            adj.get(dest).add(src); // For undirected graph
        }

        Solution sol = new Solution();
        ArrayList<Integer> dfs = sol.dfsOfGraph(V, adj);

        System.out.println("DFS Traversal of the graph: " + dfs);
        
        sc.close();
    }
}
