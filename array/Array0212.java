package inflearnAlgorithm.array;

import java.util.Scanner;

/**
 * 02-12. 멘토링
 * M번의 수학 테스트, N명의 학생, 멘토는 멘티보다 항상 등수가 높아야 함
 * 짝을 만들 수 있는 조합 갯수
 * 입력
 * 4 3
 * 3 4 1 2
 * 4 3 2 1
 * 3 1 4 2
 * 출력
 * 3
 */
public class Array0212 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 학생 수
        int m = sc.nextInt(); // 수학 테스트 횟수
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, m, arr));

    }

    public static int solution(int n, int m, int[][] arr) {
        int answer = 0;

        for (int i = 1; i <= n; i++) { // 멘토 번호
            for (int j = 1; j <= n; j++) { // 멘티 번호
                int cnt = 0;
                for (int k = 0; k < m; k++) { // 수학 테스트 횟수 3
                    int psti = 0, pstj = 0;
                    for (int s = 0; s < n; s++) { // 등수 (총 4명일 경우 0, 1, 2, 3등) 4
                        if (arr[k][s] == i) {
                            psti = s;
                        }
                        if (arr[k][s] == j) {
                            pstj = s;
                        }
                    }
                    if (psti < pstj) {
                        cnt++;
                    }
                }
                if (cnt == m) { // 모든 테스트에서 (멘토, 멘티)가 가능하다면
                    answer++;
                }
            }
        }

        return answer;
    }

}
