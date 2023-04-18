package inflearnAlgorithm.greedy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 09-02. 회의실 배정
 * 회의의 수(1<=n<=100000), 각 회의에 대해 시작시간(>=0)과 끝나는 시간
 * 각 회의가 겹치지 않게 회의실을 사용할 수 있는 최대수의 회의 구하기
 * 회의는 한 번 시작하면 중단 불가, 끝남과 동시에 시작 가능
 * -> 회의가 빨리 끝나는 것을 먼저 한다!
 * 입력 1
 * 5
 * 1 4
 * 2 3
 * 3 5
 * 4 6
 * 5 7
 * 출력 1
 * 3
 * 입력 2
 * 3
 * 3 3
 * 1 3
 * 2 3
 * 출력 2
 * 2
 */
class Time implements Comparable<Time> {
    public int s, e;

    Time(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Time o) {
        if (this.e == o.e) { // 끝나는 시간이 같으면 시작시간으로 비교
            return this.s - o.s;
        }
        return this.e - o.e; // 기본적으로 끝나는 시간으로 비교
    }
}
 class Greedy0902 {

    public int solution(ArrayList<Time> arr, int n) {
        int cnt = 0;

        // compareTo 메서드 기준에 따라 정렬
        Collections.sort(arr);

        int et = 0; // 현재 회의가 끝나는 시간
        for (Time ob : arr) {
            if (ob.s >= et) { // 현재 회의가 끝나는 시간보다 시작시간이 더 빠르거나 같으면
                cnt++; // 회의 가능
                et = ob.e; // 끝나는 시간에 업데이트해주기
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Greedy0902 main = new Greedy0902();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 회의의 수

        ArrayList<Time> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
           int x = sc.nextInt();
           int y = sc.nextInt();
           arr.add(new Time(x, y));
        }
        System.out.println(main.solution(arr, n));


    }
}
