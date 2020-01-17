# [프로그래머스] 코딩테스트 연습

## [소수 찾기](https://programmers.co.kr/learn/courses/30/lessons/12921)

### 간략한 문제 풀이

- 소수찾기는 알고리즘 문제중 기본적인 문제입니다.

- 사실, 반복문을 사용하여 하나씩 계산을 해서 풀수 있지만, 소수 찾기의 가장 큰 문제점은 효율성 문제이겠죠.

- 얼마나 반복을 하지 않는가를 보는 문제 중 대표적인 문제인 것 같습니다.

- 약수는 자기자신의 루트값 이하의 값만 약수를 가지게 될것 입니다. 따라서 최소한의 반복을 하기 위해서 Math.sqrt()메소드를 사용하여 루트값을 구하였습니다.

- 또한 짝수 중 2를 제외한 나머지 값들은 모두 소수가 될 수 없습니다. 따라서 맨 처음부터 짝수가 들어온다면 바로 빼버렸습니다.

- 지금생각해보니, 어차피 3부터 줄려면 i값을 +2씩 증감식을 만들었어도 좋았겠네요. 따라서 하다보니 변경하였습니다.

- 증감식을 1씩 해서 if문으로 짝수일때는 continue를 실행한 코드의 효율성 테스트와 증감식을 그냥 +1이 아닌, +2를 한 경우에 효율성이 눈에 띄게 다릅니다.

효율성  테스트(증감식 1)

테스트 1 〉	통과 (211.91ms, 50.9MB)

테스트 2 〉	통과 (202.65ms, 52.2MB)

테스트 3 〉	통과 (211.88ms, 52.3MB)

테스트 4 〉	통과 (205.51ms, 50.6MB)

효율성  테스트(증감식 2)

테스트 1 〉	통과 (193.19ms, 50.5MB)

테스트 2 〉	통과 (185.37ms, 52.3MB)

테스트 3 〉	통과 (192.78ms, 53MB)

테스트 4 〉	통과 (176.88ms, 50.6MB)

- 소수 찾기의 대표적인 에라토스테네스의 체가 있는데, 이 문제도 나중에 풀어봐야 될 것 같습니다!

- [github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level01/FindDecimal.java)

### 문제 및 풀이

**문제 설명**

1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.

소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
(1은 소수가 아닙니다.)

**제한 조건**

n은 2이상 1000000이하의 자연수입니다.

**입출력 예**

| n | result |
| :---: | :---: |
| 10 | 4 |
| 5 | 3 |

**입출력 예 설명**

**입출력 예 #1**

1부터 10 사이의 소수는 [2,3,5,7] 4개가 존재하므로 4를 반환

**입출력 예 #2**

1부터 5 사이의 소수는 [2,3,5] 3개가 존재하므로 3를 반환

````
/**
 * @ClassName : FindDecimal
 * @ProblemName : 소수 찾기
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12921
 */
public class FindDecimal {
    public int solution(int n) {
        int answer = 1;

        for (int i = 3; i <= n; i += 2) {
            boolean isDecimal = true;

            for (int j = 3; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isDecimal = false;
                    break;
                }
            }
            answer += isDecimal ? 1 : 0;
        }

        return answer;
    }

    // Test Case
    public static void main(String[] args) {
        FindDecimal findDecimal = new FindDecimal();
        int n1 = 10;
        int n2 = 5;

        System.out.println(findDecimal.solution(n1));
        System.out.println(findDecimal.solution(n2));
    }
}
````