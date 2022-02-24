import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, S, ans;
    static int[] nums, selected;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        input();

        rec_func(1);

        // S가 0일때 아무것도 안해도 만족하므로 그 경우 빼준다 - 진부분수열이어야 하기 때문
        if (S == 0) {
            ans -= 1;
        }

        bw.write(ans+" ");

        bw.close();
    }

    private static void rec_func(int k) throws IOException {
        if (k == N + 1) {
            int sum = 0;
            for (int i = 1; i <= N; i++) {
                if (selected[i] == 1) {
                    sum += nums[i];
                }
            }

            if (sum == S) {
                ans++;
            }

        } else {
            for (int i = 0; i <= 1; i++) {
                selected[k] = i;

                rec_func(k + 1);

                selected[k] = 0;
            }
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        ans = 0;
        nums = new int[N + 1];
        selected = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }
}