package inflearnAlgorithm.sorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 06-05. 중복 확인
 * 만약 N명의 학생들이 적어낸 숫자 중 중복된 숫자가 존재하면 D(duplication)를 출력하고,
 * N명이 모두 각자 다른 숫자를 적어냈다면 U(unique)를 출력하는 프로그램
 * 입력
 * 8
 * 20 25 52 30 39 33 43 33
 * 출력
 * D
 */
public class Sorting0605 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

//        System.out.println(solution1(n, arr));
        System.out.println(solution2(n, arr));
    }

    public static char solution1(int n, int[] arr) {
        char c = 'D';

        HashSet<Integer> set = new HashSet<>();
        for (int x : arr) {
            set.add(x);
        }
        if (arr.length == set.size()) { // 개수가 같다면 중복이 없다는 의미
            c = 'U';
        }

        return c;
    }

    public static String solution2(int n, int[] arr){
        String answer = "U";
        Arrays.sort(arr); // 정렬하기

        for (int i = 0; i < n-1; i++) {
            if (arr[i] == arr[i+1]) { // 양 옆을 비교해서 같다면 중복이므로
                answer = "D"; // 바꾸고 바로 출력
                break;
            }
        }
        return answer;
    }
}
