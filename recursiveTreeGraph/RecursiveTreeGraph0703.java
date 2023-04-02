package inflearnAlgorithm.recursiveTreeGraph;

import java.util.Scanner;

/**
 * 07-03. 팩토리얼
 * 자연수 n이 입력되면 n!을 구하는 프로그램
 * 입력
 * 5
 * 출력
 * 120
 */
public class RecursiveTreeGraph0703 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(DFS(n));
    }

    public static int DFS(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * DFS(n-1);
        }
    }
}
