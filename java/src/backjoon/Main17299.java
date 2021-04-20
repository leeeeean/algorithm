package backjoon;
// https://www.acmicpc.net/problem/17299

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Main17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] F = new int[1000001];
        int[] nge = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            F[arr[i]]++;
        }

        Stack<Integer> index = new Stack<>();
        index.push(0);

        for (int i = 1; i < N; i++) {
            if (F[arr[index.peek()]] >= F[arr[i]]) {
                index.push(i);
            } else {
                while(true){
                    if (index.isEmpty() || F[arr[index.peek()]] >= F[arr[i]]) {
                        index.push(i);
                        break;
                    }
                    nge[index.pop()] = arr[i];
                }
            }
        }
        while (!index.isEmpty()) {
            nge[index.pop()] = -1;
        }
        StringJoiner sj = new StringJoiner(" ");
        for (int i : nge) {
            sj.add(Integer.toString(i));
        }
        System.out.println(sj);
    }
}
