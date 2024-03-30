import java.util.*;
import java.io.*;

public class Quiz2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File(args[0]));
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[] resources = new int[n];
        for (int i = 0; i < n; i++) {
            resources[i] = scanner.nextInt();
        }
        scanner.close();

        // find the knapsack matrix
        boolean[][] dp = L(m, n, resources);
        
        // find the max weight that can be carried
        int maxWeight = maxWeight(m, n, resources);
        System.out.println(maxWeight);
        
        // print the knapsack matrix
        print(dp, m, n);
    }

    public static boolean[][] L(int m, int n, int[] resources){
        boolean[][] dp = new boolean[m + 1][n + 1];
        for(int i = 0; i <= n; i++) {
            dp[0][i] = true;
        }
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(i >= resources[j - 1]) {
                    dp[i][j] = dp[i][j - 1] || dp[i - resources[j - 1]][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp;
    }

    public static int maxWeight(int m, int n, int[] resources) {
        boolean[][] dp = L(m, n, resources);
        int maxWeight = 0;
        for(int i = m; i >= 0; i--) {
            if(dp[i][n]) {
                maxWeight = i;
                break;
            }
        }
        return maxWeight;
    }

    public static void print(boolean[][] dp, int m, int n) {
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                System.out.print(dp[i][j]? 1: 0);
            }
            System.out.println();
        }
    }
}
