package leetcode.module.sevenstack;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/user/Documents/../Pictures"));
    }

    public static String simplifyPath(String path) {
        Deque<String> stk = new ArrayDeque<>();
        String[] parts = path.split("/");

        for (String part : parts){
            if (part.isEmpty() || part.equals(".")){
                continue;
            }

            if(part.equals("..")){
                stk.pollLast();
            }else {
                stk.offer(part);
            }
        }
        return "/" + String.join("/", stk);
    }

}
