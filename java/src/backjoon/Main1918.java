package backjoon;
// https://www.acmicpc.net/problem/1918

import java.util.Scanner;
import java.util.Stack;

public class Main1918 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] str = sc.next().toCharArray();

        Stack<String> chars = new Stack<>();
        Stack<Character> op = new Stack<>();
        StringBuilder sb;

        for (char c : str) {
            if (c == '+' || c == '-' || c == '(' || c == ')' || c == '*' || c == '/') {
                if (op.isEmpty()) {
                    op.push(c);
                } else {
                    if (c == ')') {
                        while(true) {
                            if (op.peek() == '(') {
                                op.pop();
                                break;
                            }
                            sb = new StringBuilder();
                            sb.append(chars.pop());
                            sb.insert(0, chars.pop());
                            sb.append(op.pop());
                            chars.push(sb.toString());
                        }
                    } else {
                        if (prior(c) > prior(op.peek()) || op.peek() == '(') {
                            op.push(c);
                        } else {
                            while(true){
                                if (op.isEmpty() || prior(c) > prior(op.peek()) || op.peek() == '(') {
                                    op.push(c);
                                    break;
                                }
                                sb = new StringBuilder();
                                sb.append(chars.pop());
                                sb.insert(0, chars.pop());
                                sb.append(op.pop());
                                chars.push(sb.toString());
                            }
                        }
                    }
                }
            } else {
                chars.push(Character.toString(c));
            }
//            System.out.println("chars : "+chars);
//            System.out.println("op : "+op);
        }
        while (!op.isEmpty()) {
            sb = new StringBuilder();
            sb.append(chars.pop());
            sb.insert(0, chars.pop());
            sb.append(op.pop());
            chars.push(sb.toString());
        }
        System.out.println(chars.pop());
    }
    public static int prior(char c) {
        int rs = 0;
        switch (c) {
            case '+': rs = 0;
                break;
            case '-': rs = 0;
                break;
            case '*': rs = 1;
                break;
            case '/': rs = 1;
                break;
            case '(': rs = 2;
                break;
        }
        return rs;
    }
}
