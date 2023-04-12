package inflearnAlgorithm.recursiveTreeGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 07-14. 그래프 최단거리(BFS)
 * 그래프에서 1번 정점에서 각 정점으로 가는 최소 이동 간선수를 차례대로 출력
 * 1 <= 정점의 수 <= 20
 * 입력
 * 6 9
 * 1 3
 * 1 4
 * 2 1
 * 2 5
 * 3 4
 * 4 5
 * 4 6
 * 6 2
 * 6 5
 * 출력
 * 2:3
 * 3:1
 * 4:1
 * 5:2
 * 6:2
 */
public class RecursiveTreeGraph0714 {

    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] check, distance;

    public void BFS(int v) {
        check[v] = 1;
        distance[v] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v); // 1번 정점 넣기

        while (!queue.isEmpty()) { // 큐가 비면 멈추기
            int cv = queue.poll(); // 현재 정점 꺼내기
            for (int nv : graph.get(cv)) {
                if (check[nv] == 0) { // 방문한 적 없으면
                    check[nv] = 1; // 방문했다고 표시하기
                    queue.offer(nv); // 뒤에 넣기
                    distance[nv] = distance[cv] + 1; // 현재 정점까지의 거리에 1 더해주기
                }
            }
        }
    }

    public static void main(String[] args) {
        RecursiveTreeGraph0714 main = new RecursiveTreeGraph0714();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 정점의 수
        m = sc.nextInt(); // 간선의 수

        // 그래프 생성해서 담기
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 체크 배열, 거리 배열 생성하고 추가
        check = new int[n+1];
        distance = new int[n+1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        // 1번 정점에서 시작
        main.BFS(1);
        for (int i = 2; i <= n; i++) { // 1번 정점은 제외
            System.out.println(i + " : " + distance[i]);
        }
    }


}
