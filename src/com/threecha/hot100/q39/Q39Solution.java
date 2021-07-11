package com.threecha.hot100.q39;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * q39 组合总数 看做是一个DFS的深度优先递归树
 *
 * List[] tempResult 存储的就是深度遍历上的路径
 *
 *  tempResult < target 继续向下一层遍历
 *  下一层的第一个数的和 tempResult > target 退出当前递归【后续都大于target没有继续的必要了】
 *
 *  == target 增加到结果集 然后退出当前循环
 */

public class Q39Solution {
    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(lists);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 对candidates 进行排序
        Arrays.sort(candidates);
        for(int i=0;i<candidates.length;i++){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(candidates[i]);
            DFSFunction(list,candidates,target,candidates[i],i);
        }
        return result;

    }
    static List<List<Integer>> result = new ArrayList<>();
    private static void DFSFunction(List<Integer> tempResult,int[] candidates,int target,int tempSum,int index) {
        if(tempSum==target){
            result.add(tempResult);
        }else if (tempSum < target){
            for (int i = index;i< candidates.length;i++) {
                ArrayList<Integer> list = new ArrayList<>(tempResult);
                list.add(candidates[i]);
                DFSFunction(list, candidates, target, tempSum + candidates[i],i);
            }
        }
    }

}
