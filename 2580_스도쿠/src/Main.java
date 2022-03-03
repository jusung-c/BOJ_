import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] map;

    public static void main(String[] args) throws IOException {
        init();

        // 1행 1열부터 탐색 시작
        rec_func(1, 1);

    }

    private static void rec_func(int row, int col) throws IOException {
        // 현재 행의 열이 다 채워지면 다음 행부터 다시 1열 ~ 9열 탐색
        if (col == 10) {
            rec_func(row + 1, 1);
        }

        // 여러 경우의 수가 있겠지만 1개 찾으면 그자리에서 출력 후 바로 종료
        if (row == 10) {
            print(map);
            bw.close();
            System.exit(0);
        }

        // 숫자가 0으로 비어있으면 탐색 시작
        if (map[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {

                // 모든 조건 체크
                if (check(row, col, i)) {
                    map[row][col] = i;

                    // 다음 열 탐색
                    rec_func(row, col+1);
                }
            }

            // 맞는 케이스를 못찾았을 경우를 위한 초기화와 return
            map[row][col] = 0;
            return;
        }

        // 이미 숫자가 적혀있으면 다음 열로 ㄱㄱ
        rec_func(row, col + 1);
    }

    static boolean check(int row, int col, int value) {

        // 행 check
        for (int i = 1; i <= 9; i++) {
            if (map[row][i] == value) {
                return false;
            }
        }

        // 열 check
        for (int i = 1; i <= 9; i++) {
            if (map[i][col] == value) {
                return false;
            }
        }

        // 3x3 check
        int x = ((row - 1) / 3) * 3;
        int y = ((col - 1) / 3) * 3;

        for (int i = x+1; i <= x + 3; i++) {
            for (int j = y+1; j <= y + 3; j++) {
                if (map[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }

    // map 출력
    static void print(int[][] map) throws IOException {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                bw.write(map[i][j] + " ");
            }
            bw.write("\n");
        }
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[10][10];

        for (int i = 1; i <= 9; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}