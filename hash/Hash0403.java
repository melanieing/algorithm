package inflearnAlgorithm.hash;

import java.util.*;

/**
 * 04-03. 매출액의 종류
 * N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별 매출액의 종류를 출력하는 프로그램
 * 입력
 * 7 4
 * 20 12 20 10 23 17 10
 * 출력
 * 3 4 4 3
 */
public class Hash0403 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 시간 초과한 풀이
//        for (int i : solution1(n, k, arr)) {
//            System.out.print(i + " ");
//        }

        // 투 포인터, 슬라이딩 윈도우 활용
        for (int i : solution2(n, k, arr)) {
            System.out.print(i + " ");
        }
    }

    public static ArrayList<Integer> solution1(int n, int k, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i <= n - k; i++) {
            for (int j = i; j < i + k; j++) {
                set.add(arr[j]); // 중복없이 넣으면 종류별로 넣을 수 있음
            }
            answer.add(set.size()); // 개수를 출력
            set.clear();
        }

        return answer;
    }

    public static ArrayList<Integer> solution2(int n, int k, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        //  map에 (매출액의 종류, 개수) 넣어놓기
        for (int i = 0; i < k - 1; i++) { // 0 ~ k : window
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int lt = 0;
        for (int rt = k - 1; rt < n; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1); // rt 값 더하기
            answer.add(map.size()); // 창 안에 있는 종류 세기
            map.put(arr[lt], map.get(arr[lt]) - 1); // lt 값 빼기
            if (map.get(arr[lt]) == 0) { // 개수가 0인 종류는 개수에 포함되지 않도록 제거해주기
                map.remove(arr[lt]);
            }
            lt++; // 우측으로 이동
        }

        return answer;
    }
}
