import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, S, ans;
    static int[] nums, visit, selected;

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        init();

        // 크기가 양수인 부분수열이니까 1~N 크기의 부분수열 전부 체크
        for (int i = 1; i <= N; i++) {
            rec_func(1, 0, i);
        }

        bw.write(ans+" ");

        bw.close();
    }

    private static void rec_func(int k, int prev, int M) throws IOException {
        // 한 케이스 찾으면
        if (k == M + 1) {
            int sum = 0;

            // 합을 구해서
            for (int i = 1; i <= M; i++) {
                sum += selected[i];
            }

            // S랑 같으면 ans++
            if (sum == S) {
                ans++;
            }

        } else {
            for (int i = prev+1; i <= N; i++) {
                int n = nums[i];
                if(visit[i] == 1) continue;

                selected[k] = n;
                visit[i] = 1;

                rec_func(k+1, i, M);

                selected[k] = 0;
                visit[i] = 0;
            }
        }
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        visit = new int[N + 1];
        selected = new int[N + 1];
        ans = 0;

        nums = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

    }
}