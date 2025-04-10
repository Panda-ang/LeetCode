package leetcode.module.nineBinaryTree;

public class KthSmallest {
    private int ans;
    private int k;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left); // 左
        if (--k == 0) {
            ans = node.val; // 根
            return;
        }
        dfs(node.right); // 右
    }

    public static void main(String[] args) {
        KthSmallest kthSmallest = new KthSmallest();
        TreeNode head = new TreeNode(3);
        head.left  = new TreeNode(1);
        head.left.right = new TreeNode(2);
        head.right = new TreeNode(4);
        kthSmallest.kthSmallest(head, 3);
    }



}
