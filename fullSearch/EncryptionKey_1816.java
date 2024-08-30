package inflearnAlgorithm.fullSearch;

import java.util.Scanner;
/*
1816. 암호 키
현대 사회에서 통용되고 있는 많은 종류의 암호 시스템에서는, 매우 큰 소수의 곱으로 만들어진 수를 암호 키로 이용하는 경우가 많다. 현실적으로 매우 큰 수를 빠른 시간 내에 소인수분해하는 것은 어려운 일이기 때문이다.
물론 실제 생활에서는 수십만 또는 수백만 자리 이상의 매우 큰 소수가 활용되지만 그러한 소수를 구하는 것은 매우 어려운 일이므로, 우리는 좀 더 스케일이 작은 경우에 대해서만 생각해 보기로 하자.
1,000,000 = 10^6보다 큰 소수이면 매우 큰 소수로 생각하는 것이다.
어떤 수 S가 주어지면, 이 수가 우리가 생각하는 스케일이 작은 경우(=100000보다 같거나 작은 범위)에서 적절한 암호 키인지 아닌지를 구하는 프로그램을 작성하시오.
만일 S의 모든 소인수가 10^6보다 크다면 그 수는 적절한 암호 키이고, 그렇지 않은 경우는 적절하지 못한 암호 키가 된다.
 */
/*
입력값
3
1000036000099
1500035500153
20000000000002
*/
public class EncryptionKey_1816 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testCaseCnt = sc.nextInt();

        for (int i = 0; i < testCaseCnt; i++) {
            long S = sc.nextLong(); // 암호키 후보
            for (int j = 2; j < 1000000 + 1; j++) {
                if (S % j == 0) { // 소인수 중 1000000보다 작은 수가 있다면 적절하지 못함
                    System.out.println("NO");
                    break;
                }
                if (j == 1000000) { // 1000000가 될 때까지 소인수가 없으므로, 모든 소인수가 1000000보다 크다는 의미
                    System.out.println("YES");
                }
            }
        }

    }
}
