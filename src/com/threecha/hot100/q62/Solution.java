package com.threecha.hot100.q62;

/***
 *  不同路径
 *  动态规划解题
 *
 *  思路：到达[n,m]位置只有2个方案
 *  方案1：[n,m-1] 向右移动一个位置
 *  方案2：[n-1,m] 向下移动一个位置
 *
 *  可得：dp[n,m]= dp[n-1,m]+[n,m-1]
 *
 *  临界条件为：在顶行时候 dp[0,]
 *
 */
public class Solution {
}
