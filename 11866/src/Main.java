
/*
1. 아이디어
- 큐에 순서대로 넣어준 후
- K-1번까지 빼서 다시 뒤로
- K번째 빼서 출력


2. 시간복잡도


3. 자료구조
- 큐
 */


import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> q = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        sb.append("<");

        while(!q.isEmpty()) {
            for (int i = 1; i < K; i++) {
                q.add(q.remove(0));
            }
            sb.append(q.remove(0) + ", ");
        }

        bw.write((sb.substring(0, sb.length() - 2) + ">").toString());

        bw.close();

    }

}