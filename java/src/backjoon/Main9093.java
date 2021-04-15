package backjoon;
// https://www.acmicpc.net/problem/9093

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main9093 {
    static int T;
    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                char[] chars = st.nextToken().toCharArray();
                char[] chars2 = new char[chars.length];
                for (int j = chars.length-1, o = 0; j >-1; j--, o++) {
                    chars2[o] = chars[j];
                }
                System.out.print(String.valueOf(chars2)+" ");
            }
            System.out.println();
        }

//        System.out.print()를 각 char 마다 부르면 시간초과가 발생했다.. ㅠ
//        그래서 메모리를 더 사용해서 각 단어마다 같은 크기 배열을 만들어서 단어의 reverse를 넣어줬다.
//        그리고 한번에 출력했더니 간신이 시간안에 들어갔다...

//        다른 방법
//        StringBuffer s = new StringBuffer(charArray);
//        s.reverse();

//        실패 1
//        for (int i = 0; i < T; i++) {
//            st = new StringTokenizer(br.readLine());
//            while (st.hasMoreTokens()) {
//                for (char c : st.nextToken().toCharArray()) {
//                    stack.push(c);
//                }
//                while(!stack.isEmpty()){
//                    char c = stack.pop();
//                    System.out.print(c);
//                }
//                System.out.print(" ");
//            }
//            System.out.println();
//        }
//        실패 2
//        for (int i = 0; i < T; i++) {
//            char[] cArray = br.readLine().toCharArray();
//            for (char c : cArray) {
//                if (c != ' ') {
//                    stack.push(c);
//                } else {
//                    while(!stack.isEmpty()){
//                        System.out.print(stack.pop());
//                    }
//                    System.out.print(' ');
//                }
//            }
//            while(!stack.isEmpty()){
//                System.out.print(stack.pop());
//            }
//            System.out.println();
//        }
//        실패 3
//        for (int i = 0; i < T; i++) {
//            char[] cArray = br.readLine().toCharArray();
//            for (char c : cArray) {
//                if (c != ' ') {
//                    stack.push(c);
//                } else {
//                    while(stack.size()!=0){
//                        System.out.print(stack.pop());
//                    }
//                    System.out.print(' ');
//                }
//            }
//            while(stack.size()!=0){
//                System.out.print(stack.pop());
//            }
//            System.out.println();
//        }
//        실패 4
//        for (int i = 0; i < T; i++) {
//            st = new StringTokenizer(br.readLine());
//            while (st.hasMoreTokens()) {
//                char[] chars = st.nextToken().toCharArray();
//                for (int j = chars.length-1; j >-1; j--) {
//                    System.out.print(chars[j]);
//                }
//                System.out.print(" ");
//            }
//            System.out.println();
//        }

    }
}
