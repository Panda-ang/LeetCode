package leetcode.module.math;

import java.util.HashMap;
import java.util.Map;

public class MaxPoints {
    public int maxPoints(int[][] points) {
        int n = points.length;

        if (n <= 2){
            return n;
        }

        int max = 0;

        for (int i = 0; i < n; i++){
            Map<String, Integer> slopeMap = new HashMap<>();
            int samePoint = 1; // 重复点的个数
            int localMax = 0;

            for (int j = i + 1; j < n; j++){
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];

                if (dx == 0 && dy == 0){
                    samePoint++;
                    continue;
                }

                if (dx < 0){
                    dx = -dx;
                    dy = -dy;
                }

                int gcd = gcd(dx, dy);
                dx = dx / gcd;
                dy = dy / gcd;

                String slop = dx + "/" + dy;
                slopeMap.put(slop, slopeMap.getOrDefault(slop, 0) + 1);
                localMax = Math.max(localMax,slopeMap.get(slop));
            }

            max = Math.max(max, localMax + samePoint);

        }
        return max;
    }

    private int gcd(int a, int b){
        return b == 0 ? a : gcd(b , a % b);
    }
}
