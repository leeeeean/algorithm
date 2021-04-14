package sds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3055 {
    static int[] x = {0,0,1,-1};
    static int[] y = {1,-1,0,0};
    static Queue<Point> queue = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        int R, C;
        char[][] map;
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        boolean[][] isChecked = new boolean[R][C];
        int[][] dp = new int[R][C];
        Point start = null;
        for (int i = 0; i < R; i++) {
            char[] s = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = s[j];
                if (s[j] == '*')
                    queue.add(new Point(i, j, '*'));
                else if (s[j] == 'S')
                    start = new Point(i, j, 'S');
            }
        }

        queue.add(start); // 물 이후 고슴도치 위치 삽입
//        1. 큐에서 꺼내옴 (내가 방문할 무언가가 있는가? 다음 방문할 곳이 나온다)
//        2. 목적지에 도달했는가? stop
//        3. 연결된 곳을 순회
//        4. 	갈수 있는가?
//        5. 		체크인 & 큐에 넣음
        Point p;
        boolean answer = false;
        while(!queue.isEmpty()){
            p = queue.poll();
            if (p.type == 'D') {
                System.out.println(dp[p.x][p.y]);
                answer = true;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int x_ = p.x+x[i];
                int y_ = p.y+y[i];
                if (x_>=0 && x_<R && y_>=0 && y_<C) {
                    if (p.type == '.' || p.type == 'S') {
                        if (dp[x_][y_] == 0 && (map[x_][y_] == '.' || map[x_][y_] == 'D')){
                            dp[x_][y_] = dp[p.x][p.y]+1;
                            queue.add(new Point(x_, y_, map[x_][y_]));
                        }
                    } else {
                        if (map[x_][y_] == '.' || map[x_][y_] == 'S'){
                            map[x_][y_] = '*';
                            queue.add(new Point(x_, y_, map[x_][y_]));
                        }
                    }
                }

            }
        }
        if (!answer) System.out.println("KAKTUS");
    }

//    System.out.println(Arrays.deepToString(map));
    static void map2string(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
    static void map2string(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
}

class Point {
    int x,y;
    char type;
    public Point (int x, int y, char type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
}


/*
bfs

빈곳 .
물 * - 고슴도치 못감
돌 X - 아무도 못감
비버 D - 물이 못감
고슴도치 S - 물로 못감, 물이 찰 곳으로 못감

비버굴로 가면 시간
비버굴로 못가면 KAKTUS

** 물이 먼저 움직이고 그다음에 비버가 움직이자!!

 */