package inflearnAlgorithm.firstSearch;

import java.util.Scanner;

/**
 * 08-04. 중복순열 구하기
 * 1 ~ n까지의 번호가 적힌 구슬, 중복을 허락하여 m번을 뽑아 나열
 * 3 <= N <= 10, 2 <= M <= n
 * 입력 (n, m)
 * 3 2
 * 출력
 * 1 1
 * 1 2
 * 1 3
 * 2 1
 * 2 2
 * 2 3
 * 3 1
 * 3 2
 * 3 3
 */
public class FirstSearch0804 {

    static int n, m; // 전체 번호의 수, 조합하는 개수
    static int[] arr;

    public void DFS(int level) {
        if (level == m) {
            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                arr[level] = i;
                DFS(level + 1);
            }
        }
    }
    public static void main(String[] args) {
        FirstSearch0804 main = new FirstSearch0804();

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 전체 번호의 수
        m = sc.nextInt(); // 조합하는 개수

        arr = new int[m]; // 조합개수만큼 배열 생성

        main.DFS(0);

    }
}
