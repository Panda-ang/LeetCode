package leetcode.module.heap;

import java.util.PriorityQueue;
import java.util.Random;

public class FindKthLargest {
    private Random random = new Random();

    //方法一，最小堆，但是时间复杂度是 O(nlogk) 题目要求 O(n);
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int i = 0;i < k;i++) {
            minHeap.offer(nums[i]);
        }
        for (int i = k;i < nums.length;i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }

    public int findKthLargest2(int[] nums, int k) {
        int n = nums.length;
        // 第 k 大等价于第 n - k 小（从 0 开始的索引）
        return quickSelect(nums, 0, n - 1, n - k);
    }

    private int quickSelect(int[] nums, int left, int right, int targetIndex){

        if (left == right) {
            return nums[left]; // 只剩一个元素，返回它
        }

        // 随机选择一个 pivot，避免最坏情况
        int pivotIndex = left + random.nextInt(right - left + 1);
        pivotIndex = partition(nums, left, right, pivotIndex);

        if (pivotIndex == targetIndex) {
            return nums[pivotIndex]; // 找到了
        } else if (pivotIndex < targetIndex) {
            return quickSelect(nums, pivotIndex + 1, right, targetIndex); // 去右边找
        } else {
            return quickSelect(nums, left, pivotIndex - 1, targetIndex); // 去左边找
        }

    }

    private int partition(int[] nums, int left, int right, int pivotIndex ){
        int pivotValue = nums[pivotIndex];
        // 将 pivot 移到末尾
        swap(nums, pivotIndex, right);
        int storeIndex = left;


        // 所有小于 pivot 的都放左边
        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, storeIndex++, i);
            }
        }

        // 把 pivot 放回最终位置
        swap(nums, storeIndex, right);
        return storeIndex;
    }


    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
