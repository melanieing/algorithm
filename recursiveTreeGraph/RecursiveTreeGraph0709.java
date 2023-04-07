package inflearnAlgorithm.recursiveTreeGraph;

/**
 * 07-09. Tree 말단 노드까지의 가장 짧은 경로 (DFS)
 * 레벨 = 거쳐가는 간선의 개수, 원래는 BFS로 푸는 게 더 적절함
 * DFS로 풀려면 완전이진트리여야 함
 */
public class RecursiveTreeGraph0709 {

    Node root;

    public static void main(String[] args) {
        RecursiveTreeGraph0709 tree = new RecursiveTreeGraph0709();
        // 0 레벨
        tree.root = new Node(1);
        // 1 레벨
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        // 2 레벨
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        // 깊이우선탐색
        System.out.println(tree.DFS(0, tree.root));
    }

    public int DFS(int level, Node root) {
        if (root.lt == null && root.rt == null) { // 말단노드면 끝내기
            return level;
        } else { // 좌측과 우측 중에서 더 짧은 거리
            return Math.min(DFS(level+1, root.lt), DFS(level+1, root.rt));
        }
    }
}
