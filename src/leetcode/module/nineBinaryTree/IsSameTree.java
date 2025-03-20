package leetcode.module.nineBinaryTree;

public class IsSameTree {
    //边界条件就是如果这两个树有一个空的，就无法继续递归下去了，
    // 所以这里可以先简写为判断是否相等，其中一个为空了，只有另外一个也为空菜相等，从而继续判断左子树和右子树；
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null){
            return p == q;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

}
