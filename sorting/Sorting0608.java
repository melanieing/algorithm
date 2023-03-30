package inflearnAlgorithm.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 06-08. 이분검색
 * 이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램
 * 입력
 * 8 32
 * 23 87 65 12 57 32 99 81
 * 출력
 * 3
 */
public class Sorting0608 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(n, m, arr));
    }

    public static int solution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = 0, rt = n - 1; // 이분탐색을 위한 이중포인터 만들기

        // 1. 먼저 배열을 정렬하기
        Arrays.sort(arr);

        // 2. 이분탐색
        while (lt <= rt) {
            int mid = (lt+rt)/2;

            if (arr[mid] == m) {
                answer = mid + 1;
                break;
            }
            if (arr[mid] > m) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return answer;
    }
}
