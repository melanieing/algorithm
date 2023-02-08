package inflearnAlgorithm.slidingWindow;

import java.util.Scanner;

/**
 * 03-03. 최대 매출
 * N일 동안의 매출기록, 연속된 K일 동안의 최대 매출액 구하기
 * 입력
 * 10 3
 * 12 15 11 20 25 10 20 19 13 15
 * 5
 * 3 2 5 7 8
 * 출력
 * 56
 */
public class SlidingWindow0303 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

//        System.out.println(solution1(n, k, arr)); // 시간 초과
        System.out.println(solution2(n, k, arr)); // 슬라이딩 윈도우 방식으로 해결
    }

    public static int solution1(int n, int k, int[] arr) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                if (j < n) {
                    sum += arr[j];
                }
            }
            if (sum > answer) {
                answer = sum;
            }
        }
        return answer;
    }

    public static int solution2(int n, int k, int[] arr) {
        int answer, sum = 0;
        // 미리 첫번째 window 안의 합을 구해서 answer에 넣어놓기
        for (int  i = 0; i < k; i++) {
            sum += arr[i];
        }
        answer = sum;

        // window를 슬라이딩하면서 합 구하기
        for (int i = k; i < n; i++) {
            sum += arr[i] - arr[i-k]; // 다음 값은 더하고 직전 window의 첫 번째 값은 빼기
            answer = Math.max(answer, sum);
        }
        return answer;
    }
}
