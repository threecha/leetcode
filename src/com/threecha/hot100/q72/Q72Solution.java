package com.threecha.hot100.q72;

/***
 * 动态规划问题 q72 编辑距离
 *
 * 假设dp[i][k] 为word1 的前i个字符串 转化为word2的前k个字符串所使用的最少操作数
 *
 * 从 word1 的前i个字符转化 有四种情况
 *  1. 2字符串相等 无需操作 if(w1[i]== w2[k]) dp[i][k] = dp[i-1][k-1];
 *  2. word1删除一个字符串 变成k  ===-> w1 的前i-1个字符串可以转化为w2 ===-> 那么dp[i-1][k]变为dp[i][k] 只需要增加一步删除即可 ==-> dp[i][k] = dp[i-1][k]+1
 *  3. word1增加一个字符串 变成k  ===-> w1 只能匹配到w2的k-1个字符所以需要增加 dp[i][k] = dp[i][k-1]+1 [dp[i][k-1] 增加一步 添加字符串操作即可]
 *  4. word1替换一个字符串 变成K  ===-> w1 前i-1号字符可以 转化为 w2的前k-1字符 然后将w1的i号字符替换为w2的k dp[i][k] = dp[i-1][k-1]+1
 *
 */
public class Q72Solution {
    public static void main(String[] args) {
        int solution = solution("horse", "ros");
        System.out.println(solution);

    }

    private static int solution(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        // 第一行 第一列
        // 对dp赋初始值 int的初始值默认为0 所以 i==k==0 的情况是不需要额外处理的。
        for (int k = 1; k < l2 + 1; k++) {
            dp[0][k] = dp[0][k - 1] + 1;// 这里写成k 也是ok的
        }
        for (int i = 1; i < l1 + 1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;// 这里写成i 也是ok的
        }
        for (int i = 1; i < l1 + 1; i++) {
            for (int k = 1; k < l2 + 1; k++) {
                //w1的第i个字符和w2的第k个字符相等 表示为word1.charAt(i - 1) == word2.charAt(k - 1)
                // 而不是 word1.charAt(i) == word2.charAt(k)
                if (word1.charAt(i - 1) == word2.charAt(k - 1)) {
                    dp[i][k] = dp[i - 1][k - 1];
                } else {
                    dp[i][k] = Math.min(Math.min(dp[i - 1][k], dp[i][k - 1]), dp[i - 1][k - 1]) + 1;
                }

            }
        }
        return dp[l1][l2];
    }
}
