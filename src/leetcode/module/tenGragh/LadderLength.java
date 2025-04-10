package leetcode.module.tenGragh;

import java.util.*;

public class LadderLength {


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        // 双向 BFS
        Queue<String> queueBegin = new LinkedList<>();
        Queue<String> queueEnd = new LinkedList<>();
        Set<String> visitedBegin = new HashSet<>();
        Set<String> visitedEnd = new HashSet<>();

        queueBegin.offer(beginWord);
        queueEnd.offer(endWord);
        visitedBegin.add(beginWord);
        visitedEnd.add(endWord);

        int count = 1;  // 步数

        // BFS 双向扩展
        while (!queueBegin.isEmpty() && !queueEnd.isEmpty()) {
            // 每次从较小的队列开始进行 BFS 扩展
            if (queueBegin.size() <= queueEnd.size()) {
                if (bfs(queueBegin, visitedBegin, visitedEnd, wordSet)) {
                    return count;  // 搜索成功，返回当前步数
                }
            } else {
                if (bfs(queueEnd, visitedEnd, visitedBegin, wordSet)) {
                    return count;  // 搜索成功，返回当前步数
                }
            }
            count++;  // 增加步数
        }
        return 0;  // 无法找到路径
    }

    // 单向 BFS 扩展
    private boolean bfs(Queue<String> queue, Set<String> visited, Set<String> otherVisited, Set<String> wordSet) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            String word = queue.poll();
            char[] wordArray = word.toCharArray();
            for (int j = 0; j < wordArray.length; j++) {
                char originalChar = wordArray[j];
                for (char c = 'a'; c <= 'z'; c++) {
                    wordArray[j] = c;
                    String newWord = new String(wordArray);
                    // 如果新单词在字典中，且未访问过，且新单词在对方队列中存在
                    if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                        // 如果新单词已经在对方队列中，表示找到了路径
                        if (otherVisited.contains(newWord)) {
                            return true;
                        }
                        queue.offer(newWord);
                        visited.add(newWord);
                    }
                }
                wordArray[j] = originalChar;  // 恢复字符
            }
        }
        return false;  // 没有找到路径
    }

    public static void main(String[] args) {
        LadderLength ladderLength = new LadderLength();
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(ladderLength.ladderLength("hit", "cog", wordList));  // 输出 5
    }
}

//public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//
//        // 用 Set 存储单词库，方便快速查找
//        Set<String> wordSet  = new HashSet<>(wordList);
//        if(!wordSet.contains(endWord)) return 0;
//        Queue<String> queue = new LinkedList<>();
//        queue.offer(beginWord);
//
//        Set<String> visited = new HashSet<>();
//        visited.add(beginWord);
//
//        int count = 0;
//
//        while (!queue.isEmpty()){
//            int size = queue.size();
//            for (int i = 0; i < size; i++){
//                String curWord = queue.poll();
//                if (curWord.equals(endWord)) return count;
//                char[] curWordArray = curWord.toCharArray();
//                for (int j = 0; j < curWordArray.length; j++){
//                    char originalWord = curWordArray[j];
//                    for (char c = 'a'; c <= 'z'; c++){
//                        if (originalWord == c) continue;
//                        curWordArray[j] = c;
//                        String nextWord = new String(curWordArray);
//                        if (wordSet.contains(nextWord) && !visited.contains(nextWord)){
//                            queue.add(nextWord);
//                            visited.add(nextWord);
//                        }
//                    }
//                    curWordArray[j] = originalWord;
//                }
//            }
//            count++;
//        }
//        return 0;
//    }
//}
