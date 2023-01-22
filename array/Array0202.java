package inflearnAlgorithm.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 02-02. 보이는 학생
 * N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력
 * 입력
 * 8
 * 130 135 148 140 145 150 150 153
 * 출력
 * 5
 */
public class Array0202 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //System.out.println(solution1(n, arr));
        System.out.println(solution2(n, arr));
    }

    public static int solution1(int n, int[] arr) {
        int cnt = 0;
        boolean[] flags = new boolean[n];
        Arrays.fill(flags,true);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] <= arr[j]) { // 앞에 있는 모든 키랑 다 비교하니까 비효율적
                    flags[i] = false;
                    break;
                }
            }
        }
        for (boolean b : flags) {
            if (b) cnt++;
        }
        return cnt;
    }

    public static int solution2(int n, int[] arr){
        int answer = 1, max = arr[0];
        for (int i = 1; i < n; i++){
            if (arr[i] > max) { // 최댓값이랑만 비교하면 됨
                max = arr[i];
                answer++;
            }
        }
        return answer;
    }
}
