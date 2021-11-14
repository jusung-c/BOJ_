// 언어 : JAVA , (성공/실패) : 1/5 , 메모리 : 15236	 KB , 시간 : 168 ms

import javax.print.Doc;
import java.io.*;
import java.util.*;

public class Main {
    static class Doc  {
        private int index; // 순서
        private int price; // 중요도

        public Doc(int index, int price) {
            this.index = index;
            this.price = price;
        }

        public int getPrice() {
            return this.price;
        }

        public int getIndex() {
            return this.index;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T_num = Integer.parseInt(br.readLine());

        Queue<Doc> q = new LinkedList<>();
        PriorityQueue<Integer> PQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for(int i=0; i<T_num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 중요도 입력받은대로 넣기
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int price = Integer.parseInt(st.nextToken());
                q.offer(new Doc(j, price));
                PQ.add(price);
            }

            int cnt = 0;

            while (!q.isEmpty()) {
                // 비교할 doc poll
                Doc doc = q.poll();

                // 우선순위 큐와 큐 비교 후 다르면 다시 add
                if(PQ.peek() != doc.getPrice()) {
                    q.add(doc);
                    continue;
                }

                // 순서가 M이면 그대로 출력
                if (doc.getIndex() == M) {
                    bw.write(cnt+1+"\n");
                }

                // 우선순위 큐 poll
                PQ.poll();
                cnt++;

            }
        }


        bw.close();
    }
}