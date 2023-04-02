package inflearnAlgorithm.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 06-09. 뮤직비디오(결정알고리즘)
 * 총 N개의 곡, 순서 유지, 총 M개의 DVD, DVD의 개수/크기 최소로
 * DVD의 최소 용량 크기 출력
 * 입력
 * 9 3
 * 1 2 3 4 5 6 7 8 9
 * 출력
 * 17
 */
public class Sorting0609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 사실 필요없음
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(m, arr));
    }

    public static int count(int[] arr, int capacity) {
        int cnt = 1; // 필요한 DVD 수
        int sum = 0; // 담긴 곡 수

        for (int x : arr) {
            if (sum + x > capacity) {
                cnt++;
                sum = x;
            } else {
                sum += x;
            }
        }
        return cnt;
    }

    public static int solution(int m, int[] arr) {
        int answer = 0;

        int lt = Arrays.stream(arr).max().getAsInt(); // 개별최댓값 (쪼개서 넣을 수 없으므로) -> 최솟값
        int rt = Arrays.stream(arr).sum(); // 합 (한 장에 모두 담을 수도 있으므로) -> 최댓값

        while (lt <= rt) {
            int mid = (lt + rt) / 2; // 중간값
            if (count(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return answer;
    }
}
