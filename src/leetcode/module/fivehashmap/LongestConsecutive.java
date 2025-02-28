package leetcode.module.fivehashmap;

import java.util.HashSet;
import java.util.Set;

//128. 最长连续序列
//https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-interview-150

public class LongestConsecutive {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println(longestConsecutive(new int[]{1,0,1,2}));
        System.out.println(longestConsecutive(new int[]{0}));
    }


    //放到set里面减少查找次数，判断当前遍历的数字可不可以作为连续数组的起始点；
    public static int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        int ans = 0;

        for (int num : nums){
            st.add(num);
        }

        for(int x : st){

            if(st.contains(x - 1)){
                continue;
            }

            int y = x + 1;
            while (st.contains(y)){
                y++;
            }

            ans = Math.max(ans , y - x);
        }
        return ans;


    }


}
