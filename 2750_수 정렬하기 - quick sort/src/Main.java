import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> datalist = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            datalist.add(Integer.parseInt(br.readLine()));
        }

        // QuickSort
        ArrayList<Integer> mergedList = QuickSort(datalist);
        for (int i = 0; i < mergedList.size(); i++) {
            System.out.println(mergedList.get(i));
        }
    }

    private static ArrayList<Integer> QuickSort(ArrayList<Integer> datalist) {
        ArrayList<Integer> mergedList = new ArrayList<>();

        if (datalist.size() <= 1) {
            return datalist;
        }

        // 기준점 pivot 설정
        Integer pivot = datalist.get(0);

        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        // pivot을 기준으로 왼쪽, 오른쪽 분류
        for (int i = 1; i < datalist.size(); i++) {
            if (datalist.get(i) > pivot) {
                rightArr.add(datalist.get(i));
            } else {
                leftArr.add(datalist.get(i));
            }
        }

        mergedList.addAll(QuickSort(leftArr));
        mergedList.addAll(Arrays.asList(pivot));
        mergedList.addAll(QuickSort(rightArr));

        return mergedList;
    }
}
