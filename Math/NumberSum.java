package Math;

import java.util.Scanner;

/**
 * 백준 11720
 * 기본 수학
 */
class NumberSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String sNum = sc.next();
        char[] strArr = sNum.toCharArray();

        int sum = 0;

        for (int i = 0; i < strArr.length; i++) {
            sum += strArr[i] - '0';
        }

        System.out.println(sum);
    }
}
