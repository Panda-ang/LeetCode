package leetcode.module.testPackage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hIndex(new int[]{3, 0, 6, 1, 5}));

    }

    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] cnt = new int[n + 1];
        for (int c : citations) {
            cnt[Math.min(c, n)]++; // 引用次数 > n，等价于引用次数为 n
        }
        int s = 0;//设 s 为引用次数 ≥i 的论文数，我们需要算出满足 s≥i 的最大的 i
        for (int i = n; ; i--) { // i=0 的时候，s>=i 一定成立
            s += cnt[i];
            if (s >= i) { // 说明有至少 i 篇论文的引用次数至少为 i
                return i;
            }
        }
    }

}
