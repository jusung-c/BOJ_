// 언어 : JAVA , (성공/실패) : 1/0 , 메모리 : 18700 KB , 시간 : 1540 ms
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 유클리드 호제법
    private static int Euclidean(int a, int b) {
        int r = a % b;
        if (r == 0) {
            return a;
        }
        return Euclidean(b, r);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        if (n == 2) {
            bw.write(Euclidean(arr[0], arr[1]));
        }
        // 2개 먼저 최대공약수 구하고 그 수와 나머지 수 최대공약수 구하면 세 수의 최대공약수가 나온다.
        else if (n == 3) {
            int a = Euclidean(arr[0], arr[1]);
            if (a>arr[2]) {
                bw.write(Euclidean(a, arr[2]));
            } else {
                bw.write(Euclidean(arr[2], a));
            }


        }

        bw.close();

    }
}
