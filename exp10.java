package VTULabExperiments;

/*
    @author Swarit Pandey
    Lab Exp 10
    Task:   Dijkstra on a weighted directed graph.
 */

import java.util.*;

class Dijkstra {
    // Single Source Shortest Paths
    void allShortestPaths (DiGraph graph, int source, int n) {
        PriorityQueue<Vertex> minHeap;
        minHeap = new PriorityQueue<>(Comparator.comparingInt(Vertex -> Vertex.cost));
        minHeap.add(new Vertex(source, 0));

        List<Integer> distance;
        distance = new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE));

        distance.set(source, 0);
        boolean[] visited = new boolean[n];
        visited[source] = true;

        // To print trail
        int[] trail = new int[n];
        trail[source] = -1;

        List<Integer> route = new ArrayList<>();

        while(!minHeap.isEmpty()) {
            Vertex localNode = minHeap.poll();

            int u = localNode.label;

            for(Vertex node : graph.AdjList.get(u)) {
                int v = node.label;
                int w = node.cost;

                if (!visited[v] && (distance.get(v) > (distance.get(u) + w))) {
                    distance.set(v, distance.get(u) + w);
                    trail[v] = u;
                    minHeap.add(new Vertex(v, distance.get(v)));
                }
            }
            visited[u] = true;
        }

        for(int i = 0; i < n; ++i) {
            if(i != source && distance.get(i) != Integer.MAX_VALUE) {
                printTrail(trail, i, route);
                System.out.print("From " + source + " --> To " + i + " : Minimum Cost = " + distance.get(i) + " | Route: " + route);
                route.clear();
                System.out.println();
            }
        }
    }

    private void printTrail(int[] trail, int i, List<Integer> route) {
        if(i >= 0) {
            printTrail(trail, trail[i], route);
            route.add(i);
        }
    }
}

public class DAALabExp10 {
    public static void main(String[] args) {
        Scanner scanData = new Scanner(System.in);
        System.out.println("Number of Edges are: ");
        int n;
        n = scanData.nextInt();
        System.out.println("Enter the edge details of the edges: <src, dest, cost>");

        List<Edge> edgesResponse = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
            int src, dest, cost;
            src = scanData.nextInt();
            dest = scanData.nextInt();
            cost = scanData.nextInt();

            edgesResponse.add(new Edge(src, dest, cost));
        }

        int size = Integer.MIN_VALUE;
        for(Edge e : edgesResponse) {
            size = Math.max(size, Math.max(e.src, e.dest));
        }

        int sourceResponse;
        System.out.println("Enter the source vertex: ");
        sourceResponse = scanData.nextInt();

        DiGraph graphResponse = new DiGraph(edgesResponse);
        Dijkstra getRoute = new Dijkstra();
        getRoute.allShortestPaths(graphResponse, sourceResponse, size);
    }
}
