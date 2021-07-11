package com.threecha.hot100.q53;

/***
 *
 * 动态规划解法版 又称为二叉树深度遍历
 *  定义数字组dp[i]为nums中以nums[i]结尾的最大子串和 则有递推公式为
 *          dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
 */

public class Q53SolutionDP {
    public int maxSubArray(int[] nums) {
        // 动态规划解法
        // dp[i]是以nums[i]结尾的连续子数组的最大值
        // 递推公式为： dp[i]=Math.max(dp[i-1]+nums[i],nums[i])
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
