package Level01;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @ClassName : GcdOrLcm
 * @ProblemName : 최대공약수와 최소공배수
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12940
 * @Description : 최대공약수(Greatest Common Divisor) / 최소공배수(Last Common Multiple)
 */
public class GcdOrLcm {
    public int[] solution(int n, int m){
        int[] answer = new int[2];
        BigInteger bigInteger1 = BigInteger.valueOf(n);
        BigInteger bigInteger2 = BigInteger.valueOf(m);

        BigInteger gcd = bigInteger1.gcd(bigInteger2);

        answer[0] = gcd.intValue();
        answer[1] = (m * n) / gcd.intValue();
        return answer;
    }

    // Test Case
    public static void main(String[] args) {
        GcdOrLcm gcdOrLCM = new GcdOrLcm();
        int n1 = 3;
        int n2 = 2;
        int m1 = 12;
        int m2 = 5;

        System.out.println(Arrays.toString(gcdOrLCM.solution(n1, m1)));
        System.out.println(Arrays.toString(gcdOrLCM.solution(n2, m2)));
    }
}
