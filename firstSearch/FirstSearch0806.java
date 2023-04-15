package inflearnAlgorithm.firstSearch;

import java.util.Scanner;

/**
 * 08-06. 순열 구하기
 * 10 이하의 N개의 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법
 * 3 <= n <= 10, 2 <= m <= n
 * 입력 (n, m)
 * 3 2
 * 3 6 9
 * 출력
 * 3 6
 * 3 9
 * 6 3
 * 6 9
 * 9 3
 * 9 6
 */
public class FirstSearch0806 {

    static int[] pm, check, arr;
    static int n, m;

    public void DFS(int level) {
        if (level == m) {
            for (int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (check[i] == 0) {
                    check[i] = 1; // 방문 흔적 남기기
                    pm[level] = arr[i];
                    DFS(level + 1);
                    check[i] = 0; // 방문 흔적 지우기
                }
            }
        }
    }
    public static void main(String[] args) {
        FirstSearch0806 main = new FirstSearch0806();

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        check = new int[n];
        pm = new int[m];
        main.DFS(0);
    }
}
