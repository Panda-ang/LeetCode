package leetcode.module.nineBinaryTree;

import java.util.ArrayList;
import java.util.List;

public class Connect {

    private List<Node> pre = new ArrayList<>();

    //方法一：最容易理解的方法 BFS
    public Node connect(Node root) {
        if (root == null) return null;

        List<Node> q = List.of(root);
        while (!q.isEmpty()){
            List<Node> tmp = q;
            q = new ArrayList<>();
            for (int i = 0; i < tmp.size(); i++){
                Node node = tmp.get(i);
                if(i > 0){
                    tmp.get(i - 1).next = node;
                }

                if (node.left != null){
                    q.add(node.left);
                }

                if (node.right != null){
                    q.add(node.right);
                }
            }
        }
        return root;
    }



    //方法二：DFS 类似右视图
    public Node connect2(Node root) {
        if (root == null) return null;

        dfs(root, 0);
        return root;
    }

    private void dfs(Node node, int depth){
        if (node == null) return ;

        if(pre.size() == depth){
            pre.add(node);
        }else {
            pre.get(depth).next = node;
            pre.set(depth,node);

        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

    //方法三:链表
    public Node connect3(Node root) {
        Node dummy = new Node();
        Node cur = root;


        while (cur != null){
            dummy.next = null;
            Node nxt = dummy;

            while (cur != null){
                if (cur.left != null){
                    nxt.next = cur.left;
                    nxt = cur.left;
                }

                if (cur.right != null){
                    nxt.next = cur.right;
                    nxt = cur.right;
                }
                cur = cur.next;
            }
            cur = dummy.next;
        }
        return root;
    }

}
