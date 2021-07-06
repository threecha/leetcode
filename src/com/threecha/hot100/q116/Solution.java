//package com.threecha.ltcode.q116;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
///***
// * q 116 解决杨辉三角问题
// */
//class Solution {
//    public List<List<Integer>> generate(int numRows) {
//        //为第n行第i个数的值 ：dp[n][i] = d[n-1][]
//        int n = numRows;
//        int[][] dp = new int[n][];//假设dp[i][k]为第i行第k个数 递推公式如下
//        List<List<Integer>> res = new ArrayList<>();
//        //初始化前三个数
//        List<Integer> temp = new ArrayList<>();
//
//        dp[1][1] = 1;dp[2][1]=1;dp[2][2]=1;
//        for(int i =0;i<n;i++){
//
//            for(int k=0;k<n;k++){
//                if (i==1 || k==1 || k== n-1){
//                    dp[i][k]=1;
//                }else {
//                    dp[i][k]= dp[i-1][k-1]+dp[i-1][k];
//                }
//            }
//        }
//        List<int[]> ints = Arrays.asList(dp[n - 1]);
//        return dp[n];
//    }
//}