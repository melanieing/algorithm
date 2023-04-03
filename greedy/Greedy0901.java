package inflearnAlgorithm.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 09-01. 씨름선수
 * A를 다른 모든 지원자와 일대일 비교해서 키와 몸무게 모두 A보다 높은 지원자가 존재하면 A탈락, 아니면 선발
 * N명의 지원자, 위의 선발원칙으로 최대 몇 명의 선수를 선발할 수 있는지 알아내는 프로그램
 * 입력
 * 5
 * 172 67
 * 183 65
 * 180 70
 * 170 72
 * 181 60
 * 출력
 * 3
 */
class Body implements Comparable<Body> {
    public int height, weight;

    Body(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Body o) { // height를 기준으로 내림차순 정렬
        return o.height - this.height;
    }
}

public class Greedy0901 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Body> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            arr.add(new Body(h, w));
        }

        System.out.println(solution(n, arr));
    }

    public static int solution(int n, ArrayList<Body> arr) {
        int answer = 0;

        Collections.sort(arr);      // 일단 키를 기준으로 내림차순 정렬해두기
        arr.forEach(i -> System.out.print(i + " "));
        int max = Integer.MIN_VALUE;
        for (Body ob : arr) {
            if (ob.weight > max) {  // 몸무게를 비교해서 최댓값일 때
                max = ob.weight;    // 업데이트
                answer++;           // 카운트
            }
        }

        return answer;
    }
}
