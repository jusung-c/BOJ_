import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int[][] map;
    static int answer = Integer.MAX_VALUE;
    static ArrayList<Pair> house = new ArrayList<>();
    static ArrayList<Pair> chicken = new ArrayList<>();
    static int[] selected;

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 1) {
                    house.add(new Pair(i, j));
                } else if (a == 2) {
                    chicken.add(new Pair(i, j));
                }
            }
        }

//        System.out.println("치킨집 수: " + chicken.size());

        selected = new int[M + 1];
    }

    private static void print(ArrayList<Pair> arr) {
        Iterator<Pair> iterator = arr.iterator();
        while (iterator.hasNext()) {
            Pair p = iterator.next();
            System.out.println(p.x +" , " + p.y);
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        rec_func(1, 0);

        System.out.println(answer);

        br.close();
        bw.close();
    }

    private static void rec_func(int k, int prev) {
        if (k == M + 1) {
            int sum = 0;

            for (int i = 0; i < house.size(); i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= M; j++) {
                    Pair p1 = house.get(i);
                    Pair p2 = chicken.get(selected[j]);

                    min = Math.min(min, Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y));

                }
//                System.out.println("min값: " + min + "i값: " + i);
                sum += min;
            }

//            System.out.println("케이스: " + sum+" ");
            answer = Math.min(answer, sum);

        } else {
            for (int i = prev; i < chicken.size(); i++) {
                selected[k] = i;
                rec_func(k + 1, i + 1);

            }
        }
    }
}
