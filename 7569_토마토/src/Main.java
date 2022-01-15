/*
1. 아이디어
- 3중 for문을 돌면서 익은 토마토 큐에 넣고 동시에 BFS 돌리기
- BFS를 실행하면서 거리++
- 3중 for문 마지막으로 돌면서 다 안익었으면 -1, 다 익었으면 최댓값 출력

2. 시간복잡도
V: 10^6
E: 4*V
O(V+E) = O(5V) = O(5*10^6) < 1초

3. 자료구조
방문 기록 : bool[][][] visited
지도 : int[][][] map
큐(BFS) - Point

*/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, H, max;
    static int[][][] map;
    static Queue<Point> q = new LinkedList<>();
    static boolean[][][] visited;

    static int[] dh = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine()," ");
                for (int m = 0; m < M; m++) {
                    map[h][n][m] = Integer.parseInt(st.nextToken());
                }
            }
        }

        BFS();

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (max < map[h][n][m]) {
                        max = map[h][n][m];
                    }
                    if (map[h][n][m] == 0) {
                        System.out.println("-1" + " ");
                        return;
                    }
                }
            }
        }

        bw.write((max-1) + " ");

        bw.close();
    }

    static void BFS() {
        visited = new boolean[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (map[h][n][m] == 1) {
                        q.add(new Point(h, n, m));
                        visited[h][n][m] = true;
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            Point curr = q.poll();

            for (int k = 0; k < 6; k++) {
                int n_h = curr.h + dh[k];
                int n_x = curr.x + dx[k];
                int n_y = curr.y + dy[k];

                if (n_h < 0 || n_h >= H || n_x < 0 || n_x >= N || n_y < 0 || n_y >= M) {
                    continue;
                }

                if (!visited[n_h][n_x][n_y] && map[n_h][n_x][n_y] == 0) {
                    q.add(new Point(n_h, n_x, n_y));
                    visited[n_h][n_x][n_y] = true;
                    map[n_h][n_x][n_y] = map[curr.h][curr.x][curr.y] + 1;
                }
            }

        }


    }

    static class Point {
        int h, x, y;

        public Point(int h, int x, int y) {
            this.h = h;
            this.x = x;
            this.y = y;
        }
    }
}