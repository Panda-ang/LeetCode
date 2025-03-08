package leetcode.module.sixinterval;

//57. 插入区间
//https://leetcode.cn/problems/insert-interval/description/?envType=study-plan-v2&envId=top-interview-150

import java.util.ArrayList;
import java.util.List;

public class Insert {
    public static void main(String[] args) {

        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        System.out.println(insert(intervals,newInterval));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int i = 0;
        List<int[]> ans = new ArrayList<>();

        //把newInterval之前不重叠的区间加入到ans中，更新i
        while (i < n && intervals[i][1] < newInterval[0]){
            ans.add(intervals[i]);
            i++;
        }


        while (i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        ans.add(newInterval);

        while (i < n){
            ans.add(intervals[i]);
            i++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
