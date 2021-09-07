import java.io.*;

public class Main {

    private static int func2(int[] arr, int N) {
        for (int i=0; i<N; i++) {
            for (int j=i+1; j<N; j++) {
                if (arr[i] + arr[j] == 100) {
                    return 1;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String s = br.readLine();
        int N = Integer.parseInt(s);
        int[] arr = new int[N];

        for (int i=0; i<N; i++) {
            s = br.readLine();
            arr[i] = Integer.parseInt(s);
        }

        int result = func2(arr, N);

        bw.write(result+"\n");
        bw.close();

    }
}
