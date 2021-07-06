package com.threecha.hot100.q53;

public class Test {
    public static void main(String[] args) {
        SolutionDP solution = new SolutionDP();
        int[] tempArry = new int[]{-1,0,-2};
        int i = solution.maxSubArray(tempArry);
        System.out.println("最终结果为: "+i);
    }

}
