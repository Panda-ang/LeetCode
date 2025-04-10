package leetcode.module.tenGragh;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int target = n * n;

        int[] flattedBoard = new int[n * n + 1];
        boolean leftToRight = true;
        int index = 1;

        //将棋盘位置映射到一维数组编号,1 - 36
        for (int i = n - 1; i >=0; i--){
            if (leftToRight){
                for (int j = 0; j < n; j ++){
                    flattedBoard[index] = board[i][j];
                    index++;
                }
            }else {
                for (int j = n - 1; j >= 0; j--){
                    flattedBoard[index] = board[i][j];
                    index++;
                }
            }
            leftToRight = !leftToRight;
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[target + 1];
        queue.offer(new int[]{1 , 0});

        visited[1] = true;

        //bfs;
        while (!queue.isEmpty()){
            int[] cell = queue.poll();
            int position = cell[0];
            int steps = cell[1];

            //1-6
            for (int move = 1; move <= 6; move++){
                int nextPos = position + move;

                //如果 next > target，说明更大的 i 也一定超过 target，所以 break 可以减少不必要的计算。
                if (nextPos > target) break;

                if (flattedBoard[nextPos] != -1){
                    nextPos = flattedBoard[nextPos];
                }

                if (nextPos == target) return steps + 1;

                if (!visited[nextPos]){
                    visited[nextPos] = true;
                    queue.offer(new int[]{nextPos, steps + 1});
                }
            }
        }
        return -1;

    }

}
