import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[] Insert(int[] Array, int Index, int num) {
        for(int i=Array.length-1; i>Index; i--) {
            Array[i] = Array[i-1];
        }
        Array[Index] = num;
        return Array;
    }
    private static int[] Delete(int[] Array, int index) {
        int[] new_Array = new int[Array.length-1];
        int j = 0;
        for(int i=0; i<Array.length; i++) {
            if (i == index) continue;
            new_Array[j] = Array[i];
            j++;
        }

        return new_Array;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        System.out.print("배열의 길이 : ");
        int N = Integer.parseInt(br.readLine());

        System.out.print("배열의 원소 : ");
        int[] Array = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for(int i=0; i<N; i++) {
            Array[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print("삽입? or 삭제? : ");
        String s = br.readLine();
        if (s.equals("삽입")) {
            System.out.print("삽입할 인덱스와(0부터) 삽입할 원소 : ");
            st = new StringTokenizer(br.readLine()," ");

            int Index = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            int[] new_Array = Insert(Array, Index, num);

            for (int i=0; i<Array.length; i++) {
                bw.write(new_Array[i]+" ");
            }
        } else if (s.equals("삭제")) {
            System.out.print("삭제할 원소의 인덱스(0부터) : ");
            int Index = Integer.parseInt(br.readLine());

            int[] new_Array = Delete(Array, Index);

            for (int i=0; i<new_Array.length; i++) {
                bw.write(new_Array[i]+" ");
            }
        } else {
            bw.write("오류");
        }
        bw.close();
    }


}
