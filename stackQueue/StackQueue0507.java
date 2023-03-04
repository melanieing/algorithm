package inflearnAlgorithm.stackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 05-07. 교육과정 설계
 * 필수과목순서가 주어지면 현수가 짠 N개의 수업설계가 잘된 것이면 “YES", 잘못된 것이면 ”NO“를 출력하는 프로그램
 * 입력
 * CBA
 * CBDAGE
 * 출력
 * YES
 */
public class StackQueue0507 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String order = sc.next();
        String plan = sc.next();

//        System.out.println(solution1(order, plan));
        System.out.println(solution2(order, plan));
    }
    public static String solution1(String order, String plan) {
        String answer = "YES"; // 기본적으로 YES

        StringBuilder sb = new StringBuilder();
        for (char c : plan.toCharArray()) {
            if (order.contains(Character.toString(c))) { // 검증해야 하는 과목만 추출
                sb.append(c); // 새로운 스트링빌더에 담기
            }
        }

        if (!sb.toString().equals(order)) { // 순서가 틀리면 NO
            answer = "NO";
        }

        return answer;
    }

    public static String solution2(String need, String plan){
        String answer = "YES";

        Queue<Character> q = new LinkedList<>();
        for (char x : need.toCharArray()) { // 큐에 필수과목 순서대로 넣기
            q.offer(x);
        }

        for (char x : plan.toCharArray()) {
            if (q.contains(x)) { // 계획에 있는 필수과목이라면
                if (x != q.poll()) { // 필수과목 순서에 맞지 않는다면 NO
                    return "NO";
                }
            }
        }
        if (!q.isEmpty()) { // 큐가 비지 않았다면 NO
            return "NO";
        }

        return answer;
    }
}
