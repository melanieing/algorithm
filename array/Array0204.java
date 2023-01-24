package inflearnAlgorithm.array;

import java.util.Scanner;

/**
 * 02-04. 피보나치 수열
 * 1) 피보나치 수열을 출력
 * 2) 입력은 피보나치 수열의 총 항의 수
 * 입력
 * 10
 * 출력
 * 1 1 2 3 5 8 13 21 34 55
 */
public class Array0204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i : solution1(n)) {
            System.out.print(i + " ");
        }

        //solution2(n);
    }

    public static int[] solution1(int n) {
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;
        for (int i = 0; i < n-2; i++) {
            answer[i+2] = answer[i] + answer[i+1];
        }
        return answer;
    }

    public static void solution2(int n){
        int a = 1, b = 1, c;
        System.out.print(a + " " + b + " ");
        for(int i = 2; i < n; i++){
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }
}
