package leetcode.module.nineBinaryTree;

import java.util.HashMap;
import java.util.Map;

//从中序与后序遍历构造二叉树
public class BuildTree2 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> index = new HashMap<>();
        int n = inorder.length;
        for(int i = 0; i < n; i++){
            index.put(inorder[i], i);
        }

        return dfs(postorder, 0, n, 0, n, index);
    }

    private TreeNode dfs(int[] postorder, int postL, int postR, int inL, int inR, Map<Integer, Integer> index){
        if (postL == postR) return null;

        int leftSize = index.get(postorder[postR - 1]) - inL;

        TreeNode left = dfs(postorder, postL, postL + leftSize, inL, inL + leftSize, index);
        TreeNode right = dfs(postorder, postL + leftSize , postR - 1, inL + leftSize + 1, inR, index);
        return new TreeNode(postorder[postR - 1], left, right);

    }
}
