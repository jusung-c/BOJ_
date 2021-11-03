// 언어 : JAVA , (성공/실패) : 1/0 , 메모리 : 18652 KB , 시간 : 396 ms

import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        LinkedList<Integer> q = new LinkedList<>();

        for(int i=1; i<=N; i++){
            q.add(i);
        }


        for(int j=0; j<N-1; j++) {
            q.removeFirst();
            if (!q.isEmpty()) {
                q.add(q.removeFirst());
            }
        }
        bw.write(q.getFirst()+" ");


        bw.close();
        }
    }
