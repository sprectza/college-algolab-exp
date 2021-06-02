package VTULabExperiments;

/*
    @Author Swarit Pandey
    General purpose Graph API for Graph related Algorithms
    Use DiGraph class for directed graph and Graph for undirected graph
*/

import java.util.ArrayList;
import java.util.List;

class Edge {
    int src, dest, cost;
    Edge(int src, int dest, int cost) {
        this.src = src;
        this.dest = dest;
        this.cost = cost;
    }
}

class Vertex {
    int label, cost;
    Vertex(int label, int cost) {
        this.label = label;
        this.cost = cost;
    }
}

// Undirected Weighted Graph
class Graph {
    List<List<Vertex>> AdjList = new ArrayList<>();
    public Graph(List<Edge> edges) {
        int size = Integer.MIN_VALUE;
        for(Edge e : edges) {
            size = Math.max(size, Math.max(e.src, e.dest));
        }

        for(int i = 0; i <= size; ++i) {
            AdjList.add(new ArrayList<>());
        }

        for(Edge thisEdge : edges) {
            AdjList.get(thisEdge.src).add(new Vertex(thisEdge.dest, thisEdge.cost));
            AdjList.get(thisEdge.dest).add(new Vertex(thisEdge.src, thisEdge.cost));
        }
    }

    public void seeGraph(Graph graph) {
        int src = 0;
        int n = graph.AdjList.size();

        while(src < n) {
            for(Vertex nextNode : graph.AdjList.get(src)) {
                System.out.print(" " + src + " --> " + nextNode.label + "(" + nextNode.cost + ")");
            }
            System.out.println();
            src++;
        }
    }
}

// Directed Weighted Graph
class DiGraph {
    List<List<Vertex>> AdjList = new ArrayList<>();
    public DiGraph(List<Edge> edges) {
        int size = Integer.MIN_VALUE;
        for(Edge e : edges) {
            size = Math.max(size, Math.max(e.src, e.dest));
        }

        for(int i = 0; i <= size; ++i) {
            AdjList.add(new ArrayList<>());
        }

        for(Edge thisEdge : edges) {
            AdjList.get(thisEdge.src).add(new Vertex(thisEdge.dest, thisEdge.cost));
        }
    }

    public void seeGraph (DiGraph graph) {
        int src = 0;
        int n = graph.AdjList.size();

        while(src < n) {
            for(Vertex nextNode : graph.AdjList.get(src)) {
                System.out.print(" " + src + " --> " + nextNode.label + "(" + nextNode.cost + ")");
            }
            System.out.println();
            src++;
        }
    }
}

