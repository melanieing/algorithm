package inflearnAlgorithm.array;

import java.util.Scanner;

/**
 * 02-09. 격자판 최대합
 * N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력
 * 입력
 * 5
 * 10 13 10 12 15
 * 12 39 30 23 11
 * 11 25 50 53 15
 * 19 27 29 37 27
 * 19 13 30 13 19
 * 출력
 * 155
 */
public class Array0209 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution1(n, arr));
//        System.out.println(solution2(n, arr));

    }

    public static int solution1(int n, int[][] arr) {
        int answer = 0;
        // 대각선은 이중 for문을 다 돌면서 더해야 하므로 밖으로 빼놓기
        int rdsum = 0; // 오른쪽으로 긋는 대각선
        int ldsum = 0; // 왼쪽으로 긋는 대각선

        for (int i = 0; i < n; i++) {
            int rsum = 0; // 행 합
            int csum = 0; // 열 합
            for (int j = 0; j < n; j++) {
                rsum += arr[i][j];
                csum += arr[j][i];
                if (i == j) {
                    rdsum += arr[i][j];
                }
                if (i + j == n-1) {
                    ldsum += arr[i][j];
                }
            }
            int tmp = Math.max(Math.max(rsum, csum), Math.max(rdsum, ldsum));
            if (tmp > answer) {
                answer = tmp;
            }
        }

        return answer;
    }

    public static int solution2(int n, int[][] arr){
        int answer = -2147000000;
        int sum1, sum2;

        // 가로합, 세로합 중 최댓값 구하기
        for(int i = 0; i < n; i++){
            sum1 = sum2 = 0;
            for(int j = 0; j < n; j++){
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }

        // 대각선 합 중 최댓값 구하기
        sum1 = sum2 = 0;
        for(int i = 0; i < n; i++){
            sum1 += arr[i][i];
            sum2 += arr[i][n-i-1];
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);

        return answer;
    }
}
