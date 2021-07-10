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
}
