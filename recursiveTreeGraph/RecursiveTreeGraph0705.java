package inflearnAlgorithm.recursiveTreeGraph;

/**
 * 07-05. 이진트리 순회(깊이우선탐색, DFS)
 * 이진트리를 종류별로 순회하는 프로그램
 * (1) 전위순회 : 부모 - 왼쪽 노드 - 오른쪽 노드
 * (2) 중위순회 : 왼쪽 노드 - 부모 - 오른쪽 노드
 * (3) 후위순회 : 왼쪽 노드 - 오른쪽 노드 - 부모 -> 병합정렬
 * 입력
 * 7
 * 출력
 * (1) 1 2 4 5 3 6 7
 * (2) 4 2 5 1 6 3 7
 * (3) 4 5 2 6 7 3 1
 */
public class RecursiveTreeGraph0705 {

    Node root;

    public static void main(String[] args) {
        // 트리구조 만들기
        RecursiveTreeGraph0705 tree = new RecursiveTreeGraph0705();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        // 탐색
        tree.DFS(tree.root);
    }

    static class Node {
        int data;
        Node lt, rt; // 왼쪽 자식의 노드 주소, 오른쪽 자식의 노드 주소

        public Node(int val) {
            data = val;
            lt = rt = null;
        }
    }

    public void DFS(Node root) {
        if (root != null) {
//            System.out.print(root.data + " "); // 전위순회
            DFS(root.lt);
//            System.out.print(root.data + " "); // 중위순회
            DFS(root.rt);
            System.out.print(root.data + " "); // 후위순회
        }

    }
}
