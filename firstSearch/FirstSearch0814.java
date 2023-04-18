package inflearnAlgorithm.firstSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 08-14. 섬나라 아일랜드(BFS)
 * N * N의 섬나라 아일랜드 격자판 지도
 * 섬은 1로 표시, 상 하 좌 우 대각선 연결, 바다는 0으로 표시
 * 섬나라 아일랜드에 몇 개의 섬이 있는지 구하기
 * 입력
 * 7
 * 1 1 0 0 0 1 0
 * 0 1 1 0 1 1 0
 * 0 1 0 0 0 0 0
 * 0 0 0 1 0 1 1
 * 1 1 0 1 1 0 0
 * 1 0 0 0 1 0 0
 * 1 0 1 0 1 0 0
 * 출력
 * 5
 */
public class FirstSearch0814 {
    static int answer = 0, n;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public void BFS(int x, int y, int[][] board) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y)); // 첫 번째 위치를 큐에 넣기
        while (!q.isEmpty()) {
            Point pos = q.poll(); // 하나 뽑아서
            for (int i = 0; i < 8; i++) { // 8방향으로 탐색
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) { // 육지라면
                    board[nx][ny] = 0;
                    q.add(new Point(nx, ny));
                }
            }
        }
    }
    public void solution(int[][] board) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    board[i][j] = 0; // 출발점을 바다로 바꿔놓고
                    BFS(i, j, board); // 넘기기
                }
            }
        }
    }

    public static void main(String[] args) {
        FirstSearch0814 main = new FirstSearch0814();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 가로세로 길이
        int[][] arr = new int[n][n]; // 섬나라 아일랜드

        // 입력받기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j< n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        main.solution(arr);
        System.out.println(answer);
    }
}
