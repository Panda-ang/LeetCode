package leetcode.module.bitoperation;

public class ReverseBits {
    public int reverseBits(int n) {
        int result = 0;  // 初始化结果变量，用来存储反转后的二进制值

        // 我们需要反转 32 位二进制，所以循环 32 次
        for (int i = 0; i < 32; i++) {
            result = result << 1;  // 将结果左移 1 位，为下一位腾出空间
            result |= (n & 1);     // 将 n 的最低位（n & 1）加到 result 的最低位, 这里按位进行 “或”操作
            n >>= 1;               // 将 n 右移 1 位，处理下一位
        }

        return result;  // 返回反转后的结果
    }
}
