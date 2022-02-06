import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;



// 병합 정렬 : O(n log n)

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> dataList = new ArrayList<>();

        // dataList 받기
        for (int i = 0; i < N; i++) {
            dataList.add(Integer.parseInt(br.readLine()));
        }

        // Split - Merge
        ArrayList<Integer> mergedList = Split(dataList);

        for (int i = 0; i < mergedList.size(); i++) {
            System.out.println(mergedList.get(i));
        }

    }

    // 배열 끝까지 나누기
    private static ArrayList<Integer> Split(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }

        Integer mid = dataList.size() / 2;

        ArrayList<Integer> leftArr = new ArrayList<Integer>();
        ArrayList<Integer> rightArr = new ArrayList<Integer>();

        leftArr = Split(new ArrayList<Integer>(dataList.subList(0, mid)));
        rightArr = Split(new ArrayList<Integer>(dataList.subList(mid, dataList.size())));

        return Merge(leftArr, rightArr);
    }

    private static ArrayList<Integer> Merge(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> mergedList = new ArrayList<>();

        Integer l_Point = 0;
        Integer r_Point = 0;

        // CASE 1 : left/right 둘 다 있는 경우
        while (leftList.size() > l_Point && rightList.size() > r_Point) {
            if (leftList.get(l_Point) > rightList.get(r_Point)) {
                mergedList.add(rightList.get(r_Point));
                r_Point++;
            } else {
                mergedList.add(leftList.get(l_Point));
                l_Point++;
            }
        }

        // CASE 2 : right가 없는 경우 = left만 남은 경우
        while (leftList.size() > l_Point) {
            mergedList.add(leftList.get(l_Point));
            l_Point++;
        }

        // CASE 3 : left가 없는 경우 = right만 남은 경우
        while (rightList.size() > r_Point) {
            mergedList.add(rightList.get(r_Point));
            r_Point++;
        }

        return mergedList;
    }
}
