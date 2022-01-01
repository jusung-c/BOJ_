// 언어 : JAVA , (성공/실패) : 1/0 
// 메모리 : 28764 KB , 시간 : 1464 ms

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int ans = 2000000001;


        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for(int sta=0; sta<N; sta++) {
            for(int en=sta; en<N; en++) {
                if(arr[en]-arr[sta]>=M) {
                    ans = Math.min(ans, arr[en]-arr[sta]);
                    break;
                }
            }
        }

        System.out.println(ans+" ");


        bw.close();
    }
}