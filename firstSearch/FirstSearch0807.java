package inflearnAlgorithm.firstSearch;

import java.util.Scanner;

/**
 * 08-07. 조합의 경우수(메모이제이션)
 * 재귀를 이용해 조합수를 구해주는 프로그램
 * 3 <= n <= 33, 0 <= r <= n
 * 입력 1 (n, r)
 * 5 3
 * 출력
 * 10
 * 입력 2 (n, r)
 * 33 19
 * 출력
 * 818809200
 */
public class FirstSearch0807 {

    int[][] dy = new int[35][35];

    public int DFS(int n, int r) {
        if (dy[n][r] > 0) {
            return dy[n][r];
        }
        if (n == r || r == 0) {
            return 1;
        } else {
            return dy[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
        }
    }
    public static void main(String[] args) {
        FirstSearch0807 main = new FirstSearch0807();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();

        System.out.println(main.DFS(n, r));
    }
}
