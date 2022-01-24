/*
1. 아이디어


2. 시간복잡도


3. 자료구조


*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;

        for (int i = 0; i < 5; i++) {
            sum += Integer.parseInt(br.readLine());
        }

        bw.write(sum+" ");

        bw.close();
    }

}