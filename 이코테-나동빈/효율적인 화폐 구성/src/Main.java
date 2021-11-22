//      <문제> 효율적인 화폐 구성
//        N가지 종류의 화폐가 있다.
//        화폐의 개수를 최소한으로 이용하여 합이 M원이 되도록 한다.

//        ex) 2원, 3원 5원 단위 화폐가 있을 때 7원 만들기 위해선
//        2개가 최소

//        [입출력 조건]
//        첫째 줄에 N, M. 이후의 N개의 줄에서 각 화폐의 단위 주어진다.
//        (1 <= N <= 100, 1 <= M <= 10,000) 출력이 불가능할 경우 -1 출력.

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] price = new int[N+1];

        for(int i=1; i<=N; i++) {
            price[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[M+2];
        Arrays.fill(dp, 10001);

        dp[0] = 0;

        for(int i=1; i<=N; i++) {
            for(int j=price[i]; j<=M; j++) {
                dp[j] = Math.min(dp[j], dp[j-price[i]]+1);
            }
        }

        if (dp[M] == 10001) {
            bw.write("-1"+" ");
        } else {
            bw.write(dp[M]+" ");
        }

        bw.close();
    }
}