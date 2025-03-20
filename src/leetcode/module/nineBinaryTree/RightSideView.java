package leetcode.module.nineBinaryTree;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {

    //这里的方法是DFS,深度优先搜索的方法，传递当前节点的深度
    //先访问右子树就是右视图，如果要求二叉树的左视图，就有限访问左子树



    private int depth = 0;
    private List<Integer> ans = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, depth);
        return ans;
    }

    private void dfs(TreeNode node, int depth){
        if (node == null){
            return;
        }

        if (ans.size() == depth){
            ans.add(node.val);
        }

        dfs(node.right, depth + 1);
        dfs(node.left, depth + 1);
    }




}
