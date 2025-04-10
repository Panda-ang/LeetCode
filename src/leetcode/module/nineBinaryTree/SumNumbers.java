package leetcode.module.nineBinaryTree;

public class SumNumbers {
    private int ans = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode node, int x){
        if (node == null) return;

        x = x * 10 + node.val;
        if (node.left == node.right){
            ans += x;
            return;
        }
        dfs(node.left, x);
        dfs(node.right, x);
    }
}
