import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> dataList = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        int[] arr = new int[N];
        int index = 1;

        boolean able = true;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            for (int j = index; j <= arr[i]; j++) {
                dataList.add(index++);
                result.add("+");
            }

            if (dataList.isEmpty()) {
                able = false;
            } else {
                for (int j = dataList.get(dataList.size()-1); j >= arr[i]; j--) {
                    dataList.remove(dataList.size() - 1);
                    result.add("-");
                    if (dataList.isEmpty()) {
                        break;
                    }
                }
            }
        }

        if (able) {
            for(String str: result) {
                bw.write(str+"\n");
            }
        } else {
            bw.write("NO"+" ");
        }

        bw.close();

    }
}
