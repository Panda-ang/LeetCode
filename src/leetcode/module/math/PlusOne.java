package leetcode.module.math;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // 从数组的最后一位开始加一
        for (int i = n - 1; i >= 0; i--) {
            // 如果当前位加一后小于 10，直接返回
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // 如果当前位加一后等于 10，当前位置为 0，继续进位
            digits[i] = 0;
        }

        // 如果所有位都是 9，数组变为全 0，需要在最前面插入 1
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }
}
