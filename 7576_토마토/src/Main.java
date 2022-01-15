/*
1. 아이디어
- 익을 토마토부터 0을 찾아 BFS
- BFS를 실행하면서 처음 토마토부터의 거리++

2. 시간복잡도
V: 1000
E: 4*V
O(V+E) = O(5V) = O(5000) < 1초

3. 자료구조
방문 기록 : bool[][] visited
지도 : int[][] map
큐(BFS)

*/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int[][] map;
    static boolean[][] visited;
    static int cnt, area;
    static Queue<Pair> q = new LinkedList<Pair>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BFS();

        int max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (max<map[i][j]) {
                    max = map[i][j];
                }
                if (map[i][j] == 0) {
                    bw.write("-1"+" " );
                    bw.close();
                    return;
                }
            }
        }

        bw.write((max-1)+" ");

        bw.close();
    }

    static void BFS() {
        visited = new boolean[N][M];

        // 익은 토마토 모두 큐에 넣고 동시에 BFS 돌리기 +방문처리
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    q.add(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            for (int k = 0; k < 4; k++) {
                int n_x = curr.x + dx[k];
                int n_y = curr.y + dy[k];

                if (n_x < 0 || n_x >= N || n_y < 0 || n_y >= M) {
                    continue;
                }

                if (!visited[n_x][n_y] && map[n_x][n_y] == 0) {
                    q.add(new Pair(n_x, n_y));
                    visited[n_x][n_y] = true;
                    map[n_x][n_y] = map[curr.x][curr.y] +1;
                }

            }

        }

    }

    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}