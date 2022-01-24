

import java.io.*;

public class Main {
    static boolean[] hansu = new boolean[1000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= k; i++) {
                System.out.print("*");
            }
            for (int i=1; i <= 2*(N-k); i++) {
                System.out.print(" ");
            }
            for (int i = 1; i <= k; i++) {
                System.out.print("*");
            }

            System.out.println();
        }

        for (int k = N-1; k >=1; k--) {
            for (int i = k; i >= 1; i--) {
                System.out.print("*");
            }

            for (int i = 2 * (N - k); i >= 1; i--) {
                System.out.print(" ");
            }

            for (int i = k; i >= 1; i--) {
                System.out.print("*");
            }

            System.out.println();
        }


    }

}