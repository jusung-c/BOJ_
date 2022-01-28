import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

    }

    public static class ring_buffer_queue {
        private int max;    // 큐 용량
        private int num;    // 현재 쌓여있는 데이터의 수
        private int[] que;  // 큐 본체
        private int front;  // 첫 번째 요소 커서
        private int rear;   // 마지막 요소 커서

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
        public ring_buffer_queue(int capacity) {
            num = 0;
            front = 0;
            rear = 0;
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
            que[rear++] = x;
            num++;

            // rear == max의 경우 que[max] -> 큐 범위 초과
            if (rear == max) {
                // 링 버퍼 -> 원모양 큐 -> 다시 0으로 !
                rear = 0;
            }
            return x;
        }

        // [1, 2, 3]

        // dequeue
        public int deque() throws EmptyIntAryQueueException {
            if(num <= 0){
                throw new EmptyIntAryQueueException();
            }
            int x = que[0];
            num--;
            // front == max의 경우도 인덱스 초과 에러 발생
            if (front == max) {
                front = 0;
            }
            return x;
        }

        // peek : 가장 위에 있는 항목 반환
        public int peek() throws EmptyIntAryQueueException {
            if(num <= 0){
                throw new EmptyIntAryQueueException();
            }

            return que[front];
        }

        // 큐에서 x를 검색하여 index(찾지 못하면 -1)를 반환
        public int indexOf(int x) {
            for (int i = 0; i < num; i++) {
                // front에서 rear로 선형 검색
                int idx = (i + front) % max;
                if (que[idx] == x) {
                    return x;
                }
            }
            return -1;
        }

        // 큐를 비움
        public void clear(){
            num = 0;
            front = 0;
            rear = 0;
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
                    int idx = (i + front) % max;
                    System.out.print(que[idx] + " ");
                }
                System.out.println();
            }
        }

        // search : 큐 안에서 몇 번째에 있는 지 위치 반환
        public int search(int max) {
            for (int i = 0; i < num; i++) {
                int idx = (i + front) % max;
                if (que[idx] == idx) {
                    return i+1;
                }
            }
        }


    }
}
