import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 요소의 개수
        N = Integer.parseInt(br.readLine());

        // 오름차순 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[7];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 찾아야 하는 수 K
        int K = Integer.parseInt(br.readLine());

        // 결과
        int result = search(K);
        if (result == -1) {
            System.out.println("찾는 값 없어요.");
        } else {
            // 찾는 값의 인덱스 반환
            System.out.println(result+" ");
        }

        bw.close();
    }

    private static int search(int K) {
        int left = 0;
        int right = N-1;

        // 검색 범위가 더 이상 없을 경우까지 - 종료 조건 2번
        while (left <= right) {
            int mid = (left + right) / 2;

            // 종료 조건 1번 - 값을 찾을 경우
            if (arr[mid] == K) {
                return mid;
            } else if (arr[mid] < K) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;

    }

}