/*
1. 아이디어
- 1~9 : 한자릿수라서 무조건 등차수열
- 10~99 : 두자릿수도 무조건 등차수열
- 100~999 : 등차수열 검사
- 1000 : 999와 동일

2. 시간복잡도
O(1000)

3. 자료구조

*/

import java.io.*;

public class Main {
    static boolean[] hansu = new boolean[1000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        if (N == 1000) {
            bw.write(test(999) + " ");
        } else {
            bw.write(test(N)+" ");
        }

        bw.close();
    }

    public static int test(int i) {
        int cnt = 0;

        if (i < 100) {
            return i;
        } else {
            cnt=99;

            for (int k = 100; k <= i; k++) {
                int hun = k / 100; // 백의 자릿수
                int ten =( k / 10) % 10; // 십의 자릿수
                int one = k % 10;  // 일의 자릿수

                if ((hun - ten) == (ten - one)) {
                    cnt++;
                }
            }

        }

        return cnt;
    }

}