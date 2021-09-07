import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        long[] arr = new long[2];
        arr[0] = Long.parseLong(st.nextToken());
        arr[1] = Long.parseLong(st.nextToken());

        Arrays.sort(arr);

        if (arr[0] == arr[1]) bw.write("0");
        else {
            bw.write(arr[1]-arr[0]-1+"\n");

            for (long i=1; i<arr[1]-arr[0]; i++) {
                bw.write(arr[0]+i+" ");
            }

        }

        bw.close();

    }
}
