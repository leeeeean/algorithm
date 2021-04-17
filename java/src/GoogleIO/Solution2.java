package GoogleIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution2 {
    static int T;
    static int[] L;
    static int N;
    static int alphaNum;
    static char[] rs ;
    static int[] alpha;
    static boolean is;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        alpha = new int[26];
        for (int i = 0; i < 26; i++) {
            alpha[i] = i+65;
        }

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            L = new int[N+1];
            st = new StringTokenizer(br.readLine());

            alphaNum = 1;
            L[0] = 1;
            for (int j = 1; j < N+1; j++) {
                L[j] = Integer.parseInt(st.nextToken());
                alphaNum += L[j]; // 총 알파벳 갯수
            }
            rs = new char[alphaNum];
            is = false;
            dfs(0);
            System.out.println("Case #"+(i+1)+": "+String.valueOf(rs));
        }
    }
    static void dfs(int idx) {
        if(idx == alphaNum) {
            is = true;
        } else {
            for (int i = 0; i < 26; i++) {
                if (is) return;
                rs[idx] = (char) alpha[i];
                if (check(idx)) {
                    dfs(idx+1);
                }
            }
        }
    }
    static boolean check(int last) {
        int idx = 0;

        for (int i = 0; i < L.length; i++) {
            if (i == 0) {
                if (rs[0] != 'A') return false;
                else {
                    idx += L[i];
                    continue;
                }
            }
            if (i % 2 == 1) { // 홀수, 오름차순, 이전 값보다 커야한다
                for (int j = idx; j < idx+L[i]; j++) {
                    if (j == last+1) return true;
                    if (rs[j-1] >= rs[j]) return false;
                }
            } else { // 짝수, 내림차순, 이전보다 작아야 한다
                for (int j = idx; j < idx+L[i]; j++) {
                    if (j == last+1) return true;
                    if (rs[j-1] <= rs[j]) return false;
                }
            }
            idx += L[i];
        }
        return true;
    }

}



