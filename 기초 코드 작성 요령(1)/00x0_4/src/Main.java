// 시간복잡도 O(logN)

import java.io.*;

public class Main {
    private static int func4(int N) {
        int max = 0;
        for (int i=1; 2*i<=N; i++) {
            max = 2*i;
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int N = Integer.parseInt(s);

        int result = func4(N);

        bw.write(result+"\n");
        bw.close();
    }
}
