package backjoon;
// https://www.acmicpc.net/problem/1935

import java.util.Scanner;
import java.util.Stack;

public class Main1935 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 'A';

        int N = sc.nextInt();
        char[] str = sc.next().toCharArray();
        double[] nums = new double[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextDouble();
        }

        Stack<Double> stack = new Stack<>();
        double suf;
        double pre;
        double rs =0;
        for (char c : str) {
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                suf = stack.pop();
                pre = stack.pop();
                switch (c) {
                    case '+': rs = pre + suf;
                        break;
                    case '-': rs = pre - suf;
                        break;
                    case '*': rs = pre * suf;
                        break;
                    case '/': rs = pre / suf;
                        break;
                }
                stack.push(rs);
            } else {
                stack.push((double) nums[c-a]);
            }
        }
        rs = stack.pop();
        System.out.printf("%.2f%n",rs);
    }
}
