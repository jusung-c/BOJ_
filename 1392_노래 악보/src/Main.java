/*
1. 아이디어

001222
012345



2. 시간복잡도


3. 자료구조


*/

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            for (int j = 0; j < a; j++) {
                arr.add(i+1);
            }
        }

//        for (Integer i : arr) {
//            bw.write(i+" ");
//        }
//        bw.write("\n");

        for (int i = 0; i < Q; i++) {
            int a = Integer.parseInt(br.readLine());
            bw.write(arr.get(a)+"\n");
        }


        bw.close();
    }

}