package inflearnAlgorithm.array;

import java.util.Scanner;

/**
 * 02-10. 봉우리
 * 각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역
 * 봉우리 지역이 몇 개 있는 지 알아내기
 * 입력
 * 5
 * 5 3 7 2 3
 * 3 7 1 6 1
 * 7 2 5 3 4
 * 4 3 6 4 1
 * 8 7 3 5 2
 * 출력
 * 10
 */
public class Array0210 {

    static int[] dx = {-1, 0, 1, 0}; // x좌표
    static int[] dy = {0, 1, 0, -1}; // y좌표

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 5
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

        // 배열 복사해놓기
        int[][] copyArr = new int[n+2][n+2];
        for (int i = 1; i <= n; i++) {
            System.arraycopy(arr[i-1], 0, copyArr[i], 1, n);
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                int tmp = copyArr[i][j];

                int a = copyArr[i-1][j]; // 상
                int b = copyArr[i+1][j]; // 하
                int c = copyArr[i][j-1]; // 좌
                int d = copyArr[i][j+1]; // 우

                if (tmp > a && tmp > b && tmp > c && tmp > d) { // 상하좌우 값보다 크면 봉우리
                    answer++;
                }
            }
        }

        return answer;
    }

    public static int solution2(int n, int[][] arr){
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k]; // x좌표 이동
                    int ny = j + dy[k]; // y좌표 이동
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] >= arr[i][j]){ // 상하좌우 중 하나라도 더 크면
                        flag = false;
                        break;
                    }
                }
                if(flag) answer++;
            }
        }
        return answer;
    }
}
