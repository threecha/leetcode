package com.threecha.hot100.q20;

import java.util.Stack;

/**
 * 使用栈可以完成操作
 * 碰到左括号入栈 右括号出 且对比是否符合要求
 * 不符合要求可以直接范围false
 * 成功的情况 字符串遍历到结尾 且栈为空 即认为成功
 */

public class Q20Solution {
    public static void main(String[] args) {
        System.out.println(solution("([)]"));
    }

    private static boolean solution(String str) {
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i<chars.length;i++){
            if(chars[i] == '('){stack.push(')');}
            else if(chars[i] == '['){stack.push(']');}
            else if(chars[i] == '{'){stack.push('}');}
            else if (stack.isEmpty() || stack.pop()!=chars[i] ) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
