import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            for(int j=N-i; j>0; j--) {
                bw.write("*");
            }

            bw.write("\n");
        }




        bw.close();
    }
}
