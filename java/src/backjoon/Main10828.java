package backjoon;
//https://www.acmicpc.net/problem/10828

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main10828 {
    static int N;
    static List<Integer> stack = new ArrayList<>();
    static Command comm;
    static int X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer((br.readLine()));
            if (st.countTokens() == 2) {
                comm = new Command(st.nextToken(), Integer.parseInt(st.nextToken()));
            } else {
                comm = new Command(st.nextToken(), 0);
            }

            switch (comm.cmd) {
                case "push":
                    push(stack, comm);
                    break;
                case "pop":
                    X = pop(stack);
                    System.out.println(X);
                    break;
                case "size":
                    X = size(stack);
                    System.out.println(X);
                    break;
                case "empty":
                    X = isEmpty(stack);
                    System.out.println(X);
                    break;
                case "top":
                    X = top(stack);
                    System.out.println(X);
                    break;
            }
        }
    }

    public static int isEmpty(List<Integer> stack) {
        if (stack.size() == 0) {
            return 1;
        } else {
            return 0;
        }
    }
    public static int size(List<Integer> stack) {
        return stack.size();
    }
    public static int top(List<Integer> stack) {
        if (stack.size() == 0) {
            return -1;
        } else {
            return stack.get(stack.size()-1);
        }
    }
    public static int pop(List<Integer> stack) {
        if (stack.size() == 0) {
            return -1;
        } else {
            int x = stack.get(stack.size() - 1);
            stack.remove(stack.size()-1);
            return x;
        }
    }
    public static void push(List<Integer> stack, Command comm) {
        stack.add(comm.num);
    }
}
class Command {
    String cmd;
    int num;

    public Command(String cmd, int num) {
        this.cmd = cmd;
        this.num = num;
    }
}
