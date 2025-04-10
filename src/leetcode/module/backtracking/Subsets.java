package leetcode.module.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    private final List<List<Integer>> ans = new ArrayList<>();
    private final List<Integer> path = new ArrayList<>();
    private int[] nums;

    //方法一：选还是不选
    public List<List<Integer>> subsets1(int[] nums) {
        this.nums = nums;
        dfs(0);
        return ans;
    }

    private void dfs(int i){

        //然后写边界条件
        if (i == nums.length){
            ans.add(new ArrayList<>(path)); //注意这里path是全局变量，实惠变化的，而且path是引用型数据，
            // 这样复制ans.add(path)存储的是path的应用，会导致后续path被改变时候，ans里面的数据也一起改变，
            return;
        }


        //首先写非边界条件
        //不选的话，这个数直接跳过， 直接递归到dfs(i + 1)

        dfs(i + 1);//dfs(i + 1)



        // 选(选 nums[i])的话，先把他加到路径
        path.add(nums[i]);

        //然后递归
        dfs(i + 1);

        //由于我们是在路径后面添加元素，所以递归之前什么样，递归之后也应该是什么样，所以在返回之前应当恢复到递归之前的样子
        path.remove(path.size() - 1); // 恢复现场

    }

    //方法2：从答案的视角枚举
    public List<List<Integer>> subsets2(int[] nums) {

        this.nums = nums;
        dfs2(0);
        return ans;

    }

    private void dfs2(int i){

        ans.add(new ArrayList<>(path));
        for (int j = i; j < nums.length; j++){
            path.add(nums[j]);
            dfs(j + 1);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> subsets3(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++){
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++){
                if (((i >> j) & 1) == 1){
                    subset.add(nums[j]);
                }
            }
            ans.add(subset);
        }
        return ans;
    }




}
