package inflearnAlgorithm.sorting;

import java.util.*;

/**
 * 06-04. Least Recently Used
 * 캐시의 크기가 주어지고, 캐시가 비어있는 상태에서 N개의 작업을 CPU가 차례로 처리한다면 N개의 작업을 처리한 후
 * 캐시메모리의 상태를 가장 최근 사용된 작업부터 차례대로 출력하는 프로그램
 * 삽입정렬 활용
 * 입력
 * 5 9
 * 1 2 3 2 6 2 3 5 7
 * 출력
 * 7 5 3 2 6
 */
public class Sorting0604 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.stream(solution(n, m, arr)).forEach(i -> System.out.print(i + " "));
    }

    public static int[] solution(int size, int n, int[] arr) {
        int[] cache = new int[size]; // 캐시 만들어놓기

        for (int x : arr) {
            int pos = -1;
            for (int i = 0; i < size; i++) { // 캐시를 순회하면서 hit인지 찾기
                if (x == cache[i]) { // hit 라면
                    pos = i; // 위치 저장
                }
            }
            if (pos == -1) { // miss라면
                // 맨 뒤부터 당기기
                if (size - 1 >= 0) System.arraycopy(cache, 0, cache, 1, size - 1);
                // System.arraycopy(원본, 읽어올위치, 복사본, 넣을위치, 읽어올길이)
            } else{ // hit 처리
                // hit된 값부터 당기기
                System.arraycopy(cache, 0, cache, 1, pos);
            }
            cache[0] = x; // 현재 작업을 맨 앞에 넣어주기
        }
        return cache;
    }
}
