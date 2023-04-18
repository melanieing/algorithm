package inflearnAlgorithm.firstSearch;

import java.util.Scanner;

/**
 * 08-10. 미로탐색(DFS)
 * 7*7 격자판 미로를 탈출하는 경로의 가지수를 출력
 * 출발점 : 격자의 (1, 1), 탈출점 : (7, 7)
 * 격자판의 1은 벽, 0은 통로, 움직임은 상화좌우로만
 * 입력
 * 0 0 0 0 0 0 0
 * 0 1 1 1 1 1 0
 * 0 0 0 1 0 0 0
 * 1 1 0 1 0 1 1
 * 1 1 0 0 0 0 1
 * 1 1 0 1 1 0 0
 * 1 0 0 0 0 0 0
 * 출력
 * 8
 */
public class FirstSearch0810 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static int answer = 0;

    public void DFS(int x, int y) {
        if (x == 7 && y == 7) { // 종착점에 오면 끝내고 pop
            answer++;
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) { // 미방문한 셀이라면
                    board[nx][ny] = 1; // 방문했다고 체크
                    DFS(nx, ny);
                    board[nx][ny] = 0; // back할 때 방문체크 풀어주기
                }
            }
        }
    }

    public static void main(String[] args) {
        FirstSearch0810 main = new FirstSearch0810();
        Scanner sc = new Scanner(System.in);
        board = new int[8][8];
        // 입력받기
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j<= 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        board[1][1] = 1;

        main.DFS(1,1);
        System.out.println(answer);
    }
}
