# [프로그래머스] 코딩테스트 연습

## [정수 제곱근 판별](https://programmers.co.kr/learn/courses/30/lessons/12934)

### 간략한 문제 풀이

- 수학적인 알고리즘을 생각하신다면 어렵지 않게 풀수 있었습니다.

- Math클래스의 메소드들 중 sqrt()와 pow()를 이해 할 수 있도록 하는 문제 중에 가장 좋은 문제가 아니였나 생각합니다.

- [Math.sqrt()](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/lang/Math.html#sqrt(double))
    - 양의 제곱근을 반환합니다. (리턴타입은 double)
    
- [Math.pow()](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/lang/Math.html#pow(double,double))
    - 첫 번째 인수의 값을 두 번째 인수의 거듭 제곱으로 리턴합니다.
    
- [github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level01/IntegerSquareRoot.java)

### 문제 및 풀이

**문제 설명**

임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.

n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.

**제한 사항**

n은 1이상, 50000000000000 이하인 양의 정수입니다.

**입출력 예**

| n | return |
| :---: | :---: |
| 121 | 144 |
| 3 | -1 |

**입출력 예 설명**

**입출력 예#1**

121은 양의 정수 11의 제곱이므로, (11+1)를 제곱한 144를 리턴합니다.

**입출력 예#2**

3은 양의 정수의 제곱이 아니므로, -1을 리턴합니다.
````
/**
 * @ClassName : IntegerSquareRoot
 * @ProblemName : 정수 제곱근 판별
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12934
 */
public class IntegerSquareRoot {
    public long solution(long n){
        double nSquareRoot = Math.sqrt(n);
        long answer = 0;

        if (nSquareRoot % (long)nSquareRoot == 0){
            answer += Math.pow((nSquareRoot + 1), 2);
        }else{
            answer = -1;
        }
        return answer;
    }

    public static void main(String[] args) {
        IntegerSquareRoot integerSquareRoot = new IntegerSquareRoot();
        int n1 = 121;
        int n2 = 3;

        System.out.println(integerSquareRoot.solution(n1));
        System.out.println(integerSquareRoot.solution(n2));
    }
}
````