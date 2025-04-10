package leetcode.module.tenGragh;

import java.util.*;

public class CanFinish {


    //方法一：广度优先遍历，利用拓扑排序，
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] intdegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++){
            adjacency.add(new ArrayList<>());
        }

        for (int[] cp : prerequisites){
            intdegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }

        for (int i = 0; i < numCourses; i++){
            if (intdegrees[i]==0){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            int pre = queue.poll();
            numCourses--;
            for (int cur : adjacency.get(pre)){
                if (--intdegrees[cur] == 0) queue.add(cur);
            }
        }
        return numCourses == 0;


    }


    //方法2：深度优先遍历，判断是否有环
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<List<Integer>> ajacency = new ArrayList<>();

        for (int i = 0; i < numCourses; i++){
            ajacency.add(new ArrayList<>());
        }

        int[] flags = new int[numCourses];
        for (int[] cp : prerequisites){
            ajacency.get(cp[1]).add(cp[0]);
        }

        for (int i = 0; i < numCourses; i++){
            if (!dfs(ajacency, flags, i)) return false;
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> ajacency, int[] flags, int i){
        if (flags[i] == 1) return false;
        if (flags[i] == -1) return true;

        flags[i] = 1;
        for (Integer j : ajacency.get(i)){
            if (!dfs(ajacency, flags, j)) return false;
        }
        flags[i] = -1;
        return true;
    }



    public static void main(String[] args) {
        CanFinish solution = new CanFinish();
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        solution.canFinish(numCourses,prerequisites );
    }

}
