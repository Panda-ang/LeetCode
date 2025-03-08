package leetcode.module.sixinterval;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0,1,2,4,5,7}));
    }

    public static List<String> summaryRanges(int[] nums){
        List<String> result = new ArrayList<>();
        int n = nums.length;
        int start = nums[0];
        for(int i = 1; i < n; i++){
            if(nums[i] != nums[i - 1] + 1){
                result.add(format(start, nums[i - 1]));
                start = nums[i];
            }
        }

        result.add(format( start, nums[nums.length - 1]));
        return result;

    }

    private static String format(int start, int end){
       return start == end ? String.valueOf(start) : start + "->" + end;
    }
}
