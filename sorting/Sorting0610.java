package inflearnAlgorithm.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 06-10. 마구간 정하기(결정알고리즘)
 * C마리의 말을 N개의 마구간에 배치했을 때 가장 가까운 두 말의 거리가 최대가 되는 그 최대값을 출력하는 프로그램
 * 입력
 * 5 3
 * 1 2 8 4 9
 * 출력
 * 3
 */
public class Sorting0610 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 말의 마릿수
        int c = sc.nextInt(); // 마구간 갯수
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(n, c, arr));
    }

    public static int count(int[] arr, int distance) {
        int cnt = 1;
        int ep = arr[0]; // end point (마지막 말의 위치)

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - ep >= distance) { // 현재 놓은 말 위치와 바로 앞의 말 위치 사이의 간격이 distance 이상일 때
                cnt++; // 놓을 수 있으므로 카운트 하나 증가
                ep = arr[i]; // end point 업데이트
            }
        }
        return cnt;
    }

    public static int solution(int n, int c, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);

        int lt = 1; // 말의 거리 최솟값
        int rt = arr[n-1]; // 말의 거리 최댓값

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) >= c) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        return answer;
    }
}
