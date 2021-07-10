package com.threecha.hot100.q32;


import java.util.Stack;

/**
 * 最长有效括号
 * <p>
 * 思路： 遇到左括号就入栈 右括号就出栈
 * <p>
 * 用当前右括号的index 减去栈顶元素的index 得到当前最大的长度
 * <p>
 * 需要在栈底 设置元素的初始化值 ")"
 * <p>
 * <p>
 * <p>
 * 思路2： 使用动态规划 解决括号匹配问题
 */
public class Q32Solution {
    public static void main(String[] args) {
        int i = longestValidParentheses(")()())");
        Stack<Integer> stack = new Stack<>();
        int size = stack.size();
        System.out.println(size);
        System.out.println(i);
    }

    public static int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.size() == 0) {
                    //说明底栈元素已经出栈 需要设置为当前最新的右括号作为新的底栈元素
                    stack.push(i);
                } else {
                    // 不为空 说明有新的左括号入栈 可以开始计算长度
                    result = Math.max(i - stack.peek(), result);
                }
            }
        }
        return result;
    }


    /***
     *  动态规划思路 dp[i] 是以i结尾的有效子串的长度  notice 子串必须以i结尾。
     *  i依次向右移动 最终获取最大值即可。
     *  1. i>2 s[i] == ')'
     *
     * @param s
     * @return
     */
    public static int solution2(String s) {
        int length = s.length();
        int[] dp = new int[length];
        int result = 0;// 记录最大的有效长度
        // dp[i] 是以i结尾的子串的 最大有效字符串长度
        dp[0] = 0;
        if (s.charAt(1) == ')' && s.charAt(0) == '(') {
            dp[1] = 2;
        } else {
            // 其他情况下的括号均不能构成闭环 故dp[2] =0;
            dp[2] = 0;
        }
        for(int i =0;i<length;i++){
            if(i>1){
                if(s.charAt(i)==')'){
                    // 若i-i 可以匹配成功那么
                    if(s.charAt(i-1)=='('){
                        dp[i]=dp[i-2]+2;
                    }
                }else{
                    dp[i]=0;
                }

            }
        }

        return 0;
    }

}
