package sds;

import java.util.Scanner;

public class Main1062 {
    static boolean[] isChecked = new boolean[26];
    static int N, K;
    static String[] words;
    static int max=0;
    static int charNum = 5;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = sc.next();
        }
        isChecked['a'-'a'] = true;
        isChecked['n'-'a'] = true;
        isChecked['t'-'a'] = true;
        isChecked['i'-'a'] = true;
        isChecked['c'-'a'] = true;

        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 5) {
            System.out.println(wordCheck());
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        } else {
            for (int i = 0; i < 26; i++) {
                if (!isChecked[i]) dfs(i);
            }
        }
        System.out.println(max);

    }
    static int wordCheck() {
        int num =0;
        for (String word: words) {
            boolean check = true;
            for (char c : word.toCharArray()) {
                if (!isChecked[c-'a']) {
                    check = false;
                    break;
                }
            }
            if (check) num++;
        }
        return num;
    }
    static void dfs (int idx) {
        //  DFS 의 순서
        //  1. 체크인
        isChecked[idx] = true;
        charNum++;
        // 2. 목적지에 도착했는가?
        if (charNum == K) max = Math.max(max, wordCheck());
        // 3. 연결된 곳을 순회
        else {
            for (int i = idx+1; i < 26; i++) {
                // 4. 갈수 있는가?
                if (!isChecked[i])
                    // 5. 간다
                    dfs(i);
            }
        }
        // 6. 체크 아웃
        isChecked[idx] = false;
        charNum--;
    }
}
