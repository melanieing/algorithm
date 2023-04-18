package inflearnAlgorithm.firstSearch;

import java.util.Scanner;

/**
 * 08-09. 조합 구하기
 * 1 ~ N까지 번호가 적힌 구슬이 있음, M개를 뽑는 방법의 수를 출력
 * 3 <= N <= 10, 2 <= M <= N
 * 입력
 * 4 2
 * 출력
 * 1 2
 * 1 3
 * 1 4
 * 2 3
 * 2 4
 * 3 4
 */
public class FirstSearch0809 {
    static int[] combi;
    static int n, m;
    public void DFS(int level, int sum) {
        System.out.println("DFS(" + level + ", " + sum + ")");
        if (level == m) {
            for (int x : combi) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = sum; i <= n; i++) {
                combi[level] = i;
                DFS(level+1, i+1);
            }
        }
    }

    public static void main(String[] args) {
        FirstSearch0809 main = new FirstSearch0809();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 구슬의 가장 큰 번호
        m = sc.nextInt(); // 뽑을 개수
        combi = new int[m];

        main.DFS(0,1);
    }
}
