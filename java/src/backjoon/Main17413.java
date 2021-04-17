package backjoon;
// https://www.acmicpc.net/problem/17413

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main17413 {
    static Stack<Character> stack = new Stack<>();
    static Stack<Character> word = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        List<Character> result = new ArrayList<>();

        for (char c : chars) {
            if (c == '<') {
                stack.push(c);
                if (!word.isEmpty()){
                    while (!word.isEmpty()){
                        result.add(word.pop());
                    }
                }
                result.add(c);
            } else {
                if (!stack.isEmpty()) {
                    if (c == '>') {stack.pop();}
                    result.add(c);
                } else {
                    if (c == ' ') {
                        while (!word.isEmpty()){
                            result.add(word.pop());
                        }
                        result.add(c);
                    } else {
                        word.push(c);
                    }
                }
            }
        }
        if (!word.isEmpty()) {
            while (!word.isEmpty()){
                result.add(word.pop());
            }
        }
        System.out.println(result.stream().map(Objects::toString).collect(Collectors.joining()));
    }
}
