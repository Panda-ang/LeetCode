package leetcode.module.fivehashmap;

//219. 存在重复元素 II
//https://leetcode.cn/problems/contains-duplicate-ii/description/?envType=study-plan-v2&envId=top-interview-150

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ContainsNearbyDuplicate {
    public static void main(String[] args) {
        containsNearbyDuplicate2(new int[]{1,2,3,1}, 3);
        containsNearbyDuplicate(new int[]{1,0,1,1}, 3);
    }

    //方法一：枚举右，维护左
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> last = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (last.containsKey(x) && i - last.get(x) <= k) {
                return true;
            }
            // 这里直接覆盖是因为<=k， 出现位置越靠后越有可能在后面出现相同数字时满足距离<=k的条件
            last.put(x, i);
        }
        return false;
    }

    //方法二：定长滑动窗口
    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) { // set 中有 nums[i]
                return true;
            }
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }




}
