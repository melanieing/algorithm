package inflearnAlgorithm.stackQueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 05-03. 크레인 인형뽑기(카카오)
 * 만약 같은 모양의 인형 두 개가 바구니에 연속해서 쌓이게 되면 두 인형은 터뜨려지면서 바구니에서 사라지게 됨
 * 게임 화면의 격자의 상태가 담긴 2차원 배열 board, 인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열 moves
 * 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 구하는 프로그램
 * 입력
 * 5
 * 0 0 0 0 0
 * 0 0 1 0 3
 * 0 2 5 0 1
 * 4 2 4 4 2
 * 3 5 1 3 1
 * 8
 * 1 5 3 5 1 2 1 4
 * 출력
 * 4
 */
public class StackQueue0503 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j< n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = sc.nextInt();
        }

        System.out.println(solution(n, board, m, moves));
    }

    public static int solution(int n, int[][] board, int m, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int pos : moves) {
            for (int i = 0; i < n; i++) {
                if (board[i][pos-1] != 0) {
                    int tmp = board[i][pos-1];
                    board[i][pos-1] = 0;
                    if (!stack.isEmpty() && tmp == stack.peek()) { // 같은 종류의 인형이 스택 맨 위에 있다면
                        answer += 2; // 터지는 인형 2개 추가
                        stack.pop(); // 스택에서 하나 뽑기
                    } else { // 다른 종류의 인형이라면
                        stack.push(tmp); // 스택에 넣기
                    }
                    break; // 다음 위치로 이동
                }
            }
        }

        return answer;
    }
}
