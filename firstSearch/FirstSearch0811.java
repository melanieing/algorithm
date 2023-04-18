package inflearnAlgorithm.firstSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 08-11. 미로의 최단거리 통로(BFS)
 * 7*7 격자판 미로를 탈출하는 최단경로의 길이를 출력하는 프로그램
 * 경로의 길이 : 출발점에서 도착점까지 가는데 이동한 횟수
 * 출발점 : 격자의 (1, 1), 탈출점 : (7, 7)
 * 격자판의 1은 벽, 0은 도로, 움직임은 상화좌우로만
 * 입력
 * 0 0 0 0 0 0 0
 * 0 1 1 1 1 1 0
 * 0 0 0 1 0 0 0
 * 1 1 0 1 0 1 1
 * 1 1 0 1 0 0 0
 * 1 0 0 0 1 0 0
 * 1 0 1 0 0 0 0
 * 출력
 * 12
 */
public class FirstSearch0811 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board, distance;

    public void BFS(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        board[x][y] = 1; // 출발점 체크
        while (!q.isEmpty()) {
            Point tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i]; // 현재 x좌표
                int ny = tmp.y + dy[i]; // 현재 y좌표
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) { // 방문하지 않았다면
                    board[nx][ny] = 1; // 체크해서 벽 만들기
                    q.offer(new Point(nx, ny));
                    distance[nx][ny] = distance[tmp.x][tmp.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        FirstSearch0811 main = new FirstSearch0811();
        Scanner sc = new Scanner(System.in);
        board = new int[8][8];
        distance = new int[8][8];

        // 입력받기
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j<= 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        main.BFS(1,1);

        if (distance[7][7] == 0) { // 도착할 수 없으면
            System.out.println(-1);
        } else { // 도착할 수 있으면
            System.out.println(distance[7][7]);
        }
    }
}
