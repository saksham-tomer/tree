package tree;

import java.util.*;

class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void deleteNodesToDisconnect(int src, int dest) {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[src] = true;
        queue.add(src);

        while (queue.size() != 0) {
            int s = queue.poll();

            for (int i : adj[s]) {
                if (i == dest) {
                    return;
                }
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    boolean isPathExists(int src, int dest) {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[src] = true;
        queue.add(src);

        while (queue.size() != 0) {
            int s = queue.poll();

            for (int i : adj[s]) {
                if (i == dest) {
                    return true;
                }
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        return false;
    }

    int minimumCost(int src, int dest) {
        boolean visited[] = new boolean[V];
        int distance[] = new int[V];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[src] = true;
        distance[src] = 0;
        queue.add(src);

        while (queue.size() != 0) {
            int s = queue.poll();

            for (int i : adj[s]) {
                if (i == dest) {
                    return distance[s] + 1; // Since we are counting edges, not nodes.
                }
                if (!visited[i]) {
                    visited[i] = true;
                    distance[i] = distance[s] + 1;
                    queue.add(i);
                }
            }
        }
        return -1; // If there is no path from src to dest
    }
}

public class Main {
    public static void main(String args[]) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Nodes to delete to disconnect follower and following nodes:");
        g.deleteNodesToDisconnect(0, 2);

        System.out.println("Connection between follower and following nodes:");
        System.out.println(g.isPathExists(0, 3) ? "1" : "0");

        Graph weightedGraph = new Graph(6);
        weightedGraph.addEdge(0, 1);
        weightedGraph.addEdge(0, 2);
        weightedGraph.addEdge(1, 3);
        weightedGraph.addEdge(1, 4);
        weightedGraph.addEdge(2, 5);

        System.out.println("Minimum cost to reach following node:");
        System.out.println(weightedGraph.minimumCost(0, 5));
    }
}
