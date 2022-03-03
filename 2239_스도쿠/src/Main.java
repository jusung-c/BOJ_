import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] map;
    public static void main(String[] args) throws IOException {
        input();

        rec_func(1, 1);

    }

    private static void rec_func(int row, int col) throws IOException {

        // 현재 행의 열들을 다 채웠을 경우 다음 행으로
        if (col == 10) {
            rec_func(row + 1, 1);
            return;
        }

        // 끝 행의 열들까지 다 채웠을 경우 출력
        if (row == 10) {
            print();

            // 사전순으로 하나만 찾으면 바로 종료
            bw.close();
            System.exit(0);
        }

        if (map[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (check(row, col, i)) {
                    map[row][col] = i;

                    rec_func(row, col+1);
                }
            }

            map[row][col] = 0;
            return;
        }

        // 이미 숫자가 적혀있을 경우
        rec_func(row, col + 1);

    }

    private static boolean check(int row, int col, int value) {
        // 행 체크
        for (int i = 1; i <= 9; i++) {
            if (map[row][i] == value) {
                return false;
            }
        }

        // 열 체크
        for (int i = 1; i <= 9; i++) {
            if (map[i][col] == value) {
                return false;
            }
        }

        // 대각선 체크
        int row_scope = (((row - 1) / 3) * 3) + 1;
        int col_scope = (((col - 1) / 3) * 3) + 1;

        for (int i = row_scope; i <= row_scope + 2; i++) {
            for (int j = col_scope; j <= col_scope + 2; j++) {
                if (map[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[10][10];

        for (int i = 1; i <= 9; i++) {
            String a = br.readLine();

            for (int j = 1; j <= 9; j++) {
                map[i][j] = a.charAt(j-1) - 48;
            }
        }
    }

    static void print() throws IOException {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                bw.write(map[i][j]+"");
            }
            bw.write("\n");
        }
    }
}