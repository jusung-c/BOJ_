
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> s = new Stack<Integer>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int num;
        int count=0;

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i=0; i<N; i++) {
            q.add(Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i<N; i++) {
            num = q.poll();
            if (s.isEmpty()) {
                s.add(num);
                arr.add(0);
            } else {
                while (!s.isEmpty() && num < s.peek()) {
                    s.pop();
                    count++;
                }
                s.add(num);
                arr.add(count);
            }


        }

        for (int i : arr) {
            bw.write(i+" ");
        }

        bw.close();
    }
}
