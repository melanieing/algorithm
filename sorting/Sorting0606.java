package inflearnAlgorithm.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 06-06. 장난꾸러기
 * 철수와 짝꿍이 자리를 바꾼 반 학생들의 일렬로 서있는 키 정보가 주어질 때
 * 철수가 받은 번호와 철수 짝꿍이 받은 번호를 차례로 출력하는 프로그램
 * 입력
 * 9
 * 120 125 152 130 135 135 143 127 160
 * 출력
 * 3 8
 */
public class Sorting0606 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.stream(solution(n, arr)).forEach(i -> System.out.print(i + " "));
    }

    public static int[] solution(int n, int[] arr) {
        int[] answer = new int[2];
        int cnt = 0;

        // 원본 배열 복제해놓기
        int[] copyArr = new int[n];
        System.arraycopy(arr, 0, copyArr, 0, n);
        // 원본배열 정렬
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if (arr[i] != copyArr[i]) { // 앞에서부터 탐색했을 때 다르다면 순서를 바꾼 것
                answer[cnt] = i+1; // 1을 더해 주어야 함
                cnt++;
            }
        }

        return answer;
    }
}
