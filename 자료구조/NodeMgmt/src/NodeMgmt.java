import org.w3c.dom.Node;




public class NodeMgmt {
    Node head = null;

    public class Node {
        Node left;
        Node right;
        int value;

        public Node(int data) {
            this.value = data;
            this.left = null;
            this.right = null;
        }
    }

    public boolean insertNode(int data) {

        // CASE 1 : Node가 하나도 없을 때
        if (this.head == null) {
            // 헤드에 노드 삽입
            this.head = new Node(data);
        } else {
            // CASE 2 : Node가 하나 이상 들어가 있을 때
            Node findNode = this.head;
            while (true) {
                // CASE 2-1 : 현재 Node의 왼쪽에 Node가 들어가야 할 때
                if (data < findNode.value) {
                    // 이미 노드가 존재하는 경우
                    if (findNode.left != null) {
                        // 왼쪽 노드로 이동
                        findNode = findNode.left;
                    } else {
                        // 노드가 없으면 생성해서 삽입
                        findNode.left = new Node(data);
                        break;
                    }
                } else {
                    // CASE 2-2 : 현재 Node의 오른쪽에 Node가 들어가야 할 때
                    if (findNode.right != null) {
                        // 오른쪽 노드로 이동
                        findNode = findNode.right;
                    } else {
                        findNode.right = new Node(data);
                        break;
                    }
                }
            }
        }

        return true;
    }

    public Node search(int data) {
        // CASE 1 : Node가 하나도 없을 때
        if (this.head == null) {
            return null;
        } else {
            // CASE 2 : Node가 하나 이상 있을 때
            Node findNode = this.head;
            while (findNode != null) {
                // CASE 2-1 : Node를 찾은 경우
                if (findNode.value == data) {
                    return findNode;

                    // CASE 2-2 : data가 더 작을 때
                } else if (data < findNode.value) {
                    findNode = findNode.left;

                    // CASE 2-3 : data가 더 클 때
                } else {
                    findNode = findNode.right;

                }
            }

            return null;
        }
    }

