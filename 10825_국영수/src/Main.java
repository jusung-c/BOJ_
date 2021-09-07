import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        int N = Integer.parseInt(s1);

        for (int i=0; i<12; i++) {
            String s2 = br.readLine();
            StringTokenizer st = new StringTokenizer(s2, " ");

            String name = st.nextToken();
            int Lang = Integer.parseInt(st.nextToken());
            int En = Integer.parseInt(st.nextToken());
            int Math = Integer.parseInt(st.nextToken());
        }
    }
}
