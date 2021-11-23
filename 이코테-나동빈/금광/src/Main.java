//  <문제> 금광
//        n x m 크기의 금광. 각 칸은 특정한 크기의 금이 들어있다.
//        채굴자는 첫 번째 열부터 출발하여 금을 캔다.
//        처음 첫 번째 열의 어느 행에서든 출발할 수 있다.
//        이후에 m-1번에 걸쳐서 매번 오른쪽 위, 오른쪽, 오른쪽 아래
//        3가지 중 하나의 위치로 이동해서 금을 캔다.
//        결과적으로 채굴자가 얻을 수 있는
//        금의 최대 크기를 출력하는 프로그램을 작성하시오.

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int[][] gold = new int[20][20];
        int[][] dp = new int[20][20];

        int n, m;

        for(int tc=0; tc < T; tc++) {
            // 금광 정보 입력
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    gold[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 2차원 dp 테이블 초기화
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    dp[i][j] = gold[i][j];
                }
            }

            // dp
            for(int j=1; j<m; j++) {
                for(int i=0; i<n; i++) {
                    int leftUp, leftDown, left;

                    // 왼쪽 위에서 오는 경우
                    if(i==0) {
                        leftUp=0;
                    } else {
                        leftUp = dp[i-1][j-1];
                    }

                    // 왼쪽 아래에서 오는 경우
                    if(i==n-1) {
                        leftDown = 0;
                    } else {
                        leftDown = dp[i+1][j-1];
                    }

                    // 왼쪽에서 오는 경우
                    left = dp[i][j-1];

                    dp[i][j] = dp[i][j] + Math.max(leftUp, Math.max(leftDown, left));
                }
            }

            // 마지막 열에서 가장 많은 금을 가져온 것 출력
            int result = 0;
            for(int i=0; i<n; i++) {
                result = Math.max(result, dp[i][m-1]);
            }
            bw.write(result+"\n");
        }

        bw.close();
    }
}