package leetcode.module.binarysearch;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0;
        int right = m;
        int halfLen = (m + n + 1) / 2;

        //partitionX在数组上滑动，根据partitionX求出partitionY
        for ( int partitionX = 0; partitionX <= m; partitionX++){
            int partitionY = halfLen - partitionX;

            //分别求出两个分割位置左右的值
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];

            //若找到满足条件的分割方式，则求解中位数
            if (maxLeftX <= minRightY && maxLeftY <= minRightX){
                if((m + n) % 2 == 0){
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                }else {
                    return Math.max(maxLeftX,maxLeftY);
                }
            }
        }
        throw new IllegalArgumentException("Input arrays are not sorted properly.");
    }
}
