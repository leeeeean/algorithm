package programmers;
// https://programmers.co.kr/learn/courses/30/lessons/60058

import java.util.Stack;

public class Solution60058 {
    public static void main(String[] args) {
        String[] strs = {"(()())()", ")(", "()))((()"};
        for (String s : strs) {
            System.out.println(solution(s));
        }
    }

    public static String solution(String p) {
        return proccess(p);
    }

    public static String proccess(String s){
        if (s.length() == 0) {
            return "";
        }
        if (isCorrect(s)) return s;

        char[] chars = s.toCharArray();
        int leftB=0, rightB=0;
        for (char c : chars) {
            if (c == '(') { leftB++; }
            else { rightB++; }
            if (rightB == leftB) {
                break;
            }
        }

        String u = s.substring(0, leftB + rightB);
        String v = s.substring(leftB + rightB);
        if (isCorrect(u)) {
            return u + proccess(v);
        } else {
            StringBuilder sb = new StringBuilder("(");
            sb.append(proccess(v));
            sb.append(")");
            for (int i = 1; i < leftB+rightB-1; i++) {
                if (chars[i] == '(') sb.append(")");
                else sb.append("(");
            }
            return sb.toString();
        }
    }

    public static boolean isCorrect(String s) {
        if (s.length() == 0) {
            return true;
        }

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else stack.pop();

            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}

