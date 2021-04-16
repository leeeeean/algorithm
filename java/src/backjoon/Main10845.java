package backjoon;
// https://www.acmicpc.net/problem/10845

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main10845 {
    static int N;
    // stack의 ArrayList와 달리 LinkedList를 사용한다는 점 !
    static List<Integer> queue = new LinkedList<>();
    static Command2 comm;
    static int X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer((br.readLine()));
            if (st.countTokens() == 2) {
                comm = new Command2(st.nextToken(), Integer.parseInt(st.nextToken()));
            } else {
                comm = new Command2(st.nextToken(), 0);
            }

            switch (comm.cmd) {
                case "push":
                    push(queue, comm);
                    break;
                case "pop":
                    X = pop(queue);
                    System.out.println(X);
                    break;
                case "size":
                    X = size(queue);
                    System.out.println(X);
                    break;
                case "empty":
                    X = isEmpty(queue);
                    System.out.println(X);
                    break;
                case "front":
                    X = front(queue);
                    System.out.println(X);
                    break;
                case "back":
                    X = back(queue);
                    System.out.println(X);
                    break;
            }
        }
    }

    public static int isEmpty(List<Integer> queue) {
        if (queue.size() == 0) {
            return 1;
        } else {
            return 0;
        }
    }
    public static int size(List<Integer> queue) {
        return queue.size();
    }
    public static int pop(List<Integer> queue) {
        if (queue.size() == 0) {
            return -1;
        } else {
            int x = queue.get(0);
            queue.remove(0);
            return x;
        }
    }
    public static int front(List<Integer> queue) {
        if (queue.size() == 0) {
            return -1;
        } else {
            return queue.get(0);
        }
    }
    public static int back(List<Integer> queue) {
        if (queue.size() == 0) {
            return -1;
        } else {
            return queue.get(queue.size()-1);
        }
    }
    public static void push(List<Integer> queue, Command2 comm) {
        queue.add(comm.num);
    }
}
class Command2 {
    String cmd;
    int num;

    public Command2(String cmd, int num) {
        this.cmd = cmd;
        this.num = num;
    }
}