package GoogleIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//public class Solution {
public class Main1 {
    static int T;
    static int N;
    static int[] animals;
    static int[] treats;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int rs = 0;
            N = Integer.parseInt(br.readLine());
            animals = new int[N];
            treats = new int[N];

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                animals[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(animals);
            rs = calc(animals, treats);
            System.out.println("Case #"+(i+1)+": "+rs);
        }

    }

    static public int calc(int[] animals, int[] treats) {
        int treat = 1;
        treats[0] = treat;
        for (int i = 1; i < animals.length; i++) {
            if (animals[i] == animals[i - 1]) {
                treats[i] = treat;
            } else {
                treat++;
                treats[i] = treat;
            }
        }
        int rs = 0;
        for (int i = 0; i < treats.length; i++) {
            rs += treats[i];
        }
        return rs;
    }
}
