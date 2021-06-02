package VTULabExperiments;

/*
    @author Swarit Pandey
    Lab Exp 12
    Task: Find MST applying Prim's Algorithms

    DISCLAIMER: Not fully verified if calculates MST, needs more testing
 */

import java.util.*;

class Prim {
    void initPrim(Graph graph, int n) {
        PriorityQueue<Vertex> minHeap;
        minHeap = new PriorityQueue<>(Comparator.comparingInt(Vertex -> Vertex.cost));
        minHeap.add(new Vertex(0, 0));
        List<Vertex> keepMST = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];

        while(!minHeap.isEmpty()) {
            Vertex localNode = minHeap.poll();
            int u = localNode.label;
            int uCost = localNode.cost; // This can be used to just calculate the total cost of MST

            if(!visited[u]) {
                visited[u] = true;
                keepMST.add(localNode);
                for(Vertex v : graph.AdjList.get(u)) {
                    int vLabel = v.label;
                    if(!visited[vLabel]) {
                        minHeap.add(v);
                    }
                }
            }
        }
        int index = 0;
        while(index != keepMST.size()) {
            Vertex node = keepMST.get(index);
            int label = node.label;
            int cost = node.cost;
            System.out.print(label + "(" + cost + ")" + " --> ");
            index++;
        }
    }
}

public class DAALabExp12 {
    public static void main(String[] args) {
        Scanner scanData = new Scanner(System.in);
        System.out.println("Enter the number of edges in graph");
        int n = scanData.nextInt();
        System.out.println("Enter details of edges <src, dest, cost>");
        List<Edge> edgesResponse = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
            int src = scanData.nextInt();
            int dest = scanData.nextInt();
            int cost = scanData.nextInt();

            edgesResponse.add(new Edge(src, dest, cost));
        }
        int size = Integer.MIN_VALUE;
        for(Edge e : edgesResponse) {
            size = Math.max(size, Math.max(e.src, e.dest));
        }
        Graph graph = new Graph(edgesResponse);
        Prim generateMST = new Prim();
        generateMST.initPrim(graph, size);
    }
}
