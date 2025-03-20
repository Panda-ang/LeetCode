package leetcode.module.nineBinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return List.of();
        List<List<Integer>> ans = new ArrayList<>();

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()){
            int n = q.size();
            List<Integer> val = new ArrayList<>();
            while (n-- > 0){
                TreeNode node  = q.poll();
                val.add(node.val);
                if(node.left != null ) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            ans.add(val);
        }
        return ans;
    }
}
