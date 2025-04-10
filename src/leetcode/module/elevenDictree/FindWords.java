package leetcode.module.elevenDictree;

import java.util.ArrayList;
import java.util.List;

public class FindWords {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for (String word : words){
            TrieNode node = root;
            for (char c : word.toCharArray()){
                int index = c - 'a';
                if (node.children[index] == null){
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = word;
        }
        return root;

    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> result = new ArrayList<>();
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node,List<String> result){
        int x = board.length;
        int y = board[0].length;
        if (i < 0 || i >= x || j < 0 || j >= y || board[i][j] == '#' || node.children[board[i][j] - 'a'] == null ){
            return;
        }
        //    if (i < 0 || i >= x || j < 0 || j >= y || node.children[board[i][j] - 'a'] == null || board[i][j] == '#' )是错的
        //
        //易错点假设 board[i][j] 在某次 DFS 中变成 '#'：
        //	1.	进入 dfs(i, j, node, result)
        //	2.	访问 board[i][j]，但此时 board[i][j] == '#'
        //	3.	计算 board[i][j] - 'a'（这里 '#' 不是 a-z 的字符，会导致数组访问越界❌）

        char c = board[i][j];



        node = node.children[board[i][j] - 'a'];
        if (node.word != null){
            result.add(node.word);
            node.word = null;
        }
        board[i][j] = '#';

        dfs(board, i + 1, j, node, result);
        dfs(board, i - 1, j, node, result);
        dfs(board, i , j - 1, node, result);
        dfs(board, i , j + 1, node, result);

        board[i][j] = c;

    }



}
