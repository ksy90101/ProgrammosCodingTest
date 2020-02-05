# [프로그래머스] 코딩테스트 연습

## [직사각형 별찍기](https://programmers.co.kr/learn/courses/30/lessons/12969)

### 간략한 문제 풀이

- 쉽게 풀수 있었고, for문 예제중 가장 기본적인 별찍기 문제였습니다.,

- [Github](hhttps://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level01/RectangleStar.java)

### 문제 및 풀이

**문제 설명**

이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다.
별(*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 형태를 출력해보세요.

**제한 조건**

n과 m은 각각 1000 이하인 자연수입니다.

**예시**

입력
````
5 3
````

**출력**

````
*****
*****
*****
````

````
import java.util.Scanner;

/**
 * @ClassName : RectangleStar
 * @ProblemName : 직사각형 별찍기
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12969
 */
public class RectangleStar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        for (int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
````