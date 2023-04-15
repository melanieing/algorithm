package inflearnAlgorithm.firstSearch;

import java.util.Scanner;

/**
 * 08-03. 최대점수 구하기(DFS)
 * 제한시간 M 안의 N개의 문제 중 최대점수를 얻도록 하기
 * 한 유형당 한 개만 풀 수 있음
 * 1 <= N <= 20, 20 <= M <= 300
 * 입력 (문제 수, 걸리는 시간)
 * 5 20
 * 10 5
 * 25 12
 * 15 8
 * 6 3
 * 7 4
 * 출력
 * 41
 */
public class FirstSearch0803 {

    static int answer = Integer.MIN_VALUE, n, m; // 최대점수, 문제 수, 제한 시간

    public void DFS(int level, int sum, int time, int[] scores, int[] times) { // 레벨, 부분점수합, 걸리는 시간,
        if (time > m) {
             return;
        }
        if (level == n) {
            answer = Math.max(answer, sum);
        } else {
            DFS(level+1, sum+scores[level], time+times[level], scores, times);
            DFS(level+1, sum, time, scores, times);
        }
    }

    public static void main(String[] args) {
        FirstSearch0803 main = new FirstSearch0803();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 문제 수
        m = sc.nextInt(); // 제한 시간

        int[] scores = new int[n];
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
            times[i] = sc.nextInt();
        }
        main.DFS(0, 0, 0, scores, times);

        System.out.println(answer);
    }
}
