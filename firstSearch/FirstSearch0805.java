package inflearnAlgorithm.firstSearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 08-05. 동전 교환
 * 여러 단위의 동전들, 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는지 출력
 * 동전의 종류개수 : 1 <= n <= 12
 * 거슬러 줄 금액 : 1 <= m <= 500
 * 입력 (n, 동전의 종류, m)
 * 3
 * 1 2 5
 * 15
 * 출력
 * 3
 */
public class FirstSearch0805 {

    static int n, m; // 동전의 종류 개수, 거슬러 줄 금액
    static int answer = Integer.MAX_VALUE;

    public void DFS(int level, int sum, Integer[] arr) { // 사용된 동전의 개수, level개의 동전의 총합
        if (sum > m) { // m을 넘어가면 끝내기
            return;
        }
        if (level >= answer) { // answer보다 더 깊은 값은 볼 필요 없음
            return;
        }
        if (sum == m) { // 거슬러줄 금액이 됐다면
            answer = Math.min(answer, level);
        } else {
            for (int i = 0; i < n; i++) {
                DFS(level + 1, sum + arr[i], arr);
            }
        }
    }
    public static void main(String[] args) {
        FirstSearch0805 main = new FirstSearch0805();

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 동전의 종류 개수
        Integer[] arr = new Integer[n]; // 동전 종류만큼 배열 생성
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());

        m = sc.nextInt(); // 거슬러 줄 금액

        main.DFS(0, 0, arr);
        System.out.println(answer);

    }
}
