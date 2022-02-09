import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashSet<String> no_h = new HashSet<>();
        ArrayList<String> result = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            no_h.add(br.readLine());
        }

        for (int i = 1; i <= M; i++) {
            String k = br.readLine();

            if (no_h.contains(k)) {
                result.add(k);
            }
        }

        Collections.sort(result);

        bw.write(result.size()+"\n");
        for (String s : result) {
            bw.write(s+"\n");
        }



        bw.close();
    }

}