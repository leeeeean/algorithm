package GoogleIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution4 {
    static char[] chars;
    static int T;
    static int front, back, score;
    static char turn, win;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            chars = br.readLine().toCharArray();
            // true : I, false : O
            turn = 'I';
            score = 0;
            game(turn, 0, chars.length-1);
            System.out.println("Case #"+(i+1)+": "+win+" "+(score+1));
        }
    }

    static void game(char turn, int front, int back) {
        if(front > back) {
            if (turn == 'I') {
                if (score < 1) {
                    score = 0;
                    win = 'O';
                }
            } else {
                if (score < 1) {
                    score = 0;
                    win = 'I';
                }
            }
            return;
        }
        if (turn == 'I' && chars[front] == 'O' && chars[back] == 'O') {
            int x = back-front+1;
            if (score < x){
                score = x;
                win = 'O';
            }
        }
        if (turn == 'O' && chars[front] == 'I' && chars[back] == 'I') {
            int x = back-front+1;
            if (score < x){
                score = x;
                win = 'I';
            }
        }
        if (turn == 'I'){
            if (chars[front] == 'I') game('O', front+1, back);
            if (chars[back] == 'I') game('O', front, back-1);
        } else {
            if (chars[front] == 'O') game('I', front+1, back);
            if (chars[back] == 'O') game('I', front, back-1);
        }

    }
}
