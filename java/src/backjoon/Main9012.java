package backjoon;
// https://www.acmicpc.net/problem/9012

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main9012 {
    static int T;
    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            char[] chars = br.readLine().toCharArray();
            boolean yesOrNo = true;
            stack.clear();
            for (char c : chars) {
                if (c == '(') {
                    stack.push(c);
                } else {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        yesOrNo = false;
                        break;
                    }
                }
            }
            if (yesOrNo && stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
