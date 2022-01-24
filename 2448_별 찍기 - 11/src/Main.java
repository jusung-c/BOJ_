
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 반복되는 구조
        String[] map = new String[N];
        map[0] = "  *  ";
        map[1] = " * * ";
        map[2] = "*****";

        for (int k = 1; 3 * (int) Math.pow(2, k) <= N; k++) {
            star(map, k);
        }

        for (int i = 0; i < map.length; i++) {
            bw.write(map[i] + "\n");
        }


        bw.close();
    }

    public static void star(String[] map, int k) {
        int new_last = 3 * (int)Math.pow(2, k);
        int new_first = new_last / 2;
        int j=0;
        String space = "";

        for (int i = new_first; i < new_last; i++) {
            map[i] = map[j] + " " + map[j];
            j++;
        }

        for (int i = 0; i < new_first; i++) {
            space += " ";
        }

        for (int i = 0; i < new_first; i++) {
            map[i] = space + map[i] + space;
        }
    }

}