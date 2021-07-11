package com.threecha.hot100.q48;


/**
 * q48 旋转图像
 * <p>
 * 题目要求顺时针旋转90度 那么上下翻转在对角线翻转即可完成
 */
public class Q48Solution {
    public static void main(String[] args) {
    int[][] matrix = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
    solution(matrix);
    }

    private static void solution(int[][] matrix) {
        // 上下翻转
        int length = matrix.length;
        int start = 0;
        int end = length - 1;
        if (length == 0) {
            return;
        }
        //  上下交换
        while (start <= end) {
            int[] temp = matrix[start];
            matrix[start] = matrix[end];
            matrix[end] = temp;
            start++;
            end--;
        }
        // 对角线交换
        for (int i = 0; i < matrix.length; i++) {
            for (int k = i; k < matrix.length; k++) {
                // 执行交换
                int temp = matrix[i][k];
                matrix[i][k] = matrix[k][i];
                matrix[k][i] = temp;

            }
        }

    }
}
