package leetcode.module.nineBinaryTree;

public class CountNodes {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);
        if (leftH == rightH){
            return (1 << leftH) - 1 + countNodes(root.right) + 1; // 容易理解
        }else {
            return (1 << rightH) - 1 + countNodes(root.left) + 1;
        }
    }

    private int getHeight(TreeNode node){
        int height = 0;
        while (node != null){
            node = node.left;
            height++;
        }
        return height;
    }
}
