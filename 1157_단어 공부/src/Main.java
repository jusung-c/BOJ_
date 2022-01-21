/*
1. 아이디어
- 문자열을 받아서 하나씩 뜯어보고
- 65~90 -> 대문자
- 97~122 -> 소문자

2. 시간복잡도


*/

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {
    static boolean[] hansu = new boolean[1000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        int[] cnt = new int[26];

        for (int i = 0; i < S.length(); i++) {
            if ('A' <= S.charAt(i) && S.charAt(i) <= 'Z') { // 대문자 범위
                cnt[S.charAt(i) - 'A']++;
            }

            else { // 소문자
                cnt[S.charAt(i) - 'a']++;
            }
        }

        int max = Integer.MIN_VALUE;
        char result = 0;

        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > max) {
                max = cnt[i];
                result = (char) (i + 'A');
            } else if (cnt[i] == max){
                result = '?';
            }
        }

        bw.write(result+" ");

        bw.close();
    }

}