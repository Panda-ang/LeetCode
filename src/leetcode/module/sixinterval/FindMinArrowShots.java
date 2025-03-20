package leetcode.module.sixinterval;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots {
    public static void main(String[] args) {
        //int[][] points = {{1,2},{3,4},{5,6},{7,8}};
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};

        System.out.println(findMinArrowShots(points));

    }

    //排序右端点
    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparing(p -> p[1]));

        int ans = 0;
        long pre = Long.MIN_VALUE;

        for(int[] p : points){
            if(pre < p[0]){
                pre = p[1];
                ans++;
            }
        }
        return ans;
    }
}
