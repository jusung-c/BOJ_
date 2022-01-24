/*
1. 아이디어
N=6

0        1
1        1 1
2        1 2 1  arr[2][1] = arr[1][0] + arr[1][1]
3        1 3 3 1
4        1 4 6 4 1  arr[4][1] = arr[3][0] + arr[3][1]
5        1 5 10 10 5 1


arr[i][j] = arr[i-1][j-1] + arr[i-1][j]


2. 시간복잡도
O(30 * 30)

3. 자료구조
int[][] map

*/

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int numRows = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[numRows][numRows];

        map[0][0] =1;

        for (int i = 1; i < numRows; i++) {
            // i번째 줄 첫번째 1로 초기화
            map[i][0] = 1;

            // i번째 줄 i번째 1로 초기화
            map[i][i] =1;

        }

        for (int i = 2; i < numRows; i++) {
            for (int j = 1; j < i; j++) {
                map[i][j] = map[i - 1][j - 1] + map[i - 1][j];
            }
        }

        bw.write(map[numRows-1][k-1]+" ");

        bw.close();
    }

}