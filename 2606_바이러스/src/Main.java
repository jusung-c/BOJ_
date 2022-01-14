// 언어 : JAVA , (성공/실패) : 1/0 
// 메모리 : 14492 KB , 시간 : 140 ms

/*

// 1. 아이디어
1번 컴퓨터부터 BFS

// 2. 시간 복잡도
O(V+E)
V : 100
E : 100*100

O(V+E) = O(10100) < 1초

// 3. 자료구조
큐 (BFS)
간선 정보 graph
방문 기록 visited
*/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int V, E;
    static Queue<Integer> q = new LinkedList<>();
    static int[][] graph;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        graph = new int[V+1][V+1];

        StringTokenizer st;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }

        BFS(1);

        bw.write((cnt-1)+" ");
        bw.close();
    }

    static void BFS(int i) {
        boolean[] visited = new boolean[V + 1];

        visited[i] = true;
        q.offer(i);

        while (!q.isEmpty()) {
            int curr = q.remove();
            cnt++;
//            System.out.println(curr+" ");

            for(int next=1; next<=V; next++) {
                if(!visited[next] && graph[curr][next] !=0) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}