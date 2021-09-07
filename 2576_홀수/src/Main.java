import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[7];

        for(int i=0; i<7; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;
        int min = 101;
        for(int i=0; i<7; i++) {
            if(arr[i] % 2 == 1) {
                sum += arr[i];

                if(min > arr[i]) {
                    min = arr[i];
                }
            }
        }
        if (min == 101) {
            bw.write("-1");
        } else {
            bw.write(sum+"\n"+min);
        }

        bw.close();

    }
}
