import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static int V, E, startNode;
    static ArrayList<Integer> DFS_visited;
    static ArrayList<Integer> BFS_needVisit, BFS_visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        startNode = Integer.parseInt(st.nextToken());

        graph = new int[V + 1][V + 1];


        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        DFS_visited = new ArrayList<>();
        DFS(startNode);
        System.out.println();

        BFS_needVisit = new ArrayList<>();
        BFS_visited = new ArrayList<>();
        BFS();
    }

    private static void DFS(int i) {
        DFS_visited.add(i);
        System.out.print(i+" ");

        for (int j = 1; j <= V; j++) {
            if(graph[i][j] == 1 && !DFS_visited.contains(j)){
                DFS(j);
            }
        }
    }

    private static void BFS() {

        BFS_needVisit.add(startNode);

        while (!BFS_needVisit.isEmpty()) {
            int node = BFS_needVisit.remove(0);
            BFS_visited.add(node);
            System.out.print(node+" ");

            for (int i = 1; i <= V; i++) {
                if (graph[node][i] == 1 && !BFS_visited.contains(i)) {
                    BFS_needVisit.add(i);
                    BFS_visited.add(i);
                }
            }
        }
        System.out.println();
    }
}
