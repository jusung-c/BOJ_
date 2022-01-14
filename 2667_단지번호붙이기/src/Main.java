/*
1. 아이디어
- 2중 for문으로 1을 찾아나가는 BFS
- BFS 실행할 때마다 단지수 ++, 각 단지 안 집수++

2. 시간복잡도
V: 25*25
E: 4*V
O(V+E) = O(5V) = O(5^5) < 1초

3. 자료구조
방문 기록 : bool[][] visited
지도 : int[][] map
큐(BFS)

*/

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int cnt, area;
    static Queue<Pair> q = new LinkedList<Pair>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        visited = new boolean[N+1][N+1];

        int[] areas = new int[N*N];
        int z=0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    areas[z++] = BFS(i,j);
                }
            }
        }

        Arrays.sort(areas);

        bw.write(cnt+"\n");
        for(int i=0; i<N*N; i++) {
            if (areas[i] != 0) {
                bw.write(areas[i]+"\n");
            }
        }

        bw.close();
    }

    private static int BFS(int i, int j) {
        cnt++;
        area =1;
        visited[i][j] = true;
        q.add(new Pair(i, j));

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            for(int k=0; k<4; k++) {
                int n_x = curr.x + dx[k];
                int n_y = curr.y + dy[k];

                if (n_x < 0 || n_x > N || n_y < 0 || n_y > N) {
                    continue;
                }

                if (!visited[n_x][n_y] && map[n_x][n_y] == 1) {
                    q.add(new Pair(n_x, n_y));
                    visited[n_x][n_y] = true;
                    area++;
                }

            }
        }

        return area;

    }

    private static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}