package inflearnAlgorithm.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 10-05. 동전교환 (냅색 알고리즘)
 * 거스름돈을 가장 적은 수의 동전으로 교환해주기 위한 동전의 최수개수?
 * 동전의 종류의 개수 : 1 <= N <= 50
 * N개의 동전의 종류
 * 거슬러 줄 금액 : 1 <= M <= 500
 * 각 동전의 종류는 100원을 넘지 않음
 * 입력
 * 3
 * 1 2 5
 * 15
 * 출력
 * 3
 */
public class Dp1005 {

    static int n, m; // 동전의 종류의 개수, 거슬러 줄 금액
    static int[] dy;

    public static void main(String[] args) {
        Dp1005 main = new Dp1005();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 동전 종류 개수

        int[] arr = new int[n]; // 동전 담을 배열 생성
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        m = sc.nextInt(); // 거슬러 줄 금액

        dy = new int[m+1]; // m+1 개의 배열 생성

        System.out.println(main.solution(arr));

    }

    public int solution(int[] coin) {
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= m; j++) {
                dy[j] = Math.min(dy[j], dy[j - coin[i]] + 1);
            }
        }
        return dy[m];
    }
}
