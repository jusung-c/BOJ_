// 언어 : JAVA , (성공/실패) : 1/0 
// 메모리 : 24588 KB , 시간 : 320 ms

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int ans = 100001;
        int sum = 0;

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sta=0, en=0;

        while(true) {
            if (sum>=S) {
                sum -= arr[sta++];
                ans = Math.min(ans, (en-sta)+1);
            }
            else if (en==N){
                break;
            }
            else {
                sum += arr[en++];
            }
        }

        if(ans == 100001) {
            bw.write(0+" ");
        } else {
            bw.write(ans+" ");
        }

        bw.close();
    }
}