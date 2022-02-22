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

        // 처음에는 첫 번째 원소가 이제까지 계산된 value값임
        rec_fuc(1, num[1]);

        bw.write(max + "\n"+min);
        bw.close();
    }

    // 이제까지 계산된 value와 다음 계산할 값 operand를 i 연산자로 계산
    static int calculator(int value, int i, int operand) {

        // 더하기
        if (i == 1) {
            return value + operand;
        }

        // 빼기
        if (i == 2) {
            return value - operand;
        }

        // 곱하기
        if (i == 3) {
            return value * operand;
        }

        // 나누기
        if (i == 4) {
            return value / operand;
        }

        return value;
    }

    private static void rec_fuc(int k, int value) {
        // 한 케이스 선택 완료
        if (k == N) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            for (int i = 1; i <= 4; i++) {
                if (operator[i] >= 1) {

                    operator[i]--;
                    order[k] = i;

                    int new_value = calculator(value, i, num[k + 1]);

                    rec_fuc(k + 1, new_value);

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
