import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for(int i=0; i<N; i++) {
            arr[i] = st.nextToken();
        }

        String v = br.readLine();

        int result = 0;

        for(int i=0; i<N; i++) {
            if (arr[i].equals(v)) {
                result++;
            }
        }

        bw.write(result+" ");



        bw.close();
    }
}
