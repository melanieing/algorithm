package inflearnAlgorithm.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 09-04. 최대 수입 스케쥴(PriorityQueue 응용문제)
 * N개의 기업, D일 동안 강연, M만큼의 강연료
 * 가장 많은 돈을 벌 수 있도록 강연 스케줄 짜기
 * 하루에 하나의 기업에서만 강연 가능
 * 1 <= N <= 10000, 1 <= M <= 10000, 1 <= D <= 10000
 * 입력
 * 6
 * 50 2
 * 20 1
 * 40 2
 * 60 3
 * 30 3
 * 30 1
 * 출력
 * 150
 */
class Lecture implements Comparable<Lecture> {
    public int money, date; // 버는 돈, 일자

    public Lecture(int money, int date) {
        this.money = money;
        this.date = date;
    }

    @Override
    public int compareTo(Lecture o) { // 시간으로 비교
        return o.date - this.date; // 내림차순
    }
}
class Greedy0904 {

    static int n, max = Integer.MIN_VALUE;

    public int solution(ArrayList<Lecture> arr) {
        int answer = 0;
        // 우선순위 큐 생성하기(기본 : 작은값이 첫 번째, 여기서는 큰값이 첫 번째가 되도록 변경)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // 시간 내림차순으로 정렬
        Collections.sort(arr);

        int j = 0;
        for (int i = max; i >= 1; i--) { // 가장 큰 일수부터 1까지 내려옴
            for ( ; j < n; j++) {
                if (arr.get(j).date < i) {
                    break;
                }
                // 가장 큰 일수(i)보다 크거나 같을 때만 큐에 추가함
                pq.offer(arr.get(j).money);
            }
            if (!pq.isEmpty()) {
                answer += pq.poll(); // 강연들 중에 가장 강연료가 높은 걸 하겠다
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Greedy0904 main = new Greedy0904();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 기업 수
        ArrayList<Lecture> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int money = sc.nextInt(); // 강연료
            int date = sc.nextInt(); // 일 수
            arr.add(new Lecture(money, date));
            if (date > max) { // 일수 최댓값 구해놓기
                max = date;
            }
        }
        System.out.println(main.solution(arr));
    }
}
