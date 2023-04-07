package inflearnAlgorithm.recursiveTreeGraph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 07-10. Tree 말단 노드까지의 가장 짧은 경로 (BFS)
 * 레벨 = 거쳐가는 간선의 개수
 */
public class RecursiveTreeGraph0710 {

    Node root;

    public static void main(String[] args) {
        RecursiveTreeGraph0710 tree = new RecursiveTreeGraph0710();
        // 0 레벨
        tree.root = new Node(1);
        // 1 레벨
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        // 2 레벨
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        // 깊이우선탐색
        System.out.println(tree.BFS(tree.root));
    }

    public int BFS(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int level = 0;

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node cur = q.poll();
                if (cur.lt == null && cur.rt == null) { // 말단노드라면 끝내기
                    return level;
                }
                if (cur.lt != null) { // 좌측 자식노드가 있다면 큐에 넣기
                    q.offer(cur.lt);
                }
                if (cur.rt != null) { // 우측 좌식 노드가 있다면 큐에 넣기
                    q.offer(cur.rt);
                }

            }
            level++;
        }
        return 0;
    }
}
