// 언어 : JAVA , (성공/실패) : 1/0 , 메모리 : 14300 KB , 시간 : 140 ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");

        double a, b;
        a = Double.parseDouble(st.nextToken());
        b = Double.parseDouble(st.nextToken());

        System.out.println(a/b);

    }
}
