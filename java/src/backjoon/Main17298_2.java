package backjoon;
// stack 사용 2
// 시간 덜 걸림... 980ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Main17298_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] nge = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> index = new Stack<>();
        index.push(0);

        for (int i = 1; i < N; i++) {
            if (arr[index.peek()] >= arr[i]) {
                index.push(i);
            } else {
                while(true){
                    if (index.isEmpty() || arr[index.peek()] >= arr[i]) {
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
