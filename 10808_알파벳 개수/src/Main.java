import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int[] abc_count = new int[26];

        for(int i=0; i<s.length(); i++) {
            abc_count[s.charAt(i)-97] += 1;
        }

        for(int i=0; i<26; i++) {
            bw.write(abc_count[i]+" ");
        }

        bw.close();
    }
}
