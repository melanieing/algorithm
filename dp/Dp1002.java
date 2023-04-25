package inflearnAlgorithm.dp;

import java.util.Scanner;

/**
 * 10-02. 돌다리 건너기
 * 개울은 N개의 돌로 다리를 만들어 놓아야 함 (3 <= N <= 35)
 * 한 번에 한 칸 또는 두 칸씩 건너뛰면서 돌다리를 건널 수 있음
 * 개울을 건너는 방법의 개수 구하기
 * 입력
 * 7
 * 출력
 * 34
 */
public class Dp1002 {

    static int[] dy; // 방법의 수 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Dp1002 main = new Dp1002();
        int n = sc.nextInt();
        dy = new int[n+2]; // 개울을 다 건너야 하므로 하나 더 많이 만들기

        System.out.println(main.solution(n));
    }

    public int solution(int n) {

        dy[1] = 1;
        dy[2] = 2;

        for (int i = 3; i <= n+1; i++) { // 개울을 다 건너도록 +1
            dy[i] = dy[i-2] + dy[i-1];
        }

        return dy[n+1];
    }
}
