package inflearnAlgorithm.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 06-02. 버블 정렬
 * N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램 (버블정렬 사용)
 * 입력
 * 6
 * 13 5 11 7 23 15
 * 출력
 * 5 7 11 13 15 23
 */
public class Sorting0602 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.stream(solution(n, arr)).forEach(i -> System.out.print(i + " "));
    }

    private static int[] solution(int n, int[] arr) {

        for (int i = 0; i < n - 1; i++) { // 첫 번째 ~ 마지막-1까지 기준
            for (int j = 0; j < n - i - 1; j++) { // 첫 번째 ~ 위치가 확정된 값들은 제외
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        return arr;
    }
}
