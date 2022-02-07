import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    static ArrayList<String> arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = new ArrayList<>();
        ArrayList<Boolean> result = new ArrayList<>();

        while(true) {
            String s = br.readLine();

            if (s.charAt(0) == '.' && s.length() == 1) {
                break;
            }

            arr.add(s);
        }

        for (int i = 0; i < arr.size(); i++) {
            result.add(balance(arr.get(i)));

        }

        for (Boolean a : result) {
            if(a) {
                bw.write("yes" + "\n");
            } else {
                bw.write("no" + "\n");
            }
        }

        bw.close();
    }

    private static Boolean balance(String s) {
        Stack<Character> list = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if(c == '(' || c == '[' ){
                list.push(c);
            }

            else if (c == ')'){
                if(list.isEmpty()|| list.peek() != '(') {
                    return false;
                } else {
                    list.pop();
                }

            } else if (c == ']'){
                if(list.isEmpty()|| list.peek() != '[') {
                    return false;
                } else {
                    list.pop();
                }
            } else {
                continue;
            }
        }

        if (list.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}