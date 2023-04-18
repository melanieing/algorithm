package inflearnAlgorithm.firstSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 08-12. 토마토(BFS 활용)
 * 보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받음
 * 인접한 곳 : 왼쪽, 오른쪽, 앞, 뒤 (4방향)
 * 며칠이 지나면 다 익게 되는지, 최소 일수 구하기
 * M : 상자의 가로 칸의 수, N : 상자의 세로 칸의 수
 * 하나의 상자에 저장된 토마토들의 정보가 주어짐
 * 토마토가 모두 익지는 못하는 상황이면 -1 출력
 * 입력
 * 6 4
 * 0 0 -1 0 0 0
 * 0 0 1 0 -1 0
 * 0 0 -1 0 0 0
 * 0 0 0 0 -1 1
 * 출력
 * 4
 */
public class FirstSearch0812 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board, distance;
    static int n, m; // 가로, 세로
    static Queue<Point> q = new LinkedList<>();
    public void BFS() {
        while (!q.isEmpty()) {
            Point tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    q.offer(new Point(nx, ny));
                    distance[nx][ny] = distance[tmp.x][tmp.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        FirstSearch0812 main = new FirstSearch0812();
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt(); // 가로
        n = sc.nextInt(); // 세로
        board = new int[n][m];
        distance = new int[n][m];

        // 입력받기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j< m; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 1) {
                    q.offer(new Point(i, j));
                }
            }
        }

        main.BFS();

        boolean flag = true; // 전체가 익지 않을 수도 있으므로 체크하기 위한 플래그
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) { // BFS가 끝나고 났는데도 익지 않은 토마토가 있다면
                    flag = false;
                    break;
                }
            }
        }
        if (flag) { // 익지 않은 토마토가 없다면
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    answer = Math.max(answer, distance[i][j]); // 최댓값 뽑기
                }
            }
            System.out.println(answer);
        } else { // 익지 않은 토마토가 있다면
            System.out.println(-1);
        }
    }
}
