package backjoon;
// https://www.acmicpc.net/problem/1874

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] nums = new int[T];
        List<String> stackCalc = new ArrayList<>(); // 연산 저장 배열

        // 수열을 배열에다
        for (int i = 0; i < T; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        int lastPush = 0;  // 마지막으로 Psuh 한 값
        boolean state = true;
        for (int i = 0; i < T; i++) {
            if (lastPush < nums[i]) {
                for (int j = lastPush+1; j <= nums[i] ; j++) {
                    stack.push(j);
                    stackCalc.add("+");
                }
                stack.pop();
                stackCalc.add("-");
                lastPush = nums[i];
            } else {
                if (stack.peek() == nums[i]) {
                    stack.pop();
                    stackCalc.add("-");
                } else {
                    state = false;
                }
            }
        }
        String result = String.join("\n", stackCalc.toArray(new String[0]));
        if (state) {
            System.out.println(result);
        } else {
            System.out.println("NO");
        }
    }
}
