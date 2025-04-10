package leetcode.module.nineBinaryTree;

public class GetMinimumDifference {

    private int ans = Integer.MAX_VALUE;
    private int pre = Integer.MIN_VALUE/2;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node){
        if (node == null) return;

        dfs(node.left);
        ans = Math.min(ans, node.val - pre);
        pre = node.val;
        dfs(node.right);
    }




}
