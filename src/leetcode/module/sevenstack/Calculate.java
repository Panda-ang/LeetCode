package leetcode.module.sevenstack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculate {
    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate(s));

    }

    public static int calculate(String s) {
        Deque<Integer> ops = new ArrayDeque<>();
        int sign = 1;
        ops.push(sign);

        int n = s.length();
        int ans = 0;
        int i = 0;

        while(i < n){
            if(s.charAt(i) == ' ' ){
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            }else {
                int num = 0;
                while (i < n && Character.isDigit(s.charAt(i))){
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ans += sign * num;
            }
        }
        return ans;
    }
}
