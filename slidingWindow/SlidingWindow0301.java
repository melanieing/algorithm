package inflearnAlgorithm.slidingWindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 03-01. 두 배열 합치기
 * 오름차순으로 정렬된 두 배열을 오름차순으로 합쳐 출력
 * 입력
 * 3
 * 1 3 5
 * 5
 * 2 3 6 7 9
 * 출력
 * 1 2 3 3 5 6 7 9
 */
public class SlidingWindow0301 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 첫 번째 배열의 크기
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        int m = sc.nextInt(); // 두 번째 배열의 크기
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

//        for (int a : solution1(n, arr1, m, arr2)) { // 시간 초과
//            System.out.print(a + " ");
//        }
        for (int a : solution2(n, m, arr1, arr2)) { // 투 포인터 방식으로 해결
            System.out.print(a + " ");
        }

    }

    public static int[] solution1(int n, int[] arr1, int m, int[] arr2) {

        // 리스트 생성하고 배열에 들어있는 값들 담기
        ArrayList<Integer> list = new ArrayList<>();
        for (int a : arr1) {
            list.add(a);
        }
        for (int b : arr2) {
            list.add(b);
        }

        // 정렬
        Collections.sort(list);

        // 정답 배열 생성하고 순서대로 담기
        int[] answer = new int[n+m];
        int size = 0;
        for (int b : list) {
            answer[size++] = b;
        }

        return answer;
    }

    public static ArrayList<Integer> solution2(int n, int m, int[] a, int[] b){

        ArrayList<Integer> answer = new ArrayList<>();
        // 1. 포인터 2개 만들기
        int p1 = 0, p2 = 0;

        // 2. 각 배열의 공통범위를 벗어나지 않는 한에서 오름차순으로 모으기
        while (p1 < n && p2 < m) {
            if (a[p1] < b[p2]) { // p1이 가리키는 값이 p2가 가리키는 값보다 작으면
                answer.add(a[p1++]); // p1 위치를 오른쪽으로 옮기기 (이미 정렬되어 있으므로)
            } else { // p2가 가리키는 값이 더크거나 같으면
                answer.add(b[p2++]); // p2 위치를 오른쪽으로 옮기기
            }
        }
        // 3. a에 남은 값들 넣기
        while (p1 < n) {
            answer.add(a[p1++]);
        }

        // 4. b에 남은 값들 넣기
        while (p2 < m) {
            answer.add(b[p2++]);
        }

        return answer;
    }
}
