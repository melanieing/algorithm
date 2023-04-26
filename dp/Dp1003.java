package inflearnAlgorithm.dp;

import java.util.Scanner;

/**
 * 10-03. 최대 부분 증가수열
 * N개의 자연수로 이루어진 수열 (3 <= N <= 1000)
 * 가장 길게 증가하는(작은 수에서 큰 수로) 원소들의 집합을 찾는 프로그램
 * 부분증가수열의 최대 길이 구하기
 * 입력
 * 8
 * 5 3 7 8 6 2 9 4
 * 출력
 * 4
 */
public class Dp1003 {

    static int[] dy;

    public static void main(String[] args) {
        Dp1003 main = new Dp1003();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 원소 개수
        int[] arr = new int[n]; // 원소 개수만큼 배열 생성
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(main.solution(n, arr));

    }

    public int solution(int n, int[] arr) {
        dy = new int[n];

        dy[0] = 1;
        int answer = dy[0]; // n이 1일 경우 처리

        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && dy[j] > max) {
                    max = dy[j];
                }
            }
            dy[i] = max + 1;
            answer = Math.max(answer, dy[i]);
        }
        return answer;
    }
}
