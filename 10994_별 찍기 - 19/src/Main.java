/*
1. 아이디어
- 테두리가 4*(N-1)+1인 정사각형
- N부터 -1씩 재귀로 호출

2. 시간 복잡도
O(10000) < 1초

3. 자료구조
별 찍을 map : char[][]

*/

import java.io.*;

public class Main {
    static char[][] map;

    public static void star(int N, int x, int y) {
        if (N == 1) {
            map[x][y] = '*';
            return;
        }

        int len = 4 * (N - 1) + 1;

        // 정사각형 그리기
        for (int i = x; i < x + len; i++) {
            map[i][y] = '*';
            map[i][y+len-1] = '*';
        }

        for (int j = y; j < y + len; j++) {
            map[x][j] = '*';
            map[x+len-1][j] = '*';
        }

        // 다음으로 작은 정사각형 그리기
        star(N-1, x+2, y+2);
        return;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        map = new char[500][500];
        int len = 4 * (N - 1) + 1;


        // map 공백으로 초기화
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                map[i][j] = ' ';
            }
        }

        star(N, 0, 0);

        // map 출력
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                bw.write(map[i][j]);
            }
            bw.write("\n");
        }


        bw.close();
    }

}