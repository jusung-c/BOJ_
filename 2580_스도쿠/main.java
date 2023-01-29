import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] map;

    public static void init() throws IOException {
        map = new int[10][10];

        for (int row = 1; row <= 9; row++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int col = 1; col <= 9; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

    }

    public static void print() throws IOException {
        for (int row = 1; row <= 9; row++) {
            for (int col = 1; col <= 9; col++) {
                bw.write(map[row][col] + " ");
            }
            bw.write("\n");
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        rec_func(1, 1);

        br.close();
        bw.close();
    }

    private static void rec_func(int row, int col) throws IOException {
        if (col == 10) {
            rec_func(row + 1, 1);
        }

        if (row == 10) {
            print();
            bw.close();
            System.exit(0);
        }

        // 숫자가 비어있는 경우
        if (map[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (check(row, col, i)) {
                    map[row][col] = i;

                    rec_func(row, col + 1);
                }
            }

            map[row][col] = 0;
            return;
        }

        // 숫자가 적혀있는 경우
        rec_func(row, col + 1);
    }

    private static boolean check(int row, int col, int val) {
        // 행 체크
        for (int i = 1; i <= 9; i++) {
            if (map[i][col] == val) {
                return false;
            }
        }

        // 열 체크
        for (int i = 1; i <= 9; i++) {
            if (map[row][i] == val) {
                return false;
            }
        }

        // 3x3 체크
        int a = ((row - 1) / 3) * 3 + 1;
        int b = ((col - 1) / 3) * 3 + 1;

        for (int i = a; i <= a + 2; i++) {
            for (int j = b; j <= b + 2; j++) {
                if (map[i][j] == val) {
                    return false;
                }
            }
        }

        return true;
    }
}
