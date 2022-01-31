import java.util.ArrayList;
import java.util.Collections;

public class Heap {
    public ArrayList<Integer> heapArray = null;

    public Heap (Integer data) {
        heapArray = new ArrayList<Integer>();

        heapArray.add(null);
        heapArray.add(data);
    }

    // swqp해야 하는지 판단하는 메서드
    public boolean move_up(Integer inserted_idx) {
        // 루트 노드일 경우는 바꿀 필요 없으니 false 리턴
        if(inserted_idx <= 1) {
            return false;
        }

        // 부모 노드 인덱스 계산
        Integer parent_idx = inserted_idx / 2;


        // 삽입한 노드와 부모 노드의 값을 비교해서 크면 바꿔야 하니까 true, 작으면 false 리턴
        if (this.heapArray.get(inserted_idx) > this.heapArray.get(parent_idx)) {
            return true;
        } else {
            return false;
        }

    }

    public boolean insert(Integer data) {
        Integer inserted_idx, parent_idx;

        // 힙이 비어있는 경우
        if(heapArray == null) {
            heapArray = new ArrayList<Integer>();

            heapArray.add(null);
            heapArray.add(data);
            return true;
        }

        this.heapArray.add(data);

        // 맨 마지막에 들어간 데이터니까 인덱스는 힙의 size-1
        inserted_idx = this.heapArray.size()-1;

        // move_up 메서드로 바꿔야 하는 지 판단
        while(this.move_up(inserted_idx)) {
            parent_idx = inserted_idx / 2;
            Collections.swap(this.heapArray, inserted_idx, parent_idx);
            inserted_idx = parent_idx;
        }

        // 더 이상 swqp할 필요가 없으면 완성
        return true;
    }

    public boolean move_down(Integer popped_idx) {
        Integer left_child_popped_idx, right_child_popped_idx;

        left_child_popped_idx = popped_idx * 2;
        right_child_popped_idx = popped_idx * 2 + 1;

        // CASE 1 : 왼쪽 자식 노드도 없을 때 (= 왼쪽 자식 노드가 없을 때, 오른쪽 자식 노드는 있을 수가 없다)
        // 완전 이진 트리이기 때문에 사이즈보다 크다는 것은 없다는 뜻
        if(left_child_popped_idx >= this.heapArray.size()) {
            return false;

            // CASE 2 : 오른쪽 자식 노드만 없을 때 (= 왼쪽 자식 노드만 있을 때)
        } else if (right_child_popped_idx >= this.heapArray.size()) {
            // 왼쪽 자식 노드의 값이 더 클 때 (= swqp이 필요한 경우)
            if(this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                return true;
            } else {
                return false;
            }

            // CASE 3 : 왼쪽/오른쪽 자식 노드가 모두 있을 때
        } else {
            // 자식 노드끼리 값을 비교한 후 왼쪽이 더 크면
            if(this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx)) {

                // 왼쪽 자식 노드와 pop한 노드 값 비교
                if(this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                    return true;
                } else {
                    return false;
                }

                // 자식 노드끼리 값을 비교한 후 오른쪽이 더 크면
            } else {

                // 오른쪽 자식 노드와 pop한 노드 값 비교
                if(this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx)) {
                    return true;
                } else {
                    return false;
                }
            }

        }
    }


    public Integer pop() {
        // pop을 통해서 가져올 변수 값
        Integer returned_data;

        // move_down 체크 해야할 노드와 그 자식들
        Integer popped_idx, left_child_popped_idx, right_child_popped_idx;

        if(this.heapArray == null) {
            return null;
        } else {
            // 삭제할 루트 노드 returnded_data에 담기
            returned_data = this.heapArray.get(1);

            // 마지막 노드를 최상단 노드로 set
            this.heapArray.set(1, this.heapArray.get(this.heapArray.size()-1));

            // 마지막 노드 삭제
            this.heapArray.remove(this.heapArray.size()-1);

            popped_idx = 1;

            // move_down으로 자식 노드와 바꿀 필요가 있는 지 판단
            while(this.move_down(popped_idx)) {
                left_child_popped_idx = popped_idx * 2;
                right_child_popped_idx = popped_idx * 2 + 1;

                // CASE 2 : 오른쪽 자식 노드만 없을 때 (= 왼쪽 자식 노드만 있을 때)
                if(right_child_popped_idx >= this.heapArray.size()) {

                    // 왼쪽 자식 노드의 값이 더 클 때 (= swqp이 필요한 경우)
                    if(this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                        Collections.swap(this.heapArray, popped_idx, left_child_popped_idx);

                        // 체크할 인덱스 이동
                        popped_idx = left_child_popped_idx;
                    }

                    // CASE 3 : 왼쪽/오른쪽 자식 노드가 모두 있을 때
                } else {
                    // 자식 노드끼리 값을 비교한 후 왼쪽이 더 크면
                    if(this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx)) {

                        // 왼쪽 자식 노드와 pop한 노드 값 비교
                        if(this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                            Collections.swap(this.heapArray, popped_idx, left_child_popped_idx);

                            // 체크할 인덱스 이동
                            popped_idx = left_child_popped_idx;
                        }

                        // 자식 노드끼리 값을 비교한 후 오른쪽이 더 크면
                    } else {

                        // 오른쪽 자식 노드와 pop한 노드 값 비교
                        if(this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx)) {
                            Collections.swap(this.heapArray, popped_idx, right_child_popped_idx);

                            // 체크할 인덱스 이동
                            popped_idx = right_child_popped_idx;
                        }
                    }


                }

            }


            return returned_data;
        }
    }

    public static void main(String[] args) {
        Heap heapTest = new Heap(15);
        heapTest.insert(10);
        heapTest.insert(8);
        heapTest.insert(5);
        heapTest.insert(4);
        heapTest.insert(20);
        System.out.println(heapTest.heapArray);

        heapTest.pop();
        System.out.println(heapTest.heapArray);
    }

}