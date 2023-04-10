package inflearnAlgorithm.recursiveTreeGraph;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 07-13. 경로탐색(인접리스트, ArrayList)
 * 방향 그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가짓수를 출력
 * n : 정점의 수, m : 간선의 수
 * 정점의 개수가 아주 많아지면 메모리를 많이 씀, 시간복잡도도 큼 -> 이럴 때 인접리스트 사용
 * 입력
 * 5 9
 * 1 2
 * 1 3
 * 1 4
 * 2 1
 * 2 3
 * 2 5
 * 3 4
 * 4 2
 * 출력
 * 6
 */
public class RecursiveTreeGraph0713 {

    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] check;

    public void DFS(int v) {
        if (v == n) {
            answer++;
        } else {
            for (int nv : graph.get(v)) { // 각각의 ArrayList를 탐색
                if (check[nv] == 0) { // 방문한 적 없으면
                    check[nv] = 1; // 방문했다고 표시
                    DFS(nv);
                    check[nv] = 0; // 다시 풀어주기
                }
            }
        }

    }

    public static void main(String[] args) {
        RecursiveTreeGraph0713 t = new RecursiveTreeGraph0713();

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new ArrayList<>(); // 정점개수+1개만큼 그래프(리스트) 생성
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>()); // 객체 생성을 해줘야 함!
        }

        check = new int[n+1]; // 방문체크 배열 생성

        // 행렬 안에 간선 정보 채워주기
        for (int i = 0; i < m; i++) {
            int f = sc.nextInt();
            int b = sc.nextInt();
            graph.get(f).add(b); // ArrayList에 인덱스로 접근해서 추가
        }

        check[1] = 1; // 출발점에 체크
        t.DFS(1);

        System.out.println(answer);
    }
}
