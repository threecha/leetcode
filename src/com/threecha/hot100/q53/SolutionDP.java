package com.threecha.hot100.q53;

/***
 *
 * 动态规划解法版 又称为二叉树深度遍历
 *  定义数字组dp[i]为nums中以nums[i]结尾的最大子串和 则有递推公式为
 *          dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
 */

public class SolutionDP {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        // 定义初始值
        int maxvalue = nums[0];
        dp[0] = nums[0];// 设定动态规划的起点
        for (int i = 1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            maxvalue = Math.max(maxvalue,dp[i]);

        }
    return maxvalue;
    }
}
