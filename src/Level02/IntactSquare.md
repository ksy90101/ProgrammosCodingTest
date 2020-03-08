# [프로그래머스] 코딩테스트 연습

## [멀쩡한 사각형](https://programmers.co.kr/learn/courses/30/lessons/62048)

### 간략한 문제 풀이

- `Level2` 문제부터는 API 사용보다는 알고리즘에 더 치중되어 있는 문제들이 많은 것 같습니다.

- 이번 문제는 저에게는 너무 어려웠습니다. 고민을 많이 하다가 다른 사람 풀이를 보고 한 수 배우게 된 문제였습니다.

- 일단, 살짝 함정(?)이라면, `return`값은 long인데, `매개변수`는 int였습니다.

- 또한 `제한사항`에서 매개변수는 1억 이하의 자연수라고 했는데, 1억이하 자연수는 `int`로 모두 담을 수 없기 때문에 `long`으로 변환해줘야 합니다.

- `Long.parseLong`과 'String.valueOf()'를 이용해서 `Long`으로 변환했습니다.

- 최대공약수를 구했어야 하는데, 최대공약수는 Level1 문제때 풀어본 기억이 있어서 `BigInteger`를 사용해서 쉽게 구했습니다.

- [\[프로그래머스\] 최대공약수와 최소공배수](https://rutgo.tistory.com/462?category=808714)

- 그럼 간단하게 문제에 대해서 설명해드로도록 하겠습니다.

- 일단 블록의 크기는 `가로(W) * 세로(H)` 입니다.

- 또한 사각형 위로 대각선이 지나갈때 `(최대공약수(가로, 세로)) * (가로(W) / 최대공약수(가로,세로) + 세로(H) / 최대공약수(가로,세로) - 1)`입니다.

- [참고링크](https://taesan94.tistory.com/55)

- [Github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level02/IntactSquare.java)

### 문제 및 풀이

**문제 설명**

가로 길이가 Wcm, 세로 길이가 Hcm인 직사각형 종이가 있습니다. 종이에는 가로, 세로 방향과 평행하게 격자 형태로 선이 그어져 있으며, 모든 격자칸은 1cm x 1cm 크기입니다. 이 종이를 격자 선을 따라 1cm × 1cm의 정사각형으로 잘라 사용할 예정이었는데, 누군가가 이 종이를 대각선 꼭지점 2개를 잇는 방향으로 잘라 놓았습니다. 그러므로 현재 직사각형 종이는 크기가 같은 직각삼각형 2개로 나누어진 상태입니다. 새로운 종이를 구할 수 없는 상태이기 때문에, 이 종이에서 원래 종이의 가로, 세로 방향과 평행하게 1cm × 1cm로 잘라 사용할 수 있는 만큼만 사용하기로 하였습니다.

가로의 길이 W와 세로의 길이 H가 주어질 때, 사용할 수 있는 정사각형의 개수를 구하는 solution 함수를 완성해 주세요.

**제한사항**
- W, H : 1억 이하의 자연수

**입출력 예**

| W | H | result |
| :---: | :---: | :---: |
| 8 | 12 | 80 |

**입출력 예 설명**

**입출력 예 #1**

가로가 8, 세로가 12인 직사각형을 대각선 방향으로 자르면 총 16개 정사각형을 사용할 수 없게 됩니다. 원래 직사각형에서는 96개의 정사각형을 만들 수 있었으므로, 96 - 16 = 80 을 반환합니다.

![572957326.92.png](https://grepp-programmers.s3.amazonaws.com/files/production/ee895b2cd9/567420db-20f4-4064-afc3-af54c4a46016.png)

````java
package Level02;

import java.math.BigInteger;

/**
 * @ClassName : IntactSquare
 * @ProblemName : 멀쩡한 사각형
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/62048
 */
public class IntactSquare {
    public long solution(int w, int h){
        long answer;
        long wLong = Long.parseLong(String.valueOf(w));
        long hLong = Long.parseLong(String.valueOf(h));
        long sum = wLong * hLong;

        BigInteger bigInteger1 = BigInteger.valueOf(wLong);
        BigInteger bigInteger2 = BigInteger.valueOf(hLong);

        long gcd = (bigInteger1.gcd(bigInteger2)).longValue();

        answer = sum - gcd * ((wLong / gcd) + (hLong/gcd) -1);

        return answer;
    }

    public static void main(String[] args) {
        IntactSquare intactSquare = new IntactSquare();
        int W = 8;
        int H = 12;
        System.out.println(intactSquare.solution(W, H));
    }
}
````