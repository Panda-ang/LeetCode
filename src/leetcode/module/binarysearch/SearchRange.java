package leetcode.module.binarysearch;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int start = lowerBound(nums, target);
        if (start == nums.length || nums[start] != target){
            return new int[]{-1, -1};
        }

        int end = lowerBound(nums, target + 1) -1;
        return new int[]{start, end};

    }

    private int lowerBound(int[] nums, int target) {
        int left = -1;
        int right = nums.length;

        while (left + 1 < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                left = mid;
            }else {
                right = mid;
            }
        }
        return right;

    }
}
