import java.io.*;
import java.util.*;

public class Main {
    static int[] dataList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        dataList = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            dataList[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(dataList);

        int M = Integer.parseInt(br.readLine());


        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            int result = binarySearch(num);
            bw.write(result+"\n");
        }

        bw.close();

    }

    // 이분탐색 시간 복잡도 : O(M*logN)
    public static int binarySearch(int num) {
        int start = 0;
        int end = dataList.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (dataList[mid] > num) {
                end = mid-1;
            } else if (dataList[mid] < num) {
                start = mid + 1;
            } else {
                return 1;
            }
        }

        return 0;
    }
}
