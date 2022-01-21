/*
1. 아이디어
- 단어 S를 String으로 받아서 배열에 저장해주기
- a부터 z까지 for문으로 돌면서 배열에 있는 지 확인 후 있으면 위치와 cnt[]++

2. 시간복잡도
- O(100*26)<1초

3. 자료구조
String S
char[] c
int[] cnt

*/

import java.io.*;

public class Main {
    static boolean[] hansu = new boolean[1000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        int[] arr = new int[26];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            // 이미 앞에서 변경했을 경우 제외
            if (arr[c - 'a'] == -1) {
                arr[c - 'a'] = i;  // 순서
            }
        }

        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i]+" ");
        }

        bw.close();
    }

}