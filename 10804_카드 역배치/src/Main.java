import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void card_change(int[] card_list, int A, int B) {
        int mid = (B-A) /2;

        for(int i=0; i<=mid; i++){
            int tmp = card_list[A+i];
            card_list[A+i] = card_list[B-i];
            card_list[B-i] = tmp;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] arr = new int[10][2];
        int[] card_list = new int[21];

        for(int i = 0; i<10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

        }

        for(int i=1; i<21; i++) {
            card_list[i] = i;
        }

        for(int i=0; i<10; i++) {
            card_change(card_list, arr[i][0], arr[i][1]);
        }

        for(int i=1; i<21; i++) {
            bw.write(card_list[i]+" ");
        }


        bw.close();
    }
}