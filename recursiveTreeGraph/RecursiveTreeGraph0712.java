package inflearnAlgorithm.recursiveTreeGraph;

import java.util.Scanner;
/**
 * 07-12. 경로탐색(DFS)
 * 방향 그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가짓수를 출력
 * n : 정점의 수, m : 간선의 수
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
public class RecursiveTreeGraph0712 {

    static int n, m, answer = 0; // 정점의 수, 간선의 수, 경로의 가짓수
    static int[][] graph; // 그래프
    static int[] check; // 방문체크 배열 (한 번 방문한 노드는 다시 방문하면 안되므로 체크해야 함)

    public void DFS(int v) {
        if (v == n) { // 목표 정점까지 가면 가짓수 올리기
            answer++;
        } else {
            for (int i = 1; i <= n; i++) { // 정점의 개수만큼 돌기
                if (graph[v][i] == 1 && check[i] == 0) { // 갈 수 있고, 방문한 적 없다면
                    check[i] = 1; // 내려올 때 방문했다고 체크
                    DFS(i);
                    check[i] = 0; // 올라갈 때 체크 풀어주기
                }
            }
        }
    }

    public static void main(String[] args) {
        RecursiveTreeGraph0712 t = new RecursiveTreeGraph0712();

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n+1][n+1]; // 정점개수+1개만큼 그래프(행렬) 생성
        check = new int[n+1]; // 방문체크 배열 생성

        // 행렬 안에 간선 정보 채워주기
        for (int i = 0; i < m; i++) {
            int f = sc.nextInt();
            int b = sc.nextInt();
            graph[f][b] = 1;
        }

        check[1] = 1; // 출발점에 체크
        t.DFS(1);

        System.out.println(answer);
    }
}
