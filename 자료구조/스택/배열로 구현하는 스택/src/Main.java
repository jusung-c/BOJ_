import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> s = new Stack<Integer>();

        s.push(5);

        while(!s.empty()) {
            bw.write(s.peek()+" ");
            s.pop();
        }

        bw.close();
    }
}
