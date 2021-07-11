package com.threecha.hot100.q55;

/**
 * q55 跳跃游戏
 *
 *  思路：对每一个位置计算当前可以达的最大路径 以及当前坐标是否可达
 *
 *  若当前坐标不可达 那么最后一个坐标一定不可达
 */
public class Q55Solution {
    public static void main(String[] args) {

    }
    private static boolean solution(int [] nums){
        int reachIndex = 0;
        for(int i = 0;i < nums.length;i++ ){
            if (i> reachIndex){return false;}
            reachIndex = Math.max(reachIndex,i+nums[i]);
        }
        return true;
    }

}
