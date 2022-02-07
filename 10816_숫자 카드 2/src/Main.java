
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            arr[i] = (Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            bw.write(B_search_up(num)-B_search_dw(num)+" ");
        }

        bw.close();
    }

    private static int B_search_up(int num) {
        int start = 0;
        int end = arr.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if(num < arr[mid]) {
                end = mid;
            } else {
                start = mid+1;
            }
        }


        return start;
    }

    private static int B_search_dw(int num) {
        int start = 0;
        int end = arr.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if(num <= arr[mid]) {
                end = mid;
            } else {
                start = mid +1;
            }
        }

        return start;
    }

}