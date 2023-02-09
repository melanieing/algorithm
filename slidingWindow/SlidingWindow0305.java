package inflearnAlgorithm.slidingWindow;

import java.util.Scanner;

/**
 * 03-05. 연속된 자연수의 합
 * 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력
 * 입력
 * 15
 * 출력
 * 3
 */
public class SlidingWindow0305 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

//        System.out.println(solution1(n));
        System.out.println(solution2(n)); // 좀 더 효율적인 방법
//        System.out.println(solution3(n)); // 수학적인 방법
    }

    public static int solution1(int n) {
        int answer = 0, sum = 0, lt = 0; // 창문의 좌측 포인터 초기화

        // 1 ~ n-1까지의 자연수를 담은 배열 만들기 (자연수만 들어오므로)
        int[] arr = new int[n];
        for (int i = 0; i < n-1; i++) {
            arr[i] = i+1;
        }

        for (int rt = 0; rt < n; rt++) { // 우측 포인터가 끝까지 이동하는 동안
            sum += arr[rt]; // 오른쪽으로 이동하면서 합산
            if (sum == n) { // 합이 n과 같으면 카운트 올리기
                answer++;
            }
            while (sum >= n) { // 합이 n보다 크거나 같을 동안 반복
                sum -= arr[lt++]; // 좌측 포인터 값을 빼고 이동***
                if (sum == n) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static int solution2(int n) {
        int answer = 0, sum = 0;

        int m = n / 2 + 1; // 연속된 자연수의 합이므로 그 이상까지 볼 필요는 없음***
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = i + 1;
        }

        int lt = 0;
        for (int rt = 0; rt < m; rt++) {
            sum += arr[rt];
            if (sum == n) {
                answer++;
            }
            while (sum >= n) {
                sum -= arr[lt++];
                if (sum == n) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static int solution3(int n) {
        int answer = 0, cnt = 1; // cnt는 연속된 자연수의 갯수
        n--; // n에서 1 빼놓기
        while (n > 0) {
            cnt++;
            n = n - cnt; // n에서 2, 3, 4, ... 빼놓기
            if (n % cnt == 0) { // 나누어 떨어지면
                answer++;
            }
        }
        return answer;
    }

}
