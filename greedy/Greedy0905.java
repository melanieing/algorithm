package inflearnAlgorithm.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 09-05. 다익스트라 알고리즘 -> pq를 사용하면 logn으로 끝낼 수 있음
 * 가중치 방향그래프, 1번 정점에서 모든 정점으로의 최소 거리비용을 출력하는 프로그램
 * 경로가 없으면 impossible을 출력
 * 정점의 수 : 1 <= N <= 20, 간선의 수 : M
 * 연결정보, 거리비용(항상 양수!) 표시
 * 입력
 * 6 9
 * 1 2 12
 * 1 3 4
 * 2 1 2
 * 2 3 5
 * 2 5 5
 * 3 4 5
 * 4 2 2
 * 4 5 5
 * 6 4 5
 * 출력
 * 2 : 11
 * 3 : 4
 * 4 : 9
 * 5 : 14
 * 6 : impossible
 */
class Edge implements Comparable<Edge> {
    public int vertex;
    public int cost;

    public Edge(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}
public class Greedy0905 {

    static int n, m; // 정점 개수, 간선 개수
    static ArrayList<ArrayList<Edge>> graph;
    static int[] distance;

    public void solution(int v) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(v, 0));
        distance[v] = 0;

        while (!pq.isEmpty()) {
            Edge tmp = pq.poll(); // cost가 가장 작은 엣지가 나옴! (우선순위 큐니까)
            int now = tmp.vertex;
            int nowCost = tmp.cost;
            if (nowCost > distance[now]) { // 기존의 것보다 더 나쁜게 나왔는데 굳이 들어가서 볼 필요가 없으므로 끊어주기
                continue;
            }
            for (Edge ob : graph.get(now)) {
                if (distance[ob.vertex] > nowCost + ob.cost) {
                    distance[ob.vertex] = nowCost + ob.cost;
                    pq.offer(new Edge(ob.vertex, nowCost+ob.cost));
                }
            }
        }
    }
    public static void main(String[] args) {
        Greedy0905 main = new Greedy0905();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 정점 개수
        m = sc.nextInt(); // 간선 개수

        // 그래프 생성
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 거리 배열 생성
        distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // 그래프에 연결정보 채우기
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b, c));
        }

        main.solution(1);

        for (int i = 2; i <= n; i++) {
            if (distance[i] != Integer.MAX_VALUE) { // 갈 수 있으면
                System.out.println(i + " : " + distance[i]);
            } else { // 갈 수 없으면
                System.out.println(i + " : impossible");
            }
        }
    }
}
