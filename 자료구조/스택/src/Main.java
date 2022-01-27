import java.io.*;

class IntStack {
    int max;        // 스택에 쌓을 수 있는 최대 데이터 수
    int ptr;        // 스택에 쌓여 있는 데이터 수 -> 최상단 + 1
    int[] stk;      // 스택의 본체

    // 스택이 비어있는 경우 예외 처리
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() { }
    }

    // 스택이 가득 찬 경우 예외 처리
    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() { }
    }

    // 생성자
    public IntStack(int capacity) {
        ptr = 0;
        max = capacity;

        try {
            stk = new int[max];     // 스택 본체용 배열 생성
        } catch (OutOfMemoryError e) { // 생성 불가
            max = 0;
        }
    }

    // push 메서드 : 데이터 넣는 작업
    public int push(int x) throws OverflowIntStackException {

        // 스택이 가득 차있는 경우 예외처리
        if (ptr >= max) {
            throw new OverflowIntStackException();
        }

        // 스택 최상단에 x 추가하고 스택 포인터 증가
        return stk[ptr++] = x;
    }

    // pop 메서드 : 데이터 꺼내는 작업
    public int pop() throws EmptyIntStackException {

        // 스택이 비어있는 경우 예외처리
        if (ptr <= 0) {
            throw new EmptyIntStackException();
        }

        // 스택 포인터 감소 후 값 반환 -> 스택의 최상단 값
        return stk[--ptr];
    }

    // peek 메서드 : 스택 최상단 데이터 보기
    public int peek() throws EmptyIntStackException {

        // 스택이 비어있는 경우 예외처리
        if (ptr <= 0) {
            throw new EmptyIntStackException();
        }

        // 스택 최상단의 값 반환
        return stk[ptr - 1];
    }

    // indexOf 메서드 : 검색
    public int indexOf(int x) {
        // 최상단 값부터 검색
        for (int i = ptr - 1; i >= 0; i--) {
            if (stk[i] == x) {
                return i;
            }
        }

        return -1;
    }

    // capacity 메서드 : 용량을 확인하는 메서드 (max)
    public int capacity() {
        return max;
    }

    // clear 메서드 : 스택의 모든 요소를 삭제
    public void clear() {
       ptr = 0;
    }

    // size 메서드 : 데이터 수 확인 (ptr)
    public int size() {
        return ptr;
    }

    // isEmpty 메서드 : 스택이 비어있는 지 검사
    public boolean isEmpty() {
        if (ptr <= 0) {
            return true;
        } else {
            return false;
        }
    }


    // isFull 메서드 : 스택이 가득 찼는지 검사
    public boolean isFull() {
        if (ptr >= max) {
            return true;
        } else {
            return false;
        }
    }

    // dump 메서드 : 스택 안 모든 데이터 표시
    public void dump() {
        for (int i = 0; i < ptr; i++) {
            System.out.print(stk[i] + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 최대 64개 푸시할 수 있는 스택 객체 생성
        IntStack s = new IntStack(64);

        while (true) {
            System.out.println("현재 데이터 수 : " + s.size() + "/" + s.capacity());
            System.out.println("(1)push (2)pop (3)peek " +
                    "(4)dump (0)end ");

            // 원하는 작업 번호 받기
            int menu = Integer.parseInt(br.readLine());

            // (5) 종료
            if(menu == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            int x;
            switch (menu) {
                case 1:     // push
                    System.out.print("push할 데이터 : ");
                    x = Integer.parseInt(br.readLine());
                    try {
                        s.push(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2:     // pop
                    try {
                        x = s.pop();
                        System.out.println("pop한 데이터: " + x);
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 3:     // peek
                    try {
                        x = s.peek();
                        System.out.println("peek한 데이터: " + x);
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 4:     // dump
                    s.dump();
                    break;

                default:
                    System.out.println("잘못된 작업 번호입니다.");
            }

        }
    }

}