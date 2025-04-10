package leetcode.module.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMaximizedCapital {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++){
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }

        Arrays.sort(projects, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> maxProfit = new PriorityQueue<>(Comparator.reverseOrder());

        int currentCapital = w;
        int projectIndex = 0;

        for (int i = 0; i < k; i++){
            while (projectIndex < n && projects[projectIndex][0]  <= currentCapital){
                maxProfit.add(projects[projectIndex][1]);
                projectIndex++;
            }

            if (maxProfit.isEmpty()){
                break;
            }

            currentCapital +=  maxProfit.poll();
        }

        return currentCapital;
    }
}
