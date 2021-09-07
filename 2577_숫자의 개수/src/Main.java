import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int multi = A*B*C;

        String s = String.valueOf(multi);
        String[] arr = s.split("");

        int[] int_arr = new int[arr.length];

        for (int i=0; i<arr.length; i++) {
            int_arr[i] = Integer.parseInt(arr[i]);
        }

        int[] cnt = new int[10];
        for (int i=0; i<arr.length; i++) {
            cnt[int_arr[i]] +=1;
        }

        for (int i=0; i<cnt.length; i++) {
            bw.write(cnt[i]+"\n");
        }


        bw.close();

    }
}
