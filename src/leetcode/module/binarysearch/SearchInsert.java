package leetcode.module.binarysearch;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
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
