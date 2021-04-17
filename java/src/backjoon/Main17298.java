package backjoon;
// https://www.acmicpc.net/problem/17298

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        int[] nge = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) { seq[i] = Integer.parseInt(st.nextToken()); }

        nge[N-1] = -1;
        for (int i = N - 2; i > -1; i--) {
            if (seq[i] < seq[i+1]) { nge[i] = seq[i+1]; }
            else {
                if (seq[i] > nge[i+1]) {
                    for (int j = i+1; j < N; j++) {
                        if (seq[i] < nge[j]) {
                            nge[i] = nge[j];
                            break;
                        }
                    }
                    if (nge[i] == 0) nge[i] = -1;
                } else {
                    nge[i] = nge[i+1];
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
