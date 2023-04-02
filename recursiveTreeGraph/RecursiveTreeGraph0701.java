package inflearnAlgorithm.recursiveTreeGraph;

import java.util.Scanner;

/**
 * 07-01. 재귀함수
 * 자연수 n이 입력되면 재귀함수를 이용하여 1부터 n까지 출력하는 프로그램
 * 재귀함수는 스택 자료구조를 이용함
 * 입력
 * 3
 * 출력
 * 1 2 3
 */
public class RecursiveTreeGraph0701 {
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
            DFS(n-1);
            System.out.print(n + " "); // 여기서 출력하면 순서가 거꾸로 출력됨
        }
    }
}
