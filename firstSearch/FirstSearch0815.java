package inflearnAlgorithm.firstSearch;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 08-15. 피자 배달 거리(삼성 SW역량평가 기출문제:DFS활용)
 * N * N의 도시지도, 1x1 크기의 격자칸
 * 0 : 빈칸, 1 : 집, 2 : 피자집
 * 1<= (행번호, 열번호) <= N
 * 2 <= N <= 50, 1 <= M <= 12
 * 집의 피자배달거리 : 해당 집과 도시의 존재하는 피자집들과의 거리 중 최솟값
 * 도시의 피자배달거리 : 각 집들의 피자 배달 거리를 합한 것
 * 피자집 M개만 살리고 나머지는 폐업, 도시의 피자배달거리가 최소가 되는 M개의 피자집 선택
 * 입력
 * 4 4
 * 0 1 2 0
 * 1 0 2 1
 * 0 2 1 2
 * 2 0 1 2
 * 출력
 * 6
 */
public class FirstSearch0815 {
    static int n, m, len, answer = Integer.MAX_VALUE;
    static int[] combination;
    static ArrayList<Point> hs, pz; // 집, 피자집

    public void DFS(int level, int start) {
        if (level == m) {
            int sum = 0;
            for (Point h : hs) {
                int dis = Integer.MAX_VALUE; // 거리 최솟값
                for (int i : combination) {
                    dis = Math.min(dis, Math.abs(h.x - pz.get(i).x) + Math.abs(h.y - pz.get(i).y)); // 이 집의 피자배달거리
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        } else {
            for (int i = start; i < len; i++) {
                combination[level] = i;
                DFS(level + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        FirstSearch0815 main = new FirstSearch0815();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 도시 가로/세로 길이
        m = sc.nextInt(); // 살릴 피자집 개수

        hs = new ArrayList<>(); // 집 위치
        pz = new ArrayList<>(); // 피자집 위치

        // 도시정보 읽어들이기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = sc.nextInt();
                if (tmp == 1) { // 집의 좌표
                    hs.add(new Point(i, j));
                } else if (tmp == 2) { // 피자집의 좌표
                    pz.add(new Point(i, j));
                }
            }
        }
        len = pz.size(); // 피자집의 개수
        combination = new int[m];
        main.DFS(0, 0);
        System.out.println(answer);
    }
}
