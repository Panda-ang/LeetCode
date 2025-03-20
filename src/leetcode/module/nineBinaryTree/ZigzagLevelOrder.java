package leetcode.module.nineBinaryTree;

import java.util.*;

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return List.of();

        List<List<Integer>> ans = new ArrayList<>();

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()){
            List<Integer> val = new ArrayList<>();
            int n = q.size();
            while (n-- > 0){
                TreeNode node  = q.poll();
                val.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null ) q.offer(node.right);
            }
            if(ans.size() % 2  > 0) Collections.reverse(val);
            ans.add(val);
        }
        return ans;


    }

}
