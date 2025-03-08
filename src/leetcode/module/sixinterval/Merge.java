package leetcode.module.sixinterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//56 合并区间
//https://leetcode.cn/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-interview-150
public class Merge {
    public static void main(String[] args) {
        System.out.println(merge(new int[][]{{1,3},{2,6},{8,10},{15,18}}));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (Comparator.comparing(p -> p[0])));

        List<int[]> ans = new ArrayList<>();

        for(int[] p : intervals){
            int m = ans.size();
            if (m > 0 && p[0] <= ans.get(m - 1)[1] ){
                ans.get(m - 1)[1] = Math.max(p[1], ans.get(m - 1)[1]);
            }else{
                ans.add(p);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }












    public static int[][] merge1(int[][] intervals) {
        Arrays.sort(intervals, (p, q) -> p[0] - q[0]); // 按照左端点从小到大排序
        List<int[]> ans = new ArrayList<>();
        for (int[] p : intervals) {
            int m = ans.size();
            if (m > 0 && p[0] <= ans.get(m - 1)[1]) { // 可以合并
                ans.get(m - 1)[1] = Math.max(ans.get(m - 1)[1], p[1]); // 更新右端点最大值
            } else { // 不相交，无法合并
                ans.add(p); // 新的合并区间
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
