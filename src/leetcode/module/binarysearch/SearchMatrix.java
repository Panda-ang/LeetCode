package leetcode.module.binarysearch;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = -1;
        int right = m * n;

        while (left + 1 < right){
            int mid = left + (right - left) / 2;
            int x = matrix[mid / n][mid % n];
            if (target == x){
                return true;
            }

            if (x < target){
                left = mid;
            }else {
                right = mid;
            }

        }
        return false;
    }
}
