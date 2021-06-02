package VTULabExperiments;

/*
    @author Swarit Pandey
    Lab Exp 10:
    Task:  Find MST using Kruskal Algorithm
 */

// Implementation of Disjoint Set is at its optimal, with Path Compression and Unify by Rank
// Proven upper bound of O(alpha(n)) where alpha(n) is inverse Ackermann Function

import java.util.*;

class DisjointSet {
    Map<Integer, Integer> parent = new HashMap<>();
    Map<Integer, Integer> rank = new HashMap<>();

    DisjointSet (int n) {
        for(int i = 0; i <= n; ++i) {
            parent.put(i, i);
            rank.put(i, 0);
        }
    }

    int find (int ele) {
        int root = ele;
        while(parent.get(root) != root) {
            root = parent.get(root);
        }

        // Path Compression
        while(ele != root) {
            int temp = parent.get(ele);
            parent.put(ele, root);
            ele = temp;
        }

        return root;
    }

    boolean unify(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);

        if(root_a == root_b) return false; // Cycle detected

        if(rank.get(root_a) > rank.get(root_b)) {
            parent.put(root_b, root_a);
        } else if(rank.get(root_b) > rank.get(root_a)) {
            parent.put(root_a, root_b);
        } else {
            parent.put(root_b, root_a);
            rank.put(root_a, 1);
        }
        return true;
    }
}

class Kruskal {
    public void getMST(List<Edge> edges, int n) {
        List<Edge> keepMST = new ArrayList<>();
        DisjointSet unionFind = new DisjointSet(n);
        int index = 0;
        while(keepMST.size() != n) {
            Edge curEdge = edges.get(index);

            int x = curEdge.src;
            int y = curEdge.dest;
            System.out.printf("[%d, %d]", x, y);
            System.out.println();
            if(unionFind.unify(x, y)) {
                keepMST.add(curEdge);
            }
            index++;
        }
        printMST(keepMST);
    }

    private void printMST(List<Edge> keepMST) {
        int index = 0;
        while (index != keepMST.size()) {
            Edge cur_edge = keepMST.get(index);
            int src = cur_edge.src;
            int dest = cur_edge.dest;
            int cost = cur_edge.cost;
            index++;
            System.out.printf("[%d <-> %d, %d] ", src, dest, cost);
        }
    }
}

public class DAALabExp11 {
    public static void main(String[] args) {
        Scanner scanData = new Scanner(System.in);
        System.out.println("Enter the number of edges: ");
        int n = scanData.nextInt();
        System.out.println("Enter the details of edges <src, dest, cost>");
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
        edgesResponse.sort(Comparator.comparingInt(e -> e.cost));
        Graph graph = new Graph(edgesResponse);
        graph.seeGraph(graph);

        Kruskal generateMST = new Kruskal();
        generateMST.getMST(edgesResponse, size);
    }
}























