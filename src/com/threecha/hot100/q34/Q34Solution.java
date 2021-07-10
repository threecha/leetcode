package com.threecha.hot100.q34;


/***
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * 思路 使用二分法找到等于目标值的元素
 *
 *  等于元素的时候记录index 不要立即返回
 *  若查找左端点 right = mid-1 若依然符合更新index
 *  若查找右端点 left =mid +1 依然符合更新index
 *
 *  结束条件 left>right
 */
public class Q34Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        searchRange(nums, 1);
    }

    private static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = binarySearch(nums, target, true);
        result[1] = binarySearch(nums, target, false);
        return result;
    }

    private static int binarySearch(int[] nums, int target, boolean leftOrRight) {
        // leftOrRight ture---> left
        // false ------> right
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        int result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                // 找到目标值的情况
                result = mid;
                if (leftOrRight) {
                    //找左端点 则需要从右侧逼近
                    // 在mid 左侧二分 若还能找到说明有更小的更新，若无法找到说明当前的mid 就是左端点
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return result;
    }
}
