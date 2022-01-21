/*
아이디어
- S를 charAt으로 하나씩 받아서 N만큼 반복해주기
*/

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());
            String S = st.nextToken();

            /*
            for (int i = 0; i < S.length(); i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(S.charAt(i));
                }
            }
            */

            for (byte val : S.getBytes(StandardCharsets.UTF_8)) {
                for (int i = 0; i < N; i++) {
                    System.out.print((char)val);
                }
            }

            System.out.println();
        }

    }

}