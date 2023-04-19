package inflearnAlgorithm.greedy;

import java.util.Scanner;

/**
 * 09-06. 친구인가? (Disjoint-Set 서로소 : Union&Find)
 * 현수네 반 학생은 N명(1 <= N <= 1000), 각 학생들의 친구관계 표현한 숫자쌍(1 <= M <= 3000)
 * 특정 두 명이 친구인지를 판별하는 프로그램
 * 두 학생이 친구이면 "YES", 아니면 "NO"를 출력
 * 입력
 * 9 7
 * 1 2
 * 2 3
 * 3 4
 * 1 5
 * 6 7
 * 7 8
 * 8 9
 * 3 8
 * 출력
 * NO
 */
public class Greedy0906 {

    static int[] unf;

    public static int find(int v) { // 같은 집합의 번호를 리턴받음
        if (v == unf[v]) {
            return v;
        } else {
            return unf[v] = find(unf[v]);
        }
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 학생 수
        int m = sc.nextInt(); // 숫자쌍의 개수
        // 학생수+1만큼 생성
        unf = new int[n+1];

        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            union(a, b);
        }

        int a = sc.nextInt();
        int b = sc.nextInt();
        int fa = find(a);
        int fb = find(b);
        if (fa == fb) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
