package backjoon;
// https://www.acmicpc.net/problem/1158

import java.util.*;

public class Main1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        List<Integer> rs = new ArrayList<>();

        int pointer = 0;
        int size;
        List<Integer> circle = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            circle.add(i+1);
        }
        for (int i = 0; i < N; i++) {
            size = circle.size();
            int X = pointer+K-1;
            if (X > size-1) {
                X = X%size;
            }
            rs.add(circle.get(X));
            circle.remove(X);
            pointer = X;
        }
        char[] chars = rs.toString().toCharArray();
        char[] chars2 = Arrays.copyOfRange(chars, 1, chars.length-1);
        System.out.println("<"+String.valueOf(chars2)+">");
    }
}