    public boolean delete(int value) {
        boolean searched = false;

        // 삭제할 노드의 부모 노드
        Node currParentNode = this.head;

        // 삭제할 노드
        Node currNode = this.head;

        // 예외 케이스 1 : Node가 하나도 없을 때
        if (this.head == null) {
            return false;
        } else {
            // 예외 케이스 2 : Node가 하나만 있고 해당 노드가 삭제할 노드일 때
            if (this.head.value == value && this.head.left == null && this.head.right == null) {
                this.head = null;
                return true;
            }


            while (currNode != null) {
                if (currNode.value == value) {
                    searched = true;
                    break;
                } else if (value < currNode.value) {
                    currParentNode = currNode;
                    currNode = currParentNode.left;
                } else {
                    currParentNode = currNode;
                    currNode = currParentNode.right;
                }
            }

            //
            if (searched == false) {
                return false;
            }
        }

        // 여기까지 실행되면
        // searched : true,
        // currNode : 삭제할 노드인 경우만 남음

        // CASE 1 : 삭제할 노드가 Leaf Node인 경우
        if (currNode.left == null && currNode.right == null) {
            if (value < currParentNode.value) {
                currParentNode.left = null;
                currNode = null;
            } else {
                currParentNode.right = null;
                currNode = null;
            }
            return true;


            // Case 2-1 : 삭제할 Node가 Child Node를 한 개 가지고 있을 경우 (왼쪽)
        } else if (currNode.left != null && currNode.right == null) {
            // 삭제할 노드가 왼쪽에 있는 경우
            if (value < currParentNode.value) {
                currParentNode.left = currNode.left;
                currNode = null;

                // 삭제할 노드가 오른쪽에 있는 경우
            } else {
                currParentNode.right = currNode.left;
                currNode = null;
            }
            return true;

            // Case 2-2 : 삭제할 Node가 Child Node를 한 개 가지고 있을 경우 (오른쪽)
        } else if (currNode.left == null && currNode.right != null) {
            // 삭제할 노드가 왼쪽에 있는 경우
            if (value < currParentNode.value) {
                currParentNode.left = currNode.right;
                currNode = null;

                // 삭제할 노드가 오른쪽에 있는 경우
            } else {
                currParentNode.right = currNode.right;
                currNode = null;
            }

            return true;

            // Case 3-1 : 삭제할 노드가 Child 노드를 2개 가지고 있고,
            // 삭제할 노드가 부모 노드의 왼쪽에 있을 때
        } else {
            // 삭제할 노드가 부모 노드의 왼쪽에 있을 때
            if (value < currParentNode.value) {

                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;

                while (changeNode.left != null) {
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }

                // 여기까지 실행되면 changeNode에는 삭제할 Node의 오른쪽 Node 중에서
                // 가장 작은 값을 가진 Node가 들어가 있다.

                // Case 3-1-2 : changeNode의 오른쪽 자식 노드가 있을 경우 (오른쪽만 가능)
                if (changeNode.right != null) {
                    changeParentNode.left = changeNode.right;

                    // Case 3-1-1 : changeNode의 자식 노드가 없는 경우
                } else {
                    changeParentNode.left = null;
                }

                // currParentNode의 왼쪽 노드로 changenode를 지정한다.
                currParentNode.left = changeNode;

                // 삭제한 노드의 왼쪽/오른쪽 자식들을 바꾼 노드의 왼쪽/오른쪽 자식으로 지정
                changeNode.left = currNode.left;
                changeNode.right = currNode.right;

                currNode = null;

                // Case 3-2 : 삭제할 노드가 Child 노드를 2개 가지고 있고,
                // 삭제할 노드가 부모 노드의 오른쪽에 있을 때
            } else {
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;

                while (changeNode.left != null) {
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }

                // 여기까지 실행되면 changeNode에는 삭제할 Node의 오른쪽 Node 중에서
                // 가장 작은 값을 가진 Node가 들어가 있다.

                // Case 3-2-2 : changeNode의 오른쪽 자식 노드가 있을 경우 (오른쪽만 가능)
                if (changeNode.right != null) {
                    changeParentNode.left = changeNode.right;

                    // Case 3-2-1 : changeNode의 자식 노드가 없는 경우
                } else {
                    changeParentNode.left = null;
                }

                // currParentNode의 오른쪽 노드로 changenode를 지정한다.
                currParentNode.right = changeNode;

                // 삭제한 노드의 왼쪽/오른쪽 자식들을 바꾼 노드의 왼쪽/오른쪽 자식으로 지정
                changeNode.left = currNode.left;
                changeNode.right = currNode.right;

                currNode = null;
            }

            return true;


        }
    }

    public static void main(String[] args) {
        // Case3-1: 삭제할 Node가 Child Node를 두 개 가지고 있을 경우
        NodeMgmt myTree = new NodeMgmt();
        myTree.insertNode(10);
        myTree.insertNode(15);
        myTree.insertNode(13);
        myTree.insertNode(11);
        myTree.insertNode(14);
        myTree.insertNode(18);
        myTree.insertNode(16);
        myTree.insertNode(19);
        myTree.insertNode(17);
        myTree.insertNode(7);
        myTree.insertNode(8);
        myTree.insertNode(6);
        System.out.println(myTree.delete(15));
        System.out.println("HEAD: " + myTree.head.value);
        System.out.println("HEAD LEFT: " + myTree.head.left.value);
        System.out.println("HEAD LEFT LEFT: " + myTree.head.left.left.value);
        System.out.println("HEAD LEFT RIGHT: " + myTree.head.left.right.value);

        System.out.println("HEAD RIGHT: " + myTree.head.right.value);
        System.out.println("HEAD RIGHT LEFT: " + myTree.head.right.left.value);
        System.out.println("HEAD RIGHT RIGHT: " + myTree.head.right.right.value);

        System.out.println("HEAD RIGHT RIGHT LEFT: " + myTree.head.right.right.left.value);
        System.out.println("HEAD RIGHT RIGHT RIGHT: " + myTree.head.right.right.right.value);
    }


}
