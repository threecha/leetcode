package com.threecha.hot100.q53;
/**
 * 暴力解法 循环遍历得到最大值。若需要得到最大值得串，记录下起点坐标和终点坐标即可
 * */
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];// 暂定第一个为最大
        for (int i = 0; i < nums.length; i++) {
            int tempSum = nums[i];
            maxSum = Math.max(tempSum,maxSum);//关键的一步 不做这步操作容易漏掉 单个值作为最大的情况
            for (int k = i + 1; k < nums.length; k++) {
                tempSum += nums[k];
                maxSum = Math.max(tempSum,maxSum);
            }
        }
        return maxSum;
    }
}
