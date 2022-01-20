/*
1. 아이디어
- 0~10000 for문으로 돌면서 d(n) 계산 후 방문처리
- d(n)은 10 단위로 줄여가면서 각 자릿수 더해주기

2. 시간복잡도
O(10000)

3. 자료구조
방문 기록 : bool[] visited
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] visited = new boolean[10000];

        for (int i = 1; i < 10000; i++) {
            if (d(i) < 10000) {
                visited[d(i)] = true;
            }
        }

        for (int i = 1; i < visited.length; i++) {
            if (visited[i] == false) {
                bw.write(i+"\n");
            }
        }

        bw.close();
    }

    public static int d(int i) {
        int sum = i;

        // 10 단위씩 i를 줄여 나간다.
        while (i != 0) {
            sum += i%10;
            i = i/10;
        }

        return sum;
    }

}