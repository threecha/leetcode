package com.threecha.hot100.q49;

import java.util.*;

/**
 * q49字母异位词分组
 *
 * 思路 先对所有字符串字典序排序 然后存入Map 若key存在说明是同一分组字符串
 */
public class Q49Solution {
    public static void main(String[] args) {

    }

    public List<List<String>> solution(String[] strs) {
        Map<String,List<String>> hashMap = new HashMap<>();
        List<List<String>> resultList = new ArrayList<>();
        for (String s : strs) {
            String str = strSort(s);
            if (!hashMap.containsKey(str)) {
                List<String> strings = new ArrayList<>();
                strings.add(s);
                hashMap.put(str, strings);
                resultList.add(strings);
            } else {
                // 若key存在 加入结果集即可
                List<String> strings = hashMap.get(str);
                strings.add(s);
            }
        }
        return resultList;
    }

    private static String strSort(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
