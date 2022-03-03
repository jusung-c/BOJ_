import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static char[] inequality;
    static int[] selected, visit;
    static ArrayList<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();

        rec_func(1);

        bw.write(result.get(result.size() - 1)+"\n");
        bw.write(result.get(0));
        bw.close();
    }

    private static void rec_func(int k) throws IOException {
        if (k == M + 1) {
            // 조건 : 부등호를 만족하는가 ?
            if (isvalid() == true) {
                String s = "";
                for (int i = 1; i <= M; i++) {
                    s += selected[i];
                }
                result.add(s);

            }

        } else {
            for (int i = 0; i <= 9; i++) {
                if(visit[i] == 1) continue;

                selected[k] = i;
                visit[i] = 1;

                rec_func(k + 1);

                selected[k] = 0;
                visit[i] = 0;
            }

        }
    }

    private static boolean isvalid() {

        boolean possible = false;

        for (int i = 1; i <= N; i++) {
            // 뒤의 수가 큰 경우 && <
            if (((selected[i] - selected[i + 1]) < 0) && (inequality[i] == '<')) {
                possible = true;

            // 앞의 수가 큰 경우 && >
            } else if (((selected[i] - selected[i + 1]) > 0) && (inequality[i] == '>')) {
                possible = true;
            } else {
                possible = false;
            }

            if (possible == false) {
                break;
            }

        }

        return possible;
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = N + 1;

        inequality = new char[N + 1];
        selected = new int[M + 1];
        visit = new int[10];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            inequality[i] = st.nextToken().charAt(0);
        }

    }
}