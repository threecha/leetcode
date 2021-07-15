package com.threecha.hot100.q75;

/**
 * q75 颜色分类 原地排序
 * <p>
 * 思路: 双指正问题
 * 默认给所有的元素全部放置为2
 * 在一趟遍历中 若出现<2的 第一个指正向后移动同时设置值为1
 * 若<1 第二个指针向后移动同时设置为0
 * 一趟扫描结束后 即分类完成。
 */

public class Q75Solution {
    public static void main(String[] args) {
        int[] ints = {2, 0, 1};
        solution(ints);
    }

    private static void solution(int[] nums) {
        int l0 = 0;
        int l1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            nums[i]=2;// 先全部设置为2
            if (temp<2){
                nums[l1]=1; // 把小于2的全部设置为1
                l1++;
            }
            if (temp <1){
                nums[l0]=0;
                l0++;// 小于1的部分全部设置为0 那么剩下的部分就是1
            }
        }
    }
}
