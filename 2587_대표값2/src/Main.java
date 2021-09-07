import java.io.*;
import java.util.Arrays;

public class Main {
    private static int average(int[] arr) {
        int sum = 0;
        for (int i=0; i<5; i++) {
            sum += arr[i];
        }

        return sum/5;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[5];

        for(int i=0; i<5; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int average_value = average(arr);

        bw.write(average_value+"\n"+arr[arr.length/2]);
        bw.close();

    }
}
