import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] array = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i=0; i<N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<N; i++) {
            if (array[i] < X) {
                bw.write(array[i]+" ");
            }
        }

        bw.close();
    }
}