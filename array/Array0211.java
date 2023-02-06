package inflearnAlgorithm.array;

import java.util.Scanner;

/**
 * 02-11. 임시반장 정하기
 * 1 ~ 5학년까지 같은 반이었던 학생 수가 가장 많은 사람이 임시반장
 * 여러 명일 경우 그 중 가장 작은 번호 출력
 * 입력
 * 5
 * 2 3 1 7 3
 * 4 1 9 6 8
 * 5 5 2 4 4
 * 6 5 2 6 7
 * 8 4 2 2 2
 * 출력
 * 4
 */
public class Array0211 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n+1][6]; // 행 : 학생 수 만큼, 열 : 1 ~ 5학년까지
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, arr));

    }

    public static int solution(int n, int[][] arr) {
        int answer = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) { // 전체 학생 수만큼 돌기
            int cnt = 0;
            for (int j = 1; j <= n; j++) { // 자기 자신을 세어도 상관없음 공평하니까
                for (int k = 1; k <= 5; k++) { // 1 ~ 5학년까지 같은 반인 적 있었는지 확인
                    if (arr[i][k] == arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if (cnt > max) { // 최댓값 업데이트
                max = cnt;
                answer = i; // 최댓값을 만드는 학생 번호 업데이트
            }
        }
        return answer;
    }

}
