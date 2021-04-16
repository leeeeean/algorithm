package backjoon;
// https://www.acmicpc.net/problem/10866

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main10866 {
    static int N;
    static List<Integer> deque = new LinkedList<>();
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
                case "push_front":
                    push_front(deque, comm);
                    break;
                case "push_back":
                    push_back(deque, comm);
                    break;
                case "pop_front":
                    X = pop_front(deque);
                    System.out.println(X);
                    break;
                case "pop_back":
                    X = pop_back(deque);
                    System.out.println(X);
                    break;
                case "size":
                    X = size(deque);
                    System.out.println(X);
                    break;
                case "empty":
                    X = isEmpty(deque);
                    System.out.println(X);
                    break;
                case "front":
                    X = front(deque);
                    System.out.println(X);
                    break;
                case "back":
                    X = back(deque);
                    System.out.println(X);
                    break;
            }
        }
    }

    public static int isEmpty(List<Integer> deque) {
        if (deque.size() == 0) {
            return 1;
        } else {
            return 0;
        }
    }
    public static int size(List<Integer> deque) {
        return deque.size();
    }
    public static int front(List<Integer> deque) {
        if (deque.size() == 0) {
            return -1;
        } else {
            return deque.get(0);
        }
    }
    public static int back(List<Integer> deque) {
        if (deque.size() == 0) {
            return -1;
        } else {
            return deque.get(deque.size()-1);
        }
    }
    public static int pop_front(List<Integer> deque) {
        if (deque.size() == 0) {
            return -1;
        } else {
            int x = deque.get(0);
            deque.remove(0);
            return x;
        }
    }
    public static int pop_back(List<Integer> deque) {
        if (deque.size() == 0) {
            return -1;
        } else {
            int x = deque.get(deque.size() - 1);
            deque.remove(deque.size()-1);
            return x;
        }
    }
    public static void push_front(List<Integer> deque, Command comm) {
        deque.add(0, comm.num);
    }
    public static void push_back(List<Integer> deque, Command comm) {
        deque.add(comm.num);
    }
}
//class Command {
//    String cmd;
//    int num;
//
//    public Command(String cmd, int num) {
//        this.cmd = cmd;
//        this.num = num;
//    }
//}
//