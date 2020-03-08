package Level02;

import java.math.BigInteger;

/**
 * @ClassName : IntactSquare
 * @ProblemName : 멀쩡한 사각형
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/62048
 */
public class IntactSquare {
    public static void main(String[] args) {
        IntactSquare intactSquare = new IntactSquare();
        int W = 8;
        int H = 12;
        System.out.println(intactSquare.solution(W, H));
    }

    public long solution(int w, int h) {
        long answer;
        long wLong = Long.parseLong(String.valueOf(w));
        long hLong = Long.parseLong(String.valueOf(h));
        long sum = wLong * hLong;

        BigInteger bigInteger1 = BigInteger.valueOf(wLong);
        BigInteger bigInteger2 = BigInteger.valueOf(hLong);

        long gcd = (bigInteger1.gcd(bigInteger2)).longValue();
        System.out.println(gcd);
        answer = sum - gcd * ((wLong / gcd) + (hLong / gcd) - 1);

        return answer;
    }
}
