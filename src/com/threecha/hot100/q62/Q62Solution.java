package com.threecha.hot100.q62;

/**
 * q62 动态规划问题
 * <p>
 * 思路： int[][] dp = new int[m][n]
 * <p>
 * 假设 dp[i][k] 为到达第i行k列的最大路径数 且 dp[i][k] 只有2种办法可以到达 从左到 或者从上到
 */
public class Q62Solution {
    public static void main(String[] args) {
        int solution = solution(3, 3);
        System.out.println(solution);
    }

    private static int solution(int m, int n) {
        int[][] dp = new int[m][n];
        // dp初始值
        dp[0][0] = 1;
        for (int i = 0; i < m ; i++) {
            for (int k = 0; k < n; k++) {
                if (i == 0 && k > 0) {
                    dp[i][k] = 1;
                } else if (k == 0 && i > 0) {
                    dp[i][k] = 1;
                } else if (i > 0) {
                    dp[i][k] = dp[i-1][k]+dp[i][k-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
