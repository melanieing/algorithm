package inflearnAlgorithm.firstSearch;

import java.util.Scanner;

/**
 * 08-01. 합이 같은 부분집합(DFS : 아마존 인터뷰)
 * N개의 원소로 구성된 자연수 집합 -> 두 개의 부분집합으로 나누었을 때
 * 두 부분집합의 원소의 합이 서로 같은 경우가 존재하면 "YES", 아니면 "NO"를 출력
 * 두 부분집합은 서로소 집합, 합하면 입력으로 주어진 원래의 집합이 됨
 * 1 <= N <= 10
 * 입력
 * 6
 * 1 3 5 6 7 10
 * 출력
 * YES
 */
public class FirstSearch0801 {

    static String answer = "NO"; // 기본적으로 넣어놓기
    static int n, total = 0; // 원소개수, 합
    boolean flag = false; // 존재한다면 표시할 플래그

    public void DFS(int L, int sum, int[] arr) {
        if (flag) { // 존재하면 바로 종료
            return;
        }
        if (sum > total / 2) { // 전체합의 1/2보다 부분합이 커졌다면 할 필요 없음
            return;
        }
        if (L == n) { // 마지막 레벨이라면
            if ((total - sum) == sum) { // 부분합이 같을 때
                answer = "YES";
                flag = true; // 플래그를 변경해놓기
            }
        } else { // 마지막 레벨이 아니라면
            DFS(L + 1, sum+arr[L], arr); // 왼쪽으로 뻗어나가기
            DFS(L + 1, sum, arr); // 오른쪽으로 뻗어나가기
        }
    }
    public static void main(String[] args) {
        FirstSearch0801 main = new FirstSearch0801();

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i]; // 총합 구해놓기
        }

        main.DFS(0, 0, arr);

        System.out.println(answer);
    }
}
