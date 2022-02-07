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
                // 입력 받은 수가 start보다 크면 거기까지 push
                if (start <= arr[i]) {
                    for (int j=start; j<=arr[i]; j++) {
                        s.push(start++);
                        result.add("+");
                    }
                }

                // 스택 s가 비면 더 이상 원하는 수를 pop할 수 없다는 뜻.
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
