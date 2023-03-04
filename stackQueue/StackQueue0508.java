package inflearnAlgorithm.stackQueue;

import java.util.*;

/**
 * 05-08. 응급실
 * N명의 대기목록 순서의 환자 위험도가 주어지면, 대기목록상의 M번째 환자는 몇 번째로 진료를 받는지 출력하는 프로그램
 * 입력
 * 5 2
 * 60 50 70 80 90
 * 출력
 * 3
 */
public class StackQueue0508 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(n, m, arr));
    }
    public static int solution(int n, int m, int[] arr){
        int answer = 0;
        Queue<Person> q = new LinkedList<>();
        for (int i = 0; i < n; i++) { // 대기목록상의 M번째는 대기목록의 제일 처음 환자를 0번째로 간주하여 표현하므로 0부터 시작
            q.offer(new Person(i, arr[i]));
        }

        while (!q.isEmpty()) {
            Person tmp = q.poll(); // 큐에서 하나 뽑기
            for (Person x : q) {
                if (x.priority > tmp.priority) { // 뒤의 사람들과 비교해서 그 우선순위가 밀리면
                    q.offer(tmp); // 다시 큐에 집어넣기
                    tmp = null;
                    break; // 비교 끝내기
                }
            }
            if (tmp != null) { // 밀리지 않았으면
                answer++; // 카운트 하나 올리기
                if (tmp.id == m) { // 찾는 순서의 환자라면
                    return answer; // 그대로 반환
                }
            }
        }
        return answer; // 가장 마지막 순서가 출력
    }

    static class Person {
        int id; // 순서
        int priority; // 우선순위

        public Person(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }

}
