package inflearnAlgorithm.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 09-08. 원더랜드(최소스패닝트리 : 프림, PriorityQueue 활용)
 * 최소스패닝트리 : 그래프에서 간선의 가중치의 합이 최소인 트리를 뽑아내는 것
 * 그러려면 회로가 되면 안 됨!
 * 원더랜드는 모든 도시를 서로 연결하면서 최소의 유지비용이 들도록 도로를 선택, 나머지 도로는 폐쇄
 * 도시의 개수 : 1 <= V <= 100
 * 도로의 개수 : 1 <= E <= 1000
 * A번 도시와 B번 도시가 유지비용이 C인 도로로 연결되어 있음
 * 입력
 * 9 12
 * 1 2 12
 * 1 9 25
 * 2 3 10
 * 2 8 17
 * 2 9 8
 * 3 4 18
 * 3 7 55
 * 4 5 44
 * 5 6 60
 * 5 7 38
 * 7 8 35
 * 8 9 15
 * 출력
 * 196
 */
class Edge3 implements Comparable<Edge3> {
    public int vex;
    public int cost;

    Edge3(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge3 o) {
        return this.cost - o.cost;
    }
}

class Greedy0908 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 학생 수
        int m = sc.nextInt(); // 숫자쌍의 개수

        ArrayList<ArrayList<Edge3>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] check = new int[n+1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge3(b, c));
            graph.get(b).add(new Edge3(a, c));
        }
        int answer = 0;
        PriorityQueue<Edge3> pq = new PriorityQueue<>();
        pq.offer(new Edge3(1, 0));

        while (!pq.isEmpty()) {
            Edge3 tmp = pq.poll();
            int ev = tmp.vex;
            if (check[ev] == 0) {
                check[ev] = 1;
                answer += tmp.cost;
                for (Edge3 ob : graph.get(ev)) {
                    if (check[ob.vex] == 0) {
                        pq.offer(new Edge3(ob.vex, ob.cost));
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
