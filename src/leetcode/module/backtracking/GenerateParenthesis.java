package leetcode.module.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    private int n;
    private final List<String> ans = new ArrayList<>();
    private char[] path;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        path = new char[n * 2];
        dfs(0, 0);
        return ans;
    }

    private void dfs(int i, int open) {
        if (i == n * 2) { // 括号构造完毕
            ans.add(new String(path)); // 加入答案
            return;
        }
        if (open < n) { // 可以填左括号
            path[i] = '('; // 直接覆盖
            dfs(i + 1, open + 1); // 多了一个左括号
        }
        if (i - open < open) { // 可以填右括号
            path[i] = ')'; // 直接覆盖
            dfs(i + 1, open);
        }
    }

}
