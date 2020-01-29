# [프로그래머스] 코딩테스트 연습

## [최대공약수와 최소공배수](https://programmers.co.kr/learn/courses/30/lessons/12940)

### 간략한 문제 풀이

- 최대공약수와 최소공배수를 구하는 문제로, BigInteger라는 클래스를 처음 써보게 되었네요.

- 저는 알고리즘 문제를 푸는 첫번째 이유는 자바라는 언어에 익숙해지고, 새로운 메소드들을 배워가면서 익숙해지기 위함이라 알고리즘적으로 푸는 것보다는 API 메소드를 이용해서 풀려고 많이 노력을 하고 있습니다.

- 그래서 알고리즘 문제를 풀어도, 글을 보시는 분들과는 생각이 조금 다를 수 있습니다....ㅎㅎ

- BigInteger Class
    - [BigInteger Java API 12](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/math/BigInteger.html)
    - BigInteger Class는 long타입보다 큰 자료형으로 범위는 무한대이다.
    - 자바 API에서는 Immutable arbitrary-precision integers.(불변한 임의의 정밀한 정수)라고 정의되어 있다.
    - 사칙연산과 비교연산은 모두 메소드로 정의되어있다.(add, subtract, mutiply, devide, equals)
    - [BigInteger의 간단한 설명](https://elena90.tistory.com/entry/JAVA-%EB%AC%B4%ED%95%9C%EB%8C%80-%EC%A0%95%EC%88%98-BigInteger-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0)
    - gcd()메소드는 최대공약수를 BigInteger로 리턴하는 메소드이다.
    - intValue()메소드는 int형으로 형변환 하는 메소드이다.

- 최소공배수 구하는 법
     - A * B = L * G (A : 자연수1, B : 자연수2, L : 자연수1과 자연수2의 최소공배수, G : 자연수1과 자연수2의 최대공약수)
     - 위의 식으로 최소공배수를 구하면
     L = (A * B) / G가 된다.
     - 이번문제에서 최소공배수를 구한 방법으로, 최소공배수를 구하는 방법은 여러가지 있다.
     
- [github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level01/GcdOrLcm.java)

### 문제 및 풀이

**문제 설명**

두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요. 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다. 예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.

**제한 사항**

두 수는 1이상 1000000이하의 자연수입니다.

**입출력 예**

| n | m | return | 
| :---: | :---: | :---: | 
| 3 | 12 | [3, 12] | 
| 2 | 5 | [1, 10] |
 
**입출력 예 설명**

**입출력 예 #1**

위의 설명과 같습니다.

**입출력 예 #2**

자연수 2와 5의 최대공약수는 1, 최소공배수는 10이므로 [1, 10]을 리턴해야 합니다.

````
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
````