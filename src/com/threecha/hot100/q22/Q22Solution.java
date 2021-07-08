package com.threecha.hot100.q22;

import java.util.ArrayList;
import java.util.List;

/**
 * q22 括号生成
 * <p>
 * 思路：
 * n 代表生成的括号对数 求出所有可能的有效括号组合
 * <p>
 * 回溯算法+剪枝 减去不合适的部分即可
 * 回溯部分可以使用递归算法
 * <p>
 * ln 代表剩余可用的左括号数量 rn代表剩余可用的右括号数量
 * 1. 初始情况下 ln = rn 这时候只能增加左括号 【增加右括号的情况没用】
 * 2. ln > rn  失败
 * 3. ln < rn && ln > 0 左右均可
 * 4. rn > ln && ln = 0 增加右括号
 * 5. ln == 0 && rn ==0 没的说 加入结果集吧
 */
public class Q22Solution {

    List<String> result = new ArrayList();

    public List<String> generateParenthesis(int n) {
        DFSFunction(n, n, "");
        return result;
    }

    private void DFSFunction(int ln, int rn, String tempResult) {
        if (ln == rn && ln == 0) {
            result.add(tempResult);
            return;
        }
        if (ln == rn) {
            DFSFunction(ln - 1, rn, tempResult + "(");
        }
        if (ln < rn && ln > 0) {
            DFSFunction(ln - 1, rn, tempResult + "(");
            DFSFunction(ln, rn - 1, tempResult + ")");
        }
        if (rn > ln && ln == 0) {
            DFSFunction(ln, rn - 1, tempResult + ")");
        }
    }
}
