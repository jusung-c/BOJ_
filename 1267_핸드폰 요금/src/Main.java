import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int Y_rate(int[] arr, int N) {
        int sum = 0;

        for (int i=0; i<N; i++) {
            sum += ((arr[i]/30)+1)*10;
        }

        return sum;
    }
    public static int M_rate(int[] arr, int N) {
        int sum = 0;

        for (int i=0; i<N; i++) {
            sum += ((arr[i]/60)+1)*15;
        }

        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for(int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = M_rate(arr, N);
        int Y = Y_rate(arr, N);


        if (M > Y) {
            bw.write("Y"+" "+Y+" ");
        } else if (M < Y) {
            bw.write("M"+" "+M+" ");
        } else {
            bw.write("Y"+" "+"M"+" "+M);
        }

        bw.close();

    }
}
