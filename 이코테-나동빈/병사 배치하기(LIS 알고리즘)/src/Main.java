//       <문제> 병사 배치하기
//           N명의 병사가 무작위로 나열. 각 병사는 특정한 값의 전투력 보유.
//           병사를 배치할 때는 전투력이 높은 병사가 앞쪽에 오도록 내림차순 배치
//           특정한 위치에 있는 병사를 열외하면 자동으로 내림차순 되도록 배치.
//           그러면서도 남아 있는 병사의 수가 최대가 되도록.

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static ArrayList<Integer> v = new ArrayList<>();
    static int[] dp = new int[2000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++) {
            v.add(Integer.parseInt(st.nextToken()));
        }

        // 순서를 뒤집어 LIS 알고리즘 문제로 만들기
        Collections.reverse(v);

        // DP 테이블 초기화
        for(int i=0; i<n; i++) {
            dp[i] = 1;
        }

        // LIS 알고리즘
        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                if (v.get(j) < v.get(i)) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        // 열외해야 하는 병사의 최소 수 출력
        int maxValue = 0;
        for (int i=0; i<n; i++) {
            maxValue = Math.max(maxValue, dp[i]);
        }
        bw.write(n-maxValue+" ");

        bw.close();
    }
}