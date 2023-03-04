package inflearnAlgorithm.stackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 05-06. 공주 구하기
 * N과 K가 주어질 때 공주를 구하러 갈 왕자의 번호를 출력하는 프로그램
 * 입력
 * 8 3
 * 출력
 * 7
 */
public class StackQueue0506 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(solution(n, k));
    }
    public static int solution(int n, int k){
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        // 1. 큐에 1 ~ n까지 넣어주기
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        // 2. 한 개 남을 때까지 k번째 수 꺼내기
        while (!q.isEmpty()) {
            for (int i = 1; i < k; i++) { // k-1만큼 꺼내서 뒤에 넣기
                q.offer(q.poll());
            }
            q.poll(); // k번째 수 꺼내기
            if (q.size() == 1) { // 1개밖에 안 남았다면
                answer = q.poll(); // 그게 정답!
            }
        }

        return answer;
    }
}
