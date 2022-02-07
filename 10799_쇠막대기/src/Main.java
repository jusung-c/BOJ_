/*
1. 아이디어
- '('이면 스택에 add
- ')'일 경우
        1. 바로 전 문자가 '('인 경우 레이저니까 ans+=stack.size()
        2. 그게 아닌 경우 막대기 종료 -> ans+=1

2. 시간복잡도


3. 자료구조
- 스택

*/

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int ans = 0;

        ArrayList<Character> Stack = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                Stack.add('(');
            } else {
                Stack.remove(Stack.size() - 1);
                // 레이저인 경우
                if(s.charAt(i-1) == '(') {
                    ans += Stack.size();

                // 쇠막대기 종료인 경우
                } else {
                    ans += 1;
                }
            }
        }

        bw.write(ans + " ");

        bw.close();
    }

}