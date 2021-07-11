package com.threecha.hot100.q46;

import java.util.ArrayList;
import java.util.List;

/**
 * q46全排列 DFS
 */
public class Q46Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> tempList = new ArrayList<>();
            tempList.add((nums[i]));
            ArrayList<Integer> index = new ArrayList<>();
            index.add(i);
            DFSFunction(nums, index, tempList);
        }
        System.out.println(result);
    }

    static List<List<Integer>> result = new ArrayList<>();

    private static void DFSFunction(int[] nums, List<Integer> index, List<Integer> tempResult) {
        if (index.size() < nums.length) {
            for (int i = 0; i < nums.length; i++) {
                if (!index.contains(i)) {
                    ArrayList<Integer> list = new ArrayList<>(tempResult);
                    list.add(nums[i]);
                    ArrayList<Integer> tempIndex = new ArrayList<>(index);
                    tempIndex.add(i);
                    DFSFunction(nums, tempIndex, list);

                }
            }
        }
        if (index.size() == nums.length) {
            result.add(tempResult);
        }
    }
}
