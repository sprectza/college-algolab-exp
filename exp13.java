package VTULabExperiments;

/*
    @author Swarit Pandey
    Task:   Find APSP using Floyd-Warshall Algorithm.

    Note: Tested for sparse graph.
 */

import java.util.Scanner;
import java.util.*;

class FloydWarshall {
    void initAlgo (DiGraph graph, int n) {
        int[][] dp = new int[n + 1][n + 1];
        for(int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for(int i = 0; i < n; ++i) {
            dp[i][i] = 0;
            for(int j = 0; j < graph.AdjList.get(i).size(); ++j) {
                int x = graph.AdjList.get(i).get(j).label;
                dp[i][x] = graph.AdjList.get(i).get(j).cost;
            }
        }

        for(int k = 0; k < n; ++k) {
            for(int i = 0; i < n; ++i) {
                for(int j = 0; j < n; ++j) {
                    if(dp[i][k] != Integer.MAX_VALUE && dp[k][j] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                    }
                }
            }
        }

        System.out.println("APSP matrix for the given graph\nX denotes Infinity");
        for (int[] ints : dp) {
            for (int j = 0; j < dp.length; ++j) {
                if (ints[j] == Integer.MAX_VALUE) {
                    System.out.print("X ");
                } else {
                    System.out.print(ints[j] + " ");
                }
            }
            System.out.println();
        }
    }
}

public class DAALabExp13 {
    public static void main(String[] args) {
        Scanner scanData = new Scanner(System.in);
        System.out.println("Enter the number of edges: ");
        int n = scanData.nextInt();

        System.out.println("Enter edge details <source/destination/cost>");
        List<Edge> edgesResponse = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
            int src = scanData.nextInt();
            int dest = scanData.nextInt();
            int cost = scanData.nextInt();

            edgesResponse.add(new Edge(src, dest, cost));
        }

        DiGraph graph = new DiGraph(edgesResponse);
        FloydWarshall getAPSP = new FloydWarshall();
        getAPSP.initAlgo(graph, n);
    }
}
