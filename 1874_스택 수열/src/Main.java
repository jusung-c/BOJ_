// 언어 : JAVA , (성공/실패) : 1/0 , 메모리 : 18652 KB , 시간 : 396 ms

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<Integer>();
        ArrayList<String> result = new ArrayList<String>();
        int[] arr = new int[N];
        int start = 1;

        boolean Able = true;
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (Able) {
                if (start <= arr[i]) {
                    for (int j=start; j<=arr[i]; j++) {
                        s.push(start++);
                        result.add("+");
                    }
                }

                if(s.isEmpty()) {
                    Able = false;
                }
                else {
                    for (int j=s.peek(); j>= arr[i]; j--) {
                        s.pop();
                        result.add("-");
                        if (s.isEmpty()) {
                            break;
                        }
                    }
                }
            }
        }

        if (Able) {
            for(String str: result) {
                bw.write(str+"\n");
            }
        } else {
            bw.write("NO"+" ");
        }


        bw.close();
    }
}
