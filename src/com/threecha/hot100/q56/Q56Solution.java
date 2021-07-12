package com.threecha.hot100.q56;

import java.util.*;

public class Q56Solution {
    public static void main(String[] args) {
        int[][] temp = {{1,4},{0,4}};
        int[][] merge = merge(temp);
        System.out.print("[ ");
        for (int[] nums:merge){
            for (int num: nums){
                System.out.print( num + " ");
            }
        }
        System.out.print("]");
    }
    private static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(o1,o2)-> o1[0]-o2[0]);
        if(intervals.length==0 || intervals.length==1){
            return intervals;
        }
        for(int i =0;i<intervals.length;i++){
            int[] param = intervals[i];
            for(int k=i+1;k<intervals.length;k++){
                int[] paramNext = intervals[k];
                if (paramNext[0] > param[1]){
                    //当前段最小值 大于前一段最大值 后续均无法合并 当前循环结束
                    //此时2段无法合并 加入区间即可。
                    break;
                }else if(paramNext[1]<=param[1]){
                    // 当前段被包含在上一段里 因为前面做了排序处理 所以每一段的开头数据一定是按顺序排列
                    // 不做任何处理即可
                    intervals[k] = param;
                    continue;
                }else {
                    //当前段和上一段部分重叠 对当前段进行更新
                    intervals[k][0] = param[0];
                    intervals[i][1] = paramNext[1];
                }
            }
        }
        List<int[]> ints = new ArrayList<>();
        Map<Integer,int[]> map = new HashMap<>();
        for(int[] nums : intervals){
            if (!map.containsKey(nums[0]+nums[1])){
                map.put(nums[0]+nums[1],nums);
            }
        }
        ints.addAll(map.values());
        return ints.toArray(new int[ints.size()][2]);
    }
}
