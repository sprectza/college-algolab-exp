package VTULabExperiments;

/*
    @author Swarit Pandey
    Lab Exp 09:
    Task:   Implement in Java, the 0/1 Knapsack problem using
            (a) Dynamic Programming method
            (b) Greedy method.
 */


import java.util.Scanner;

class DP {
    public int initDP(int[] weight, int[] value, int C, int n) {
        int[][] dp = new int[n + 1][C + 1];

        for(int i = 0; i <= n; ++i) {
            for(int j = 0; j <= C; ++j) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if(weight[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
        return dp[n][C];
    }
}

public class DAALabExp09 {
    public static void main(String[] args) {
        Scanner scanData = new Scanner(System.in);
        System.out.println("Enter the number of objects and capacity of knapsack (Capacity/Knapsack)");
        int n = scanData.nextInt();
        int C = scanData.nextInt();
        int[] weightResponse = new int[n];
        int[] valueResponse = new int[n];
        System.out.println("Enter the size and value of each object");
        for(int i = 0; i < n; ++i) {
            int w = scanData.nextInt();
            int v = scanData.nextInt();
            weightResponse[i] = w;
            valueResponse[i] = v;
        }
        DP compute = new DP();
        int ans = compute.initDP(weightResponse, valueResponse, C, n);

        System.out.println("Answer is: " + ans);
    }
}
