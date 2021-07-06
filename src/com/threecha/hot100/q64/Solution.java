package com.threecha.hot100.q64;

class Solution {
    public int minPathSum(int[][] grid) {


        // 典型动态规划题 最左和最上 只有一条路径可达和为固定值
        // 其他地方的和为 左边点和上边点的最小和 加上点值
        // 给定集合grid 可以得集合长宽为n m
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int k = 0;k<n;k++){
                if(i==0 ){
                    if(k==0){
                        dp[0][0] = grid[0][0];
                    }else{dp[i][k] = dp[i][k-1]+grid[i][k];}
                }else if(k==0){
                    if(i==0){
                        dp[0][0] = grid[0][0];
                    }else{dp[i][k] = dp[i-1][k]+grid[i][k];}
                }else{
                    dp[i][k]=Math.min(dp[i-1][k],dp[i][k-1])+grid[i][k];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
