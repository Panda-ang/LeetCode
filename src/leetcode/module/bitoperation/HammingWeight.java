package leetcode.module.bitoperation;

public class HammingWeight {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        HammingWeight solution = new HammingWeight();
        solution.hammingWeight(11);
    }
}
