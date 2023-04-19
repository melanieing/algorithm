package inflearnAlgorithm.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 09-03. 결혼식
 * 결혼식 피로연 연속 3일, N명(5 <= N <= 100000)의 참석하는 시간정보(오는 시간, 가는 시간)
 * 피로연 장소에 동시에 존재하는 최대 인원수 구하기
 * 가는 시간을 먼저 카운팅해야 논리상 오류가 없음!!
 * 입력
 * 5
 * 14 18
 * 12 15
 * 15 20
 * 20 30
 * 5 14
 * 출력
 * 2
 */

class Info implements Comparable<Info> {
    public int time;
    public char state;

    public Info(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Info o) {
        if (this.time == o.time) { // 시간이 같으면 상태를 비교
            return this.state - o.state;
        } else { // 기본적으로 시간 비교
            return this.time - o.time;
        }
    }
}
class Greedy0903 {

    public int solution(ArrayList<Info> arr) {
        int answer = Integer.MIN_VALUE;

        Collections.sort(arr); // 시간상으로 오름차순, 알파벳으로는 e가 먼저!
        int cnt = 0; // 순간 동시인원 수
        for (Info o : arr) {
            if (o.state == 's') {
                cnt++;
            } else {
                cnt--;
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    public static void main(String[] args) {
        Greedy0903 main = new Greedy0903();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 인원수 받기

        ArrayList<Info> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) { // 시간정보 넣기
            int st = sc.nextInt();
            int et = sc.nextInt();
            arr.add(new Info(st, 's'));
            arr.add(new Info(et, 'e'));
        }

        System.out.println(main.solution(arr));
    }
}
