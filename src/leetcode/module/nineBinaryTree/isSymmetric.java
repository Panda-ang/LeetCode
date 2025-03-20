package leetcode.module.nineBinaryTree;

public class isSymmetric {

    public boolean isSymmetric(TreeNode root){
        return isSame(root.left, root.right);
    }

    public boolean isSame(TreeNode p, TreeNode q){
        if(p == null || q == null){
            return p == q;
        }

        return p.val == q.val && isSame(p.left, q.right) && isSame(p.right, q.left);
    }
}
