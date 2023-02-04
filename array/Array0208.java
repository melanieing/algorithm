package inflearnAlgorithm.array;

import java.util.*;

/**
 * 02-08. 등수구하기
 * N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력
 * 입력
 * 5
 * 87 89 92 100 76
 * 출력
 * 4 3 2 1 5
 */
public class Array0208 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        for (int i : solution(n, array)) {
            System.out.print(i + " ");
        }

    }

    public static int[] solution(int n, int[] array) {
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int level = 1; // 처음에는 1등으로 고정
            for (int j = 0; j < n; j++) {
                if (array[j] > array[i]) { // 점수가 더 높으면
                    level++; // 등수가 1 떨어짐
                }
            }
            answer[i] = level; // 최종적으로 확정된 등수 넣기
        }

        return answer;
    }
}
