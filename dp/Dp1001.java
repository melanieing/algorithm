package inflearnAlgorithm.dp;

import java.util.Scanner;

/**
 * 10-01. 계단오르기
 * 한 번에 한 계단 혹은 두 계단씩 올라가기
 * 총 N 계단 (3 <= N <= 35)일 때, 올라가는 방법의 수 구하기
 * 입력
 * 7
 * 출력
 * 21
 */
public class Dp1001 {

    static int[] dy; // 방법의 수 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Dp1001 main = new Dp1001();
        int n = sc.nextInt();
        dy = new int[n+1];
        System.out.println(main.solution(n));
    }

    public int solution(int n) {

        dy[1] = 1; // 계단이 하나일 때 방법의 수
        dy[2] = 2; // 계단이 둘일 때 방법의 수

        for (int i = 3; i <= n; i++) { // 계단이 셋 이상일 때
            dy[i] = dy[i-2] + dy[i-1];
        }

        return dy[n];
    }

}
