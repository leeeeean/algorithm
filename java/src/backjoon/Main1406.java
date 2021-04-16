package backjoon;
// https://www.acmicpc.net/problem/1406

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        char[] chars = br.readLine().toCharArray();
        List<Character> list = new LinkedList<>();
        for (char c :chars) {
            list.add(c);
        }
        int pointer = list.size(); // 0~list.size()

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            if (st.countTokens() == 1) {
                char c = st.nextToken().charAt(0);
                switch (c) {
                    case 'L':
                        pointer -= 1;
                        if (pointer<0) pointer = 0;
                        break;
                    case 'D':
                        pointer += 1;
                        if (pointer>list.size()) pointer = list.size();
                        break;
                    case 'B':
                        if (pointer > 0) {
                            pointer -= 1;
                            list.remove(pointer);
                        }
                        break;
                }
            } else  {
                st.nextToken();
                list.add(pointer, st.nextToken().charAt(0));
                pointer += 1;
            }
        }
        String result = list.parallelStream()
                        .map(n -> Character.toString(n))
                        .collect(Collectors.joining());
        System.out.println(result);

    }
}
// ArryaList 말고 LinkedList 사용하기!
