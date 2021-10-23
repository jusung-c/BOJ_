import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][2];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] sort = new int[7][2];
        for(int i=0; i<N; i++) {
            for(int grade = 1; grade <=6; grade++) {
                if(arr[i][1] == grade) {
                    if(arr[i][0] == 0) {
                        sort[grade][0]++;
                    } else {
                        sort[grade][1]++;
                    }
                }
            }
        }

//        for(int i=1; i<7; i++) {
//            bw.write(sort[i][0]+" "+sort[i][1]+"\n");
//        }
        int result = 0;

        for(int i=1; i<=6; i++) {
            if(sort[i][0] + sort[i][1] == 0) continue;
            result += sort[i][0]/K + sort[i][1]/K;
            if (sort[i][0]%K != 0) {
                result++;
            }
            if (sort[i][1]%K != 0) {
                result++;
            }
        }

        bw.write(result+" ");

        bw.close();
    }
}