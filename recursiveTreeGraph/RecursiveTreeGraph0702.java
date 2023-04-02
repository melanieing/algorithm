package inflearnAlgorithm.recursiveTreeGraph;

import java.util.Scanner;

/**
 * 07-02. 재귀함수를 이용한 이진수 출력
 * 10진수 n이 입력되면 2진수로 변환하여 출력하는 프로그램 (재귀함수 이용)
 * 입력
 * 11
 * 출력
 * 1011
 */
public class RecursiveTreeGraph0702 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        solution(n);
    }

    public static void solution(int n) {
        DFS(n);
    }

    public static void DFS(int n) {
        if (n != 0) {
            DFS(n / 2); // n을 2로 나눈 몫으로 계속 업데이트
            System.out.print(n % 2);
        }
    }
}
