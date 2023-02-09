package inflearnAlgorithm.slidingWindow;

import java.util.Scanner;

/**
 * 03-06. 최대 길이 연속부분수열
 * 0과 1로 구성된 길이 N의 수열에서 최대 k번의 변경을 통해 1로만 구성된 최대 길이의 연속부분수열을 찾기
 * 입력
 * 14 2
 * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
 * 출력
 * 8
 */
public class SlidingWindow0306 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution1(n, k, arr));

    }

    public static int solution1(int n, int k, int[] arr) {
        // rt는 증가하면서 0을 1로 바꾸고, lt는 증가하면서 rt가 바꾸어놓은 1을 0으로 돌려놓는다.
        int answer = 0, cnt = 0, lt = 0; // 창문의 좌측 포인터 초기화, cnt : 0을 1로 바꾼 횟수

        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) { // 0을 만나면 1로 바꾸기
                cnt++;
            }
            while (cnt > k) { // 바꿀 수 있는 최대 횟수 초과하면
                if (arr[lt] == 0) { // lt 이동하면서 1을 0으로 다시 바꿈
                    cnt--;
                }
                lt++; // 오른쪽으로 이동
            }
            answer = Math.max(answer, rt - lt + 1);
        }

        return answer;
    }

}
