

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {
    static boolean[] hansu = new boolean[1000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

/*
        방법 1

        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();
        int sum = 0;


        for (int i = 0; i < S.length(); i++) {
            sum += S.charAt(i) - '0';
        }

        bw.write(sum+" ");
*/

        // 방법 2
        br.readLine(); // N은 필요 없으니까 입력만 받음

        int sum = 0;

        for(byte value : br.readLine().getBytes()) {
            sum += (value - '0');
        }

        bw.write(sum+" ");

        bw.close();
    }

}