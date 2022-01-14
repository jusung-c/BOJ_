// 언어 : JAVA , (성공/실패) : 1/0
// 메모리 : 16296 KB , 시간 : 160 ms

/*
// 1. 아이디어
- (1,1)에서 BFS
- BFS 돌때마다 cnt++, 최솟값 갱신

// 2. 시간 복잡도
O(V+E)
V: 100*100
E: 4*V
O(V+E) = O(5V) = 5*100*100 < 1초

// 3. 자료 구조
- 방문 bool[][] visited
- 큐 (BFS)
- map : int[][]
- Pair 클래스
*/


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, MAX, cnt;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;
    static Queue<Pair> q = new LinkedList<Pair>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        MAX = Math.max(N, M);

        map = new int[MAX+1][MAX+1];

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        BFS(0, 0);

        bw.write(map[N-1][M-1]+" ");

        bw.close();
    }

    static void BFS(int x, int y) {
        visited = new boolean[MAX+1][MAX+1];
        cnt = 0;

        visited[x][y] = true;
        q.offer(new Pair(x, y));

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            for(int k=0; k<4; k++) {
                int n_x = curr.x + dx[k];
                int n_y = curr.y + dy[k];

                if (n_x < 0 || n_x >= N || n_y < 0 || n_y >= M) {
                    continue;
                }

                if (!visited[n_x][n_y] && map[n_x][n_y] == 1) {
                    q.offer(new Pair(n_x, n_y));
                    map[n_x][n_y] = map[curr.x][curr.y] +1;
                    visited[n_x][n_y] = true;
                }
            }
        }

    }


    private static class Pair {
        int x,y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}