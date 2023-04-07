package inflearnAlgorithm.recursiveTreeGraph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 07-07. 이진트리 순회(넓이우선탐색, BFS)
 * 이진트리를 레벨탐색 하기
 * 입력
 * 7
 * 출력
 * 1 2 3 4 5 6 7
 */
public class RecursiveTreeGraph0707 {

    Node root;

    public static void main(String[] args) {
        // 트리구조 만들기
        RecursiveTreeGraph0707 tree = new RecursiveTreeGraph0707();
        // 0 레벨
        tree.root = new Node(1);
        // 1 레벨
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        // 2 레벨
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        // 넓이우선탐색
        tree.BFS(tree.root);
    }

    public void BFS(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int level = 0;

        while (!q.isEmpty()) {
            int len = q.size();
            System.out.print(level + " : ");
            for (int i = 0; i < len; i++) {
                Node cur = q.poll();
                System.out.print(cur.data + " ");
                // 현재 꺼낸 노드와 연결된 노드를 큐에 넣기
                if (cur.lt != null) {
                    q.add(cur.lt);
                }
                if (cur.rt != null) {
                    q.add(cur.rt);
                }
            }
            level++;
            System.out.println();
        }
    }


}
