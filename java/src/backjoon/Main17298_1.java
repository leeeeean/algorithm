package backjoon;
// stack 사용 1
// 1072ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Main17298_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] nge = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = N - 1; i > -1; i--) {
            if (stack.isEmpty()) {
                nge[i] = -1;
                stack.push(arr[i]);
            } else {
                if (stack.peek() > arr[i]) {
                    nge[i] = stack.peek();
                    stack.push(arr[i]);
                } else {
                    while(true){
                        if (stack.isEmpty()) {
                            nge[i] = -1;
                            stack.push(arr[i]);
                            break;
                        }
                        if (stack.peek() > arr[i]) {
                            nge[i] = stack.peek();
                            stack.push(arr[i]);
                            break;
                        } else {
                            stack.pop();
                        }

                    }
                }
            }
        }
        StringJoiner sj = new StringJoiner(" ");
        for (int i : nge) {
            sj.add(Integer.toString(i));
        }
        System.out.println(sj);
    }
}
