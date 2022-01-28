public class Main {
    public static void main(String[] args) {

    }

    public class IntAryQueue {
        private int max;    // 큐 용량
        private int num;    // 현재 쌓여있는 데이터의 수
        private int[] que;  // 큐 본체

        // 큐가 비어있는 경우 예외 처리
        public class EmptyIntAryQueueException extends RuntimeException {
            public EmptyIntAryQueueException() {
            }
        }

        // 큐가 가득찬 경우 예외 처리
        public class OverflowIntAryQueueException  extends RuntimeException {
            public OverflowIntAryQueueException () {
            }
        }

        // 생성자
        public IntAryQueue(int capacity) {
            num = 0;
            max = capacity;

            try{
                que = new int[max];
            } catch (OutOfMemoryError e){
                max = 0;
            }
        }

        // enqueue
        public int enque(int x) throws OverflowIntAryQueueException {
            if(num >= max){
                throw new OverflowIntAryQueueException();
            }
            que[num++] = x;
            return x;
        }

        // [1, 2, 3]

        // dequeue : 두 번째 이후의 모든 요소를 하나씩 앞쪽으로 shift
        public int deque() throws EmptyIntAryQueueException {
            if(num <= 0){
                throw new EmptyIntAryQueueException();
            }
            int x = que[0];
            for (int i = 0; i < num - 1; i++) {
                que[i] = que[i+1];
            }
            num--;
            return x;
        }

        // peek : 가장 위에 있는 항목 반환
        public int peek() throws EmptyIntAryQueueException {
            if(num <= 0){
                throw new EmptyIntAryQueueException();
            }

            return que[num-1];
        }

        // 큐에서 x를 검색하여 index(찾지 못하면 -1)를 반환
        public int indexOf(int x) throws EmptyIntAryQueueException {
            if(num <= 0){
                throw new EmptyIntAryQueueException();
            }

            for (int i = 0; i < num; i++) {
                if (que[i] == x) {
                    return i;
                }
            }

            return -1;
        }

        // 큐를 비움
        public void clear(){
            num = 0;
        }

        // 큐의 용량을 반환
        public int capacity() {
            return max;
        }

        // 큐에 쌓인 데이터 수를 반환
        public int size() {
            return num;
        }

        // 큐가 비어 있는가?
        public boolean isEmpty() {
            if (num <= 0) {
                return true;
            } else {
                return false;
            }
        }

        // 큐가 가득 찼는가?
        public boolean isFull() {
            if (num >= max) {
                return true;
            } else {
                return false;
            }
        }

        // 큐 안의 데이터를 머리 → 꼬리의 차례로 출력함
        public void dump() {
            if (num == 0) {
                System.out.println("큐가 비었어요.");
            } else {
                for (int i = 0; i < num; i++) {
                    System.out.print(que[i] + " ");
                }
                System.out.println();
            }
        }



    }
}
