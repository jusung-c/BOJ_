// 언어 : JAVA , (성공/실패) : 1/0 , 메모리 : 24688 KB , 시간 : 260 ms

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> s = new Stack<Integer>();

        int K = Integer.parseInt(br.readLine());

        for(int i=0; i<K; i++) {
            int num = Integer.parseInt(br.readLine());

            switch (num) {
                case 0:
                    s.pop();
                    break;
                default:
                    s.push(num);
                    break;
            }
        }

        int sum=0;

        for(int i : s){
            sum += i;
        }

        bw.write(sum+" ");

        bw.close();
    }
}
