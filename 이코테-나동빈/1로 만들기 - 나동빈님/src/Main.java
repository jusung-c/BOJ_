//      <문제> 1로 만들기
//        정수 X가 주어졌을 때,
//        1. X가 5로 나누어 떨어지면, 5로 나눈다.
//        2. X가 3으로 나누어 떨어지면, 3으로 나눈다.
//        3. X가 2로 나누어 떨어지면, 2로 나눈다.
//        4. X에서 1을 뺀다.
//        정수 X가 주어졌을 때, 연산 4개를 적절히 사용해서 값을 1로 만들고자 한다.
//        연산을 사용하는 횟수의 최솟값을 출력해보자.

//        ex) 26 -> 25 -> 5 -> 1

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());

        int[] dp = new int[x+2];

        for (int i=2; i<=x; i++) {
            dp[i] = dp[i-1]+1;

            if(dp[i] % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i/2]+1);
            }

            if(dp[i] % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i/3]+1);
            }

            if(dp[i] % 5 == 0) {
                dp[i] = Math.min(dp[i], dp[i/5]+1);
            }
        }

        bw.write(dp[x]+" ");

        bw.close();
    }
}