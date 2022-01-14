/*
1. 아이디어
- 2중 for문으로 1을 찾아나가는 BFS
- BFS 실행할 때마다 지렁이++

2. 시간복잡도
V: 50*50
E: 4*V
O(V+E) = O(5V) = O(5*50*50) < 1초

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

        // 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());

        // 테스트 케이스 돌면서
        for(int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            cnt = 0;

            visited = new boolean[M][N];
            map = new int[M][N];

            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine()," ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
//                        bw.write(i+" "+j+"\n");
                        BFS(i, j);
                        cnt++;
                    }
                }
            }
            bw.write(cnt+"\n");
        }

        bw.close();
    }

    static void BFS(int i, int j) {
        q.add(new Pair(i, j));

        while (!q.isEmpty()) {

            visited[i][j] = true;
            Pair curr = q.poll();

            for (int k = 0; k < 4; k++) {
                int n_x = curr.x + dx[k];
                int n_y = curr.y + dy[k];

                if (n_x < 0 || n_x >= M || n_y < 0 || n_y >= N) {
                    continue;
                }

                if (!visited[n_x][n_y] && map[n_x][n_y] == 1) {
                    q.add(new Pair(n_x, n_y));
                    visited[n_x][n_y] = true;
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