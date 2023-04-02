package inflearnAlgorithm.recursiveTreeGraph;

import java.util.Scanner;

/**
 * 07-04. 피보나치 수열
 * 피보나치 수열 : 앞의 2개의 수를 합하여 다음 숫자가 되는 수열
 * 입력
 * 10 (피보나치 수열의 총 항의 수)
 * 출력
 * 1 1 2 3 5 8 13 21 34 55
 */
public class RecursiveTreeGraph0704 {

    static int[] fibo; // 방법 2,3

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        // 방법 1. 이렇게 하면 n이 커질수록 너무 오래걸림 (스택프레임 하나만 가지고 도니까 성능은 더 좋음)
//        for (int i = 1; i <= n; i++) {
//            System.out.print(DFS(i) + " ");
//        }

        // 방법 2. static 배열에 DFS(1) ~DFS(n)까지 저장해놓고 출력 (재귀는 스택프레임이 많이 쌓이므로 성능은 더 안 좋음)
        fibo = new int[n+1];
        DFS(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }

    }

    public static int DFS(int n) {
        // 방법 3. 이미 구한 값이면 중복해서 구하지 않도록 조건 추가 (memorization)
        if (fibo[n] > 0) {
            return fibo[n];
        }
        if (n == 1) {
//            return 1; // 방법 1
            return fibo[n] = 1; // 방법 2,3
        } else if (n == 2) {
//            return 1; // 방법 1
            return fibo[n] = 1; // 방법 2,3
        } else {
//            return DFS(n-2) + DFS(n-1); // 방법 1
            return fibo[n] = DFS(n-2) + DFS(n-1); // 방법 2,3
        }
    }
}
