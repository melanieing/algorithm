package inflearnAlgorithm.recursiveTreeGraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 07-08. 송아지 찾기 1 (BFS)
 * 현수, 송아지의 위치가 수직선상의 좌표 점으로 주어짐
 * 현수가 앞으로 1, 뒤로 1, 앞으로 5만큼 이동해서 송아지의 위치로 이동
 * 최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 출력
 * 1 <= 좌표점 <= 10000
 * 0레벨 : 5 / 1레벨 : 6, 4, 10 / 2레벨 : 7, 11, 3, 9, 15 / 3레벨 : 8, 12, 16, 2, 8, 14 -> 멈춤
 * 입력
 * 5 14
 * 출력
 * 3
 */
public class RecursiveTreeGraph0708 {

    int answer = 0;
    int[] distance = {1, -1, 5};
    int[] check;
    Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt(); // 현수의 위치
        int e = sc.nextInt(); // 송아지의 위치
        RecursiveTreeGraph0708 main = new RecursiveTreeGraph0708();
        System.out.println(main.BFS(s, e));

    }

    public int BFS(int mover, int destination) {
        check = new int[10001];

        check[mover] = 1; // 현수의 현재 위치 표시
        q.offer(mover);
        int level = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int x = q.poll();
                for (int j = 0; j < 3; j++) { // 갈 수 있는 방법은 항상 3가지
                    int xc = x + distance[j];
                    if (xc == destination) { // x의 자식노드가 목적지라면 끝내기
                        return level+1;
                    }
                    if (xc >= 1 && xc <= 10000 && check[xc] == 0) { // 좌표 범위에 속하면서 방문하지 않은 원소
                        check[xc] = 1; // 방문했다고 표시
                        q.offer(xc); // 해당 원소를 큐에 넣어주기
                    }
                }

            }
            level++;
        }

        return 0;
    }
}
