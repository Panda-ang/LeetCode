package leetcode.module.nineBinaryTree;

public class MaxDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxDepth(root));
    }
    public static int maxDepth(TreeNode root){


        if(root == null){
            return 0;
        }

        int leftD = maxDepth(root.left);
        int rightD = maxDepth(root.right);

        return Math.max(leftD, rightD) + 1;

    }
}
