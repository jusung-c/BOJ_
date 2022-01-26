
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int result = 0;
        char[] c = new char[s.length()];
        int index = 0;

        // 문자열 char[]배열에 넣기
        for (int i = 0; i < s.length(); i++) {
            c[i] = s.charAt(i);
        }

        // 공백이 아닌 가장 뒤에 있는 문자열 인덱스 찾기
        for (int i = s.length()-1; i > 0; i--) {
            if (c[i] == ' ') {
                continue;
            } else {
                index = i;
                break;
            }
        }

        // 찾은 인덱스부터 ' '이 나올때까지 result++
        for (int i = index; i >= 0; i--) {
            if (c[i] != ' ') {
                result++;
            } else {
                break;
            }
        }

        // ' '이 없는 경우\
        // ab일 때
        // index = 1
        //


        bw.write(result+" ");
        bw.close();
    }

}