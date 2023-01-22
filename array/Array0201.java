package inflearnAlgorithm.array;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 02-01. 큰 수 출력하기
 * N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력
 * 입력
 * 6
 * 7 3 9 5 6 12
 * 출력
 * 7 9 6 12
 */
public class Array0201 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        for (int i : solution(n, array)) {
            System.out.print(i + " ");
        }
    }

    public static ArrayList<Integer> solution(int n, int[] array) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(array[0]);
        for (int i = 1; i < n; i++) {
            if (array[i] > array[i-1]) {
                answer.add(array[i]);
            }
        }
        return answer;
    }
}
