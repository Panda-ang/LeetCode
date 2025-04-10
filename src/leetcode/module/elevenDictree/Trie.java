package leetcode.module.elevenDictree;

//https://www.bilibili.com/video/BV1UL411873k/?spm_id_from=333.337.search-card.all.click&vd_source=02eff3861fbae92e5089ad13f3b33f20
public class Trie {

    // Trie 树的节点定义
    private class TrieNode {
        // 子节点数组，每个字母占一个位置
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false; // 标志是否是一个单词的结尾
    }

    private TrieNode root; // 根节点

    public Trie() {
        root = new TrieNode(); // 初始化根节点
    }

    private void insert(String word){
        TrieNode node = root;
        for (char c : word.toCharArray()){
            int idx = c - 'a';
            if (node.children[idx] == null){
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
    }

    private boolean search(String word){
        TrieNode node = findNode(word);
        return node != null && node.isEnd;
    }

    private boolean startsWith(String word){
        return findNode(word)!=null;
    }

    private TrieNode findNode(String prefix){
        TrieNode node = root;
        for (char c : prefix.toCharArray()){
            int index = c - 'a';
            if (node.children[index] == null){
                return null;
            }
            node = node.children[index];
        }
        return node;

    }
}
