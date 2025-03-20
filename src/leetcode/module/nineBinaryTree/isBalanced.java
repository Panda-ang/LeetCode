package leetcode.module.nineBinaryTree;

public class isBalanced {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    public int getHeight(TreeNode node){
        if(node == null) return 0;

        int leftH = getHeight(node.left);
        if (leftH == -1){
            return -1;
        }
        int rightH = getHeight(node.right);
        if(rightH == -1 || Math.abs(rightH - leftH)  > 1){
            return -1;
        }

        return Math.max(leftH, rightH) + 1;
    }
}
