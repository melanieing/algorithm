package inflearnAlgorithm.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 10-06. 최대점수 구하기(냅색 알고리즘)
 * 문제의 개수 : 1 <= N <= 50
 * 제한 시간 : 10 <= M <= 300
 * 제한시간 M 안에 N개의 문제 풀이 중 얻을 수 있는 최대 점수 출력
 * 입력
 * 5 20
 * 10 5
 * 25 12
 * 15 8
 * 6 3
 * 7 4
 * 출력
 * 41
 */
public class Dp1006 {

    static int[] dy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 문제의 개수
        int m = sc.nextInt(); // 제한 시간

        int[] dy = new int[m+1]; // 제한시간+1만큼의 배열 생성
        for (int i = 0; i < n; i++) {
            int ps = sc.nextInt();
            int pt = sc.nextInt();
            for (int j = m; j >= pt; j--) {
                dy[j] = Math.max(dy[j], dy[j-pt] + ps);
            }
        }
        System.out.println(dy[m]); // m분이 주어졌을 때 최대점수

    }
}
