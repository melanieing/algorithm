package inflearnAlgorithm.array;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 02-06. 뒤집은 소수
 * N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력
 * 입력
 * 9
 * 32 55 62 20 250 370 200 30 100
 * 출력
 * 23 2 73 2 3
 */
public class Array0206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        //for (int i : solution1(n, array)) System.out.print(i + " ");
        for (int i : solution2(n, array)) System.out.print(i + " ");
    }

    public static boolean isPrime(int num){
        if (num == 1) return false; // 1은 소수가 아님
        for (int i = 2; i < num; i++){
            if (num % i == 0) return false; // 나누어 떨어지는 값이 있다면 소수가 아님
        }
        return true; // 없다면 소수
    }

    public static ArrayList<Integer> solution1(int n, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            int rev = 0; // 뒤집은 숫자가 담길 변수
            while (tmp > 0) {
                int t = tmp % 10; // 1의 자리 수 담기
                rev = rev * 10 + t;
                tmp = tmp / 10; // 아래 한 자리 자르기
            }
            if (isPrime(rev)) answer.add(rev);
        }
        return answer;
    }

    public static ArrayList<Integer> solution2(int n, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String tmp = String.valueOf(new StringBuilder(Integer.toString(arr[i])).reverse());
            int tmp2 = Integer.parseInt(tmp);
            if (isPrime(tmp2)) answer.add(tmp2);
        }
        return answer;
    }
}
