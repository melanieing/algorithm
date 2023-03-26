package inflearnAlgorithm.sorting;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 06-01. 선택 정렬
 * N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램 (선택정렬 사용)
 * 입력
 * 6
 * 13 5 11 7 23 15
 * 출력
 * 5 7 11 13 15 23
 */
public class Sorting0601 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.stream(solution(n, arr)).forEach(i -> System.out.print(i + " "));
    }

    private static int[] solution(int n, int[] arr) {

        for (int i = 0; i < n - 1; i++) { // 첫 번째 ~ 마지막-1 번째까지 기준
            int min = i; // 최솟값의 인덱스 저장
            for (int j = i + 1; j < n; j++) { // 기준 다음값 ~ 마지막까지 비교
                if (arr[j] < arr[min]) min = j; // 기준값이 더 크면 최솟값 인덱스에 비교인덱스 넣기
            }
            // 최솟값과 비굣값 자리바꾸기
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }

        return arr;
    }

}
