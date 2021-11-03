import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Stack<int[]> s = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            int n = Integer.parseInt(st.nextToken());

            while(!s.isEmpty()) {
                // 최상단 탑이 n보다 작으면, 스택에서 제거
                if(s.peek()[0] < n)
                    s.pop();
                // 최상단 탑이 n보다 크다면, 해당 탑의 번호를 출력하고 break
                else {
                    bw.write(s.peek()[1] + " ");
                    break;
                }
            }

            // 탑이 비었다면 0을 출력한다.
            if(s.empty())
                bw.write("0"+" ");

            // 탑의 높이와 탑의 번호 배열을 저장
            s.push(new int[] {n, i+1});
        }

        bw.close();

    }

}