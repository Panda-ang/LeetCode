package leetcode.module.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestPairs {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>(k); // 预分配空间
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < Math.min(nums1.length, k); i++) { // 至多 k 个
            pq.add(new int[]{nums1[i] + nums2[0], i, 0});
        }
        while (ans.size() < k) {
            int[] p = pq.poll();
            int i = p[1];
            int j = p[2];
            ans.add(List.of(nums1[i], nums2[j]));
            if (j + 1 < nums2.length) {
                pq.add(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
        }
        return ans;
    }
}
