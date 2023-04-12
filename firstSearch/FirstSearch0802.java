package inflearnAlgorithm.firstSearch;

import java.util.Scanner;

/**
 * 08-02. 바둑이 승차(DFS)
 * 트럭의 최대 적재용량 : Ckg (1 <= C <= 100000000)
 * N마리의 바둑이, 각 바둑이의 무게 W (1 <= N <= 30)
 * 철수가 트럭에 태울 수 있는 가장 무거운 무게를 구하기
 * 입력
 * 259 5
 * 81
 * 58
 * 42
 * 33
 * 61
 * 출력
 * 242
 */
public class FirstSearch0802 {

    static int answer = Integer.MIN_VALUE, c, n; // 태울 수 있는 최대무게, 최대적재용량, 마리 수

    public void DFS(int L, int sum, int[] arr) {
        if (sum > c) { // 부분합이 최대 적재용량을 넘어가면 더이상 진행 안 됨
            return;
        }
        if (L == n) { // 마지막 레벨이라면
            answer = Math.max(answer, sum); // 둘 중 큰 값으로 갱신
        } else {
            DFS(L + 1, sum + arr[L], arr);
            DFS(L + 1, sum, arr);
        }
    }

    public static void main(String[] args) {

        FirstSearch0802 main = new FirstSearch0802();

        Scanner sc = new Scanner(System.in);
        c = sc.nextInt(); // 최대무게
        n = sc.nextInt(); // 바둑이 수
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        main.DFS(0, 0, arr);

        System.out.println(answer);
    }
}
