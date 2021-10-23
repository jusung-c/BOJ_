import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] words1 = br.readLine().toCharArray();
        char[] words2 = br.readLine().toCharArray();

        int[] alpha = new int[26];

        for(int i=0; i<words1.length; i++) {
            alpha[words1[i]-97]++;
        }

        for(int i=0; i<words2.length; i++) {
            alpha[words2[i]-97]--;
        }

        int sum = 0;
        for(int i=0; i<26; i++) {
            sum += Math.abs(alpha[i]);
        }

        bw.write(sum+" ");


        bw.close();
    }
}
