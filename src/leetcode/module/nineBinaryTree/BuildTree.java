package leetcode.module.nineBinaryTree;

import java.util.HashMap;
import java.util.Map;

//前序和中序构造二叉树
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        HashMap<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < inorder.length; i++){
            index.put(inorder[i], i);
        }
        return dfs(preorder,0, n, 0, n, index);

    }

    private TreeNode dfs(int[] preorder,  int preL, int preR, int inL, int inR, Map<Integer, Integer> index){
        if (preL == preR) return null;

        int leftSize = index.get(preorder[preL]) - inL;
        TreeNode left = dfs(preorder, preL +  1, preL + 1 + leftSize, inL, inL + leftSize, index);
        TreeNode right = dfs(preorder, preL + 1 + leftSize, preR, inL + 1 + leftSize, inR, index);
        return new TreeNode(preorder[preL], left, right);

    }
}
