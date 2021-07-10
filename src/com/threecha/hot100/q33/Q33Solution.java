package com.threecha.hot100.q33;


/**
 * 数组进行了旋转 从单向有序数组变成了2部分有序的数组
 * 时间复杂度为o(log n)的方式 ： 二分法
 * <p>
 * 思路：
 * 1. 计算 (start+end)/2 = mid
 * 原始数列是2段有序的。在二分的过程中可以总是有[s-m-e]这样的二段组合
 * <p>
 * 1. nums[mid] > nums[start] 那么说明mid 的左边这段是有序的 比较 target 和start mid 的大小来判断是在有序段和非有序段
 * target若在左侧 那么 end = mid;
 * 在非有序段中 依然是2段有序 判断规则和上边一样。 ==> start = mid;
 * <p>
 * 2. nums[mid] < nums[start] 那么是说明mid的右端有序 判断target是否 nums[mid]<=target<=nums[end] 若在区间内 ==> start = mid;
 * 若不在区间内 end = mid; 再次二分判断
 */
public class Q33Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1};
        System.out.print(search(nums, 1));

    }

    public static int search(int[] nums, int target) {
        int length = nums.length;
        int s = 0;
        int end = length - 1;
        while (s <= end) {
            int mid = s + (end - s) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[s]) {
                //旋转点在右侧 等于号的情况下 旋转点也在右侧
                if (nums[mid] > target && target >= nums[s]) {
                    // 在mid 左侧有序
                    end = mid - 1;
                } else {
                    s = mid + 1;
                }
            } else {
                // 旋转点在左侧 mid 右端有序
                if (nums[end] >= target && target > nums[mid]) {
                    // 在mid右侧继续执行二分搜索
                    s = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}

