package leetcode.module.tenGragh;

import java.util.*;

public class MinMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        // 用 Set 存储基因库，方便快速查找
        Set<String> bankSet  = new HashSet<>(List.of(bank));

        // 如果目标基因不在基因库中，直接返回 -1
        if (!bankSet.contains(endGene)) {
            return -1;
        }

        char[] genes = new char[]{'A', 'T', 'G', 'C'};

        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        // 记录访问过的基因序列，避免重复访问
        Set<String> visited = new HashSet<>();
        visited.add(startGene);

        int steps = 0;
        while (!queue.isEmpty()){
            int size = queue.size(); // 当前层的大小
            for (int i = 0; i < size; i++){
                String currGene = queue.poll();
                if (currGene.equals(endGene) ) return steps;
               char[] currGeneArray = currGene.toCharArray();
               for (int j = 0; j < currGeneArray.length; j++){
                   char originalChar = currGeneArray[j];
                   for (char gene : genes){
                       if (originalChar == gene) continue;;
                       currGeneArray[j] = gene;
                       String nextGene = new String(currGeneArray);
                       if (bankSet.contains(nextGene) && !visited.contains(nextGene)){
                           queue.offer(nextGene);
                           visited.add(nextGene);
                       }
                   }
                   currGeneArray[j] = originalChar;
               }
            }
            steps++;
        }
        return -1;
    }
}
