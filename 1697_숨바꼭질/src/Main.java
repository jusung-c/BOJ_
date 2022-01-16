/*
1. 아이디어
- BFS

2. 시간복잡도
V: 100001
E: 3*V
O(V+E) = O(4V) = O(4*100001) < 1초

3. 자료구조
지도 : int[] map
큐(BFS)
*/

import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int MAX = 100001;
    static int[] map = new int[100001];
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        if (N == K) {
            System.out.println(0);
            return;
        } else {
            BFS(N);
        }

        System.out.println(map[K]-1+" ");
    }

    static void BFS(int i) {
        q.add(i);
        map[i] = 1;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int next = 0; next < 3; next++) {
                int n;

                if (next == 0) {
                    n = curr + 1;
                } else if (next == 1) {
                    n = curr - 1;
                } else {
                    n = curr * 2;
                }

                if (n >= 0 && n < MAX && map[n] == 0) {
                    q.add(n);
                    map[n] = map[curr] + 1;
                }

            }
        }
    }
}