import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, max, min;
    static int[] num, operator, order;

    public static void main(String[] args) throws IOException {
        input();

        rec_fuc(1);

        bw.write(max + "\n"+min);
        bw.close();
    }

    static int calculator() {
        // nums, order
        int value = num[1];
        for (int i = 1; i <= N - 1; i++) {

            // 더하기
            if (order[i] == 1) {
                value += num[i + 1];
            }

            // 빼기
            if (order[i] == 2) {
                value -= num[i + 1];
            }

            // 곱하기
            if (order[i] == 3) {
                value *= num[i + 1];
            }

            // 나누기
            if (order[i] == 4) {
                value /= num[i + 1];
            }
        }

        return value;
    }

    private static void rec_fuc(int k) {
        // 한 케이스 선택 완료
        if (k == N) {
            // 결정된 연산자 조합으로 계산 후 갱신
            int value = calculator();

            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            for (int i = 1; i <= 4; i++) {
                if (operator[i] >= 1) {

                    operator[i]--;
                    order[k] = i;

                    rec_fuc(k + 1);

                    // 다시 초기화
                    operator[i]++;
                    order[k] = 0;
                }


                order[k] = 0;
            }
        }
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        num = new int[N + 1];
        operator = new int[5];

        // order에 연산자들이 순서대로 저장된다.
        order = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        // 최댓값/최솟값 초기화
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

    }
}
