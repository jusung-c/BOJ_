import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int[] arr = new int[3];
        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        arr[2] = Integer.parseInt(st.nextToken());

        // 개수 세기
        int[] cnt = new int[6];
        for (int i=0; i<3; i++) {
            cnt[arr[i]-1] +=1;
        }

        for (int i=0; i<6; i++) {
            if (cnt[i] == 3) {
                cnt[i] = 10000+((i+1)*1000);
            } else if (cnt[i] == 2) {
                cnt[i] = 1000+((i+1)*100);
            } else if (cnt[i] == 1){
                cnt[i] = (i+1)*100;
            }
        }

//        for (int i=0; i<6; i++) {
//            bw.write(cnt[i]+" ");
//        }

        int max = 0;
        for (int i=0; i<6; i++) {
            if (max < cnt[i]) {
                max = cnt[i];
            }
        }

        bw.write(max+"");

        bw.close();
    }
}
