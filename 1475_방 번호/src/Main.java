import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 자릿수 찾기
        int cnt = 0;
        int num = N;

        while(num!=0) {
            num /= 10;
            cnt++;
        }

        // 각 자리 분리해서 배열에 넣기
        int[] arr = new int[cnt];

        for(int i=0; i<cnt; i++) {
            arr[i] = N % 10;
            N /= 10;
        }

//        for(int i=0; i<cnt; i++) {
//            bw.write(arr[i]+" ");
//        }
//
//        bw.write("\n");

        int[] arr_cnt = new int[10];

        for(int i=0; i<cnt; i++) {
            arr_cnt[arr[i]]++;
        }

        arr_cnt[6] = (arr_cnt[6]+arr_cnt[9]+1) / 2;

//        for(int i=0; i<10; i++) {
//            bw.write(arr_cnt[i]+" ");
//        }

        int max = -1;
        for(int i=0; i<9; i++) {
            if ( max < arr_cnt[i]){
                max = arr_cnt[i];
            }
        }

//        bw.write("\n");
        bw.write(max+" ");

        bw.close();
    }
}
