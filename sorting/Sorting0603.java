package inflearnAlgorithm.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 06-03. 삽입 정렬
 * N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램 (삽입정렬 사용)
 * 올리고 비교하고 밀고 넣고
 * 입력
 * 6
 * 11 7 5 6 10 9
 * 출력
 * 5 6 7 9 10 11
 */
public class Sorting0603 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.stream(solution1(n, arr)).forEach(i -> System.out.print(i + " "));
//        Arrays.stream(solution2(n, arr)).forEach(i -> System.out.print(i + " "));
    }

    public static int[] solution1(int n, int[] arr) {
        for (int i = 1; i < n; i++) { // 1 ~ n까지 반복
            int tmp = arr[i], j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                }
                else break;
            }
            arr[j + 1] = tmp;
        }
        return arr;
    }

    public static int[] solution2(int n, int[] arr) {
        for (int i = 1; i < n; i++) {
            int tmp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > tmp){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = tmp;
        }
        return arr;
    }

}
