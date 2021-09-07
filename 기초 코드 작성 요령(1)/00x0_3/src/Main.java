import java.io.*;

public class Main {

    private static int func3(int N) {
        for (int i=0; i<N; i++) {
            if(i*i == N) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int N = Integer.parseInt(s);

        int result = func3(N);

        bw.write(result+"\n");
        bw.close();

    }
}
