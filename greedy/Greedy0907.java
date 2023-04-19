package inflearnAlgorithm.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 09-07. 원더랜드(최소스패닝트리 : 크루스칼, Union&Find 활용)
 * 최소스패닝트리 : 그래프에서 간선의 가중치의 합이 최소인 트리를 뽑아내는 것
 * 그러려면 회로가 되면 안 됨! 어떻게 판단? find를 통해서!
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
class Edge2 implements Comparable<Edge2> {
    public int v1;
    public int v2;
    public int cost;

    public Edge2(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge2 o) {
        return this.cost - o.cost;
    }
}
public class Greedy0907 {

    static int[] unf;

    public static int find(int v) { // 같은 집합의 번호를 리턴받음
        if (v == unf[v]) {
            return v;
        } else {
            return unf[v] = find(unf[v]);
        }
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 학생 수
        int m = sc.nextInt(); // 숫자쌍의 개수
        // 학생수+1만큼 생성
        unf = new int[n+1];

        ArrayList<Edge2> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            arr.add(new Edge2(a, b, c));
        }

        int answer = 0;
        Collections.sort(arr);
        for (Edge2 ob : arr) {
            int fv1 = find(ob.v1);
            int fv2 = find(ob.v2);
            if (fv1 != fv2) {
                answer += ob.cost;
                union(ob.v1, ob.v2);
            }
        }

        System.out.println(answer);
    }
}
