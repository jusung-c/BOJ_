import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int func2(int[] arr, int N) {
        boolean[] cnt = new boolean[101];

        int result = 0;
        for(int i=0; i<N; i++) {
            if(cnt[100-arr[i]] == true) {
                result++;
            }
            cnt[arr[i]]=true;
        }

        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(func2(arr, N)+" ");

        bw.close();
    }
}
