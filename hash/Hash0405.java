package inflearnAlgorithm.hash;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 04-05. K번째 큰 수
 * 1 ~ 100 사이의 자연수가 적힌 N장의 카드 중 3장을 뽑아 기록한 값 중 K번째로 큰 수를 출력
 * 입력
 * 10 3
 * 13 15 34 23 45 65 33 11 26 42
 * 출력
 * 143
 */
public class Hash0405 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(n, k, arr));
    }

    public static int solution(int n, int k, int[] arr) {
        int answer = -1; // k번째 수가 존재하지 않으면 -1 출력

        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder()); // 내림차순으로 정렬

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int l = j+1; l < n; l++) {
                    set.add(arr[i] + arr[j] + arr[l]); // 중복없이 조합될 수 있는 합을 저장
                }
            }
        }
        int cnt = 0;
        for (int s : set) {
            cnt++;
            if (cnt == k) { // k번째로 큰 수를 출력
                answer = s;
            }
        }

        return answer;
    }
}
