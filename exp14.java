package VTULabExperiments;

/*
    Task:   Design and implement in Java to find a subset of a given set S = {Sl, S2,.....,Sn} of n
            positive integers whose SUM is equal to a given positive integer d. For example, if S ={1, 2,
            5, 6, 8} and d= 9, there are two solutions {1,2,6}and {1,8}. Display a suitable message, if
            the given problem instance doesn't have a solution.

    Note: Tested with the provided test case.
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

class GetSubsetSum {
    boolean Find(ArrayList<Integer> arr, int d) {
        int n = arr.size(); // Set cardinality
        boolean[][] dp = new boolean[d + 1][n + 1];

        for(int i = 0; i < n + 1; ++i) {
            dp[0][i] = true;
        }

        for(int i = 1; i < d + 1; ++i) {
            dp[i][0] = false;
        }

        // Bottom up dp
        for(int i = 1; i <= d; ++i) {
            for(int j = 1; j <= n; ++j) {
                dp[i][j] = dp[i][j - 1];
                if(i >= arr.get(j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i - arr.get(j - 1)][j - 1];
                }
            }
        }

        return dp[d][n];
    }

    // To debug
    void seeDPTable(boolean[][] dp) {
        for(boolean[] bool : dp) {
            System.out.println(Arrays.toString(bool));
        }
    }
}

public class DAALabExp14 {
    public static void main(String[] args) {
        Scanner scanData = new Scanner(System.in);
        System.out.println("Enter the cardinality of set: ");
        int n = scanData.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();

        System.out.println("Enter the elements of set: ");
        for(int i = 0; i < n; ++i) {
            int x = scanData.nextInt();
            arr.add(x);
        }

        System.out.println("Enter the a positive Integer 'd' which can be a possible subset sum: ");
        int d = scanData.nextInt();

        GetSubsetSum getAns = new GetSubsetSum();
        if(getAns.Find(arr, d)) {
            System.out.println("'d' is one of the subset sum, and can be found.");
        } else {
            System.out.println("'d' is not a subset of the given set.");
        }
    }
}
