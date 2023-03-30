package inflearnAlgorithm.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 06-07. 좌표 정렬
 * N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램
 * 입력
 * 5
 * 2 7
 * 1 3
 * 1 2
 * 2 5
 * 3 6
 * 출력
 * 1 2
 * 1 3
 * 2 5
 * 2 7
 * 3 6
 */
public class Sorting0607 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

//        Arrays.stream(solution1(n, arr)).forEach(i -> System.out.println(i[0] + " " + i[1]));

        for (Point p : Sorting0607.solution2(n, arr)) {
            System.out.println(p.x + " " + p.y);
        }
    }

    public static int[][] solution1(int n, int[][] arr) {
        Arrays.sort(arr, (o1, o2) -> { // 2차원 배열의 Comparator
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        return arr;
    }

    public static ArrayList<Point> solution2(int n, int[][] arr) {

        ArrayList<Point> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = arr[i][0];
            int y = arr[i][1];
            list.add(new Point(x, y));
        }

        Collections.sort(list); // 리스트 정렬

        return list;
    }

    static class Point implements Comparable<Point> { // 좌표 (x,y) 클래스 만들기
        public int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x == o.x) { // x좌표가 같으면
                return this.y - o.y; // y좌표로 비교하기
            } else { // x좌표가 다르면
                return this.x - o.x; // x좌표로 비교하기
            }
        }
    }
}
