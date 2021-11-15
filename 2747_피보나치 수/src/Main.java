// 언어 : JAVA , (성공/실패) : 1/0 , 메모리 : 15856 KB , 시간 : 144 ms

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] fib = new int[n+1];

        fib[0] = 0;
        fib[1] = 1;

        for(int i=2; i<=n; i++) {
            fib[i] = fib[i-2] + fib[i-1];
        }

        bw.write(fib[n]+" ");

        bw.close();
    }
}