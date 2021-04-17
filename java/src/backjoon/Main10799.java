package backjoon;
// https://www.acmicpc.net/problem/10799

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();

        int rs = 0;
        Stack<Character> stack = new Stack<>();
        boolean isLaser = false;

        for (int c=0; c<chars.length; c++) {
            if (chars[c] == '('){
                if (chars[c+1] == ')') {
                    isLaser = true;
                } else {stack.push('(');}
            } else if (chars[c] == ')') {
                if (isLaser) {
                    rs += stack.size();
                    isLaser = false;
                } else {
                    stack.pop();
                    rs += 1;
                }
            }
        }
        System.out.println(rs);
    }
}

