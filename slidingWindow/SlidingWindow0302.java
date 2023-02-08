package inflearnAlgorithm.slidingWindow;

import java.util.*;

/**
 * 03-02. 공통원소 구하기
 * 두 집합의 공통원소를 추출하여 오름차순으로 출력
 * 입력
 * 5
 * 1 3 9 5 2
 * 5
 * 3 2 5 7 8
 * 출력
 * 2 3 5
 */
public class SlidingWindow0302 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 첫 번째 집합의 크기
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        int m = sc.nextInt(); // 두 번째 집합의 크기
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

//        for (int a : solution1(n, arr1, m, arr2)) { // 시간 초과
//            System.out.print(a + " ");
//        }

        for (int a : solution2(n, arr1, m, arr2)) { // 투 포인터 방식으로 해결
            System.out.print(a + " ");
        }

    }

    public static TreeSet<Integer> solution1(int n, int[] arr1, int m, int[] arr2) {

        TreeSet<Integer> set = new TreeSet<>(); // 자동으로 정렬되는 트리셋 사용
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr1[i] == arr2[j]) { // 공통으로 들어있는 값이라면 셋에 넣기 (중복제거됨)
                    set.add(arr1[i]);
                }
            }
        }

        return set;
    }

    public static ArrayList<Integer> solution2(int n, int[] arr1, int m, int[] arr2) {
        ArrayList<Integer> list = new ArrayList<>();

        // 1. 우선 정렬해놓기
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // 2. 투 포인터 만들고 비교하기
        int p1 = 0, p2 = 0;
        while (p1 < n && p2 < m) {
            if (arr1[p1] ==  arr2[p2]) { // 두 배열의 값이 같으면
                list.add(arr1[p1]); // 정답 리스트에 추가하기
                p1++; p2++; // 두 포인터 오른쪽으로 한 번 밀기
            } else if (arr1[p1] < arr2[p2]){ // arr1의 값이 더 작으면
                p1++; // 첫 번째 포인터 오른쪽으로 밀기
            } else { // arr2의 값이 더 작거나 같으면
                p2++; // 두 번째 포인터 오른쪽으로 밀기
            }
        }

        return list;
    }
}
