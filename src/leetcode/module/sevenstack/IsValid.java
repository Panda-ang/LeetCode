package leetcode.module.sevenstack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class IsValid {
    public static void main(String[] args) {

    }
    public static boolean isValid(String s) {

        if(s.length() % 2 != 0){
            return false;
        }

        Map<Character, Character> mp = new HashMap<>(){{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};
        Deque<Character> st = new ArrayDeque<>();

        for(char c : s.toCharArray()){
            if(!mp.containsKey(c)){
                st.push(c);
            }else if(st.isEmpty() || st.pop() != mp.get(c)){
                return false;
            }
        }

        return st.isEmpty();
    }
}
