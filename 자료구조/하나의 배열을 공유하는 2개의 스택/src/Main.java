public class IntStackX {
    private int max ;
    private int ptr_A;
    private int ptr_B;
    private int[] stk;

    public enum AorB {
        StackA, StackB;
    }

    // 스택이 비어있는 경우 예외처리
    public class EmptyIntStackX2Exception() extends RuntimeException {
        public EmptyIntStackX2Exception() {

        };
    }


    // 스택이 가득 차있는 경우 예외처리
    public class OverflowIntStackX2Exception() extends RuntimeException {
        public OverflowIntStackX2Exception() {

        }
    }

    // 생성자

    public IntStackX(int capacity) {
        ptr_A = 0;
        ptr_B = capacity - 1;
        max = capacity;

        try {
            stk = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
            System.out.println("배열을 생성할 수 없습니다.");
        }

    }


    // 스택에 x를 푸시
    public int push(AorB ab, int x) throws OverflowIntStackX2Exception {
        // ptr_A >= ptr_B + 1의 경우 서로의 데이터에 침범하니까 예외처리
        if (ptr_A >= ptr_B + 1) {
            throw new OverflowIntStackX2Exception();
        }

        switch (ab) {
            case StackA:
                stk[ptr_A++] = x;
                break;

            case StackB:
                stk[ptr_B--] = x;
                break;
        }
        return x;
    }

    // 스택에서 데이터를 팝(꼭대기의 데이터를 꺼냄)
    public int pop(AorB ab) throws EmptyIntStackX2Exception {
        if (ptr_A <= 0 || ptr_B >= max - 1) {
            throw new EmptyIntStackX2Exception();
        }

        int x = 0;
        switch (ab) {
            case StackA:
                x = stk[ptr_A++];
                break;

            case StackB:
                x = stk[ptr_B--];
                break;
        }
        return x;
    }


    // 스택에서 데이터를 피크(꼭대기의 데이터를 살펴 봄)
    public int peek(AorB ab) throws EmptyIntStackX2Exception {
        if (ptr_A <= 0 || ptr_B >= max - 1) {
            throw new EmptyIntStackX2Exception();
        }

        int x = 0;
        switch (ab) {
            case StackA:
                x = stk[--ptr_A];
                break;

            case StackB:
                x = stk[++ptr_B];
                break;
        }
        return x;
    }


    // 스택에서 x를 검색하여 index(찾지 못하면 -1)를 반환
    public boolean indexOf(AorB ab, int x) {
        switch (ab) {
            case StackA:
                for (int i = ptr_A - 1; i >= 0; i--) {
                    if(stk[i] == x) {
                        return true;
                    }
                }
                break;

            case StackB:
                for (int i = ptr_B+1; i <= max-1; i++) {
                    if(stk[i] == x) {
                        return true;
                    }
                }
                break;
        }

        return false;
    }


    // 스택을 비움
    public void clear(AorB ab) {
        switch (ab) {
            case StackA:
                ptr_A = 0;
                break;

            case StackB:
                ptr_B = max - 1;
                break;
        }
    }


    // 스택의 용량을 반환 (A와 B의 합계)
    public int capacity() {
        return max;
    }

    // 스택에 쌓여있는 데이터 수를 반환
    public int size(AorB ab) {
        switch (ab) {
            case StackA:
                return ptr_A;
            case StackB:
                return max - ptr_B - 1;
        }

        return 0;
    }


    // 스택이 비어 있는가?
    public boolean isEmpty(AorB ab) {
        switch (ab) {
            case StackA:
                if (ptr_A <= 0) {
                    return true;
                }

            case StackB:
                if (ptr_B >= max - 1) {
                    return true;
                }
        }
        return false;
    }


    // 스택이 가득 찼는가?
    public boolean ifFull(AorB ab) {
        return ptr_A >= ptr_B + 1;
    }


    // 스택 안의 터이터를 바닥 → 꼭대기의 차례로 나타냄
    public void dump(AorB ab) {
        switch (ab) {
            case StackA:
                for (int i = 0; i < ptr_A; i++) {
                    System.out.print(stk[i]+" ");
                }
                System.out.println();
                break;

            case StackB:
                for (int i = max-1; i <ptr_B; i--) {
                    System.out.print(stk[i]+" ");
                }
                System.out.println();
                break;
        }
    }

}