/*
1. 아이디어
- 2중 for문 돌면서 BFS
- BFS 돌때마다 cnt

2. 시간복잡도

3. 자료구조
지도 : int[][] map
방문 : boolean[] visited
큐(BFS)
*/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int V, E, cnt;
    static int[][] map ;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        map = new int[V + 1][V + 1];
        visited = new boolean[V+1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }

        cnt = 0;

        for (int j = 1; j <= V; j++) {
            if (!visited[j]) {
                BFS(j);
                cnt++;
            }
        }

        bw.write(cnt+" ");

        bw.close();

    }

    private static void BFS(int i) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(i);
        visited[i] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int j = 1; j <= V; j++) {
                if (map[curr][j] == 1 && visited[j] == false) {
                    visited[j] = true;
                    q.offer(j);
                }
            }

        }

    }

}