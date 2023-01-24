package inflearnAlgorithm.array;

import java.util.Scanner;

/**
 * 02-05. 소수(에라토스테네스 체)
 * 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력
 * 입력
 * 20
 * 출력
 * 8
 */
public class Array0205 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }

    public static int solution(int n){
        int cnt = 0;
        int[] ch = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (ch[i] == 0) { // 소수일 경우 0
                cnt++;
                for (int j = i; j <= n; j = j + i) ch[j] = 1; // 소수가 아닐 경우 1
            }
        }
        return cnt;
    }
}
