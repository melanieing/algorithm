package inflearnAlgorithm.slidingWindow;

import java.util.Scanner;

/**
 * 03-04. 연속 부분수열
 * 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하기
 * 입력
 * 8 6
 * 1 2 1 3 1 1 1 2
 * 출력
 * 3
 */
public class SlidingWindow0304 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 수열 크기
        int m = sc.nextInt(); // 합

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(n, m, arr));
    }

    public static int solution(int n, int m, int[] arr) {
        int answer = 0, sum = 0, lt = 0; // 창문의 좌측과 우측 포인터 초기화

        for (int rt = 0; rt < n; rt++) { // 우측 포인터가 끝까지 이동하는 동안
            sum += arr[rt]; // 오른쪽으로 이동하면서 합산
            if (sum == m) { // 합이 m과 같으면 카운트 올리기
                answer++;
            }
            while (sum >= m) { // 합이 m보다 크거나 같을 동안 반복
                sum -= arr[lt++]; // 좌측 포인터 값을 빼고 이동***
                if (sum == m) {
                    answer++;
                }
            }
        }

        return answer;
    }

}
