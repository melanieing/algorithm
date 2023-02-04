package inflearnAlgorithm.array;

import java.util.Scanner;
/**
 * 02-07. 점수계산
 * 시험문제의 채점 결과가 주어졌을 때, 총 점수를 계산 (맞추면 1, 틀리면 0)
 * 입력
 * 10
 * 1 0 1 1 1 0 0 1 1 0
 * 출력
 * 10
 */
public class Array0207 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println(solution(n, array));
    }

    public static int solution(int n, int[] arr){
        int answer = 0, cnt = 0;
        for(int i = 0; i < n; i++) {
            if (arr[i] == 1) { // 답이 맞으면 cnt 올리고 answer에 합산
                cnt++;
                answer += cnt;
            } else { // 답이 틀리면 cnt를 0으로 초기화
                cnt = 0;
            }
        }
        return answer;
    }
}
