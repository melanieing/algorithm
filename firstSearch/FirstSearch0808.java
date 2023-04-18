package inflearnAlgorithm.firstSearch;

import java.util.Scanner;

/**
 * 08-08. 수열 추측하기
 * 파스칼의 삼각형
 * 가장 윗줄에 있는 숫자를 구하는 프로그램
 * N : 가장 윗줄에 있는 숫자의 개수, F : 가장 밑줄에 있는 수
 * 답이 여러가지일 경우, 사전순으로 가장 앞에 오는 것을 출력
 * 입력
 * 4 16
 * 출력
 * 3 1 2 4
 */
public class FirstSearch0808 {

    static int n, f;
    static int[] b, p, ch;
    boolean flag = false;
    int[][] dy = new int[35][35];

    public void DFS(int level, int sum) {
        if (flag) { // 답을 구하면 flag=true되어 있음 -> 더이상 돌지 않도록
            return;
        }
        if (level == n) { // 순열 하나 완성될 때
            if (sum == f) {
                for (int x : p) {
                    System.out.print(x + " ");
                    flag = true;
                }
            }
        } else {
            for (int i = 1; i <= n; i++) { // 순열구하기
                if (ch[i] == 0) {
                    ch[i] = 1;
                    p[level] = i;
                    DFS(level + 1, sum + (p[level] * b[level]));
                    ch[i] = 0; // 순열은 back할 때 체크 풀어주기
                }
            }
        }
    }

    public int combinate(int n, int r) {
        if (dy[n][r] > 0) {
            return dy[n][r];
        }
        if (n == r || r == 0) {
            return 1;
        } else {
            return dy[n][r] = combinate(n-1, r-1) + combinate(n-1, r);
        }
    }

    public static void main(String[] args) {
        FirstSearch0808 main = new FirstSearch0808();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 가장 윗줄에 있는 숫자의 개수
        f = sc.nextInt(); // 가장 밑줄에 있는 숫자
        b = new int[n];
        p = new int[n];
        ch = new int[n+1]; // 인덱스는 1 ~ n까지 사용할 것이므로
        for (int i = 0; i < n; i++) {
            b[i] = main.combinate(n-1, i); // 순열 구하기
        }

        main.DFS(0,0);
    }
}
