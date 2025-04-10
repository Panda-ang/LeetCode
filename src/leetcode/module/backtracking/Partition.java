package leetcode.module.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Partition {
    private final List<List<String>> ans = new ArrayList<>();
    private final List<String> path = new ArrayList<>();
    private String s;

    public List<List<String>> partition(String s) {
        this.s = s;
        dfs(0);
        return ans;
    }

    // 考虑 s[i] ~ s[n-1] 怎么分割
    private void dfs(int i) {
        if (i == s.length()) { // s 分割完毕
            ans.add(new ArrayList<>(path)); // 复制 path
            return;
        }
        for (int j = i; j < s.length(); j++) { // 枚举子串的结束位置
            if (isPalindrome(i, j)) {
                path.add(s.substring(i, j + 1)); // 分割！
                // 考虑剩余的 s[j+1] ~ s[n-1] 怎么分割
                dfs(j + 1);
                path.remove(path.size() - 1); // 恢复现场
            }
        }
    }

    private boolean isPalindrome(int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Partition soulution = new Partition();
        soulution.partition("aab");
    }



}
