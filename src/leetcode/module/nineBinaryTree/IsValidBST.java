package leetcode.module.nineBinaryTree;

public class IsValidBST {
    private long pre = Long.MIN_VALUE;

    //方法一：前序遍历
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    public boolean isValidBST(TreeNode node, long left, long right) {
        if (node == null) return true;

        long x = node.val;

        return left < x && x < right && isValidBST(node.left, left, x) && isValidBST(node.right, x, right);
    }

    //方法一：中序遍历
    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;

        if(!isValidBST(root.left) || root.val <= pre){
            return false;
        }

        pre = root.val;

        return isValidBST(root.right);
    }
}
