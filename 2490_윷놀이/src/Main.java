import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static String count(int arr[]) {
        int cnt = 0;
        for (int i=0; i<4; i++) {
            if (arr[i] == 1) {
                cnt += 1;
            }
        }

        if (cnt == 4) {
            return "E";
        } else if (cnt == 3) {
            return "A";
        } else if (cnt == 2) {
            return "B";
        } else if (cnt == 1) {
            return "C";
        } else if (cnt == 0) {
            return "D";
        }

        return null;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr1= new int[4];
        int[] arr2= new int[4];
        int[] arr3= new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<4; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<4; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<4; i++) {
            arr3[i] = Integer.parseInt(st.nextToken());
        }

        String result1 = count(arr1);
        String result2 = count(arr2);
        String result3 = count(arr3);

        bw.write(result1+"\n");
        bw.write(result2+"\n");
        bw.write(result3+"");

        bw.close();

    }
}
