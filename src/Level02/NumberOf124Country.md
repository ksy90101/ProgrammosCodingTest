# [프로그래머스] 코딩테스트 연습

## [124나라의 숫자](https://programmers.co.kr/learn/courses/30/lessons/12899)

### 간략한 문제 풀이
- 10진법, 2진법, 16진법 처럼 개인적으로 `3진법`을 구현하는 문제라고 생각해서 진법을 구현하는 방법으로 접근했습니다.

- 배열로 진법에 쓰이는 숫자를 넣고, `n%3`으로 `index`를 구했습니다.

- `(n-1) / 3`으로 앞자리 수의 반복을 구현하였습니다.

- `String`연산이 있어 효율성을 위해 `StringBuilder`를 이용하여 연산을 진행하였습니다.

- 문제는, 앞자리가 계속 추가가 되어야 해서 `insert()`메서드로 `offset`을 `0`으로 두고 계속 앞으로 값을 추가 할 수 있도록 했습니다.

- 간단하지만, 생각이 필요한 문제였던 것 같습니다!

- [Github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level02/NumberOf124Country.java)

### 문제 및 풀이

**문제 설명**

124 나라가 있습니다. 124 나라에서는 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현합니다.

124 나라에는 자연수만 존재합니다.

124 나라에는 모든 수를 표현할 때 1, 2, 4만 사용합니다.

예를 들어서 124 나라에서 사용하는 숫자는 다음과 같이 변환됩니다.

| 10진법 | 124 나라 | 10진법 | 124 나라 | 
| :---: | :---: | :---: | :---: |  
| 1 | 1 | 6 | 14 | 
| 2 | 2 | 7 | 21 |
| 3 | 4 | 8 | 22 |
| 4 | 11 | 9 | 24 |
| 5 | 12 | 10 | 41 |

자연수 n이 매개변수로 주어질 때, n을 124 나라에서 사용하는 숫자로 바꾼 값을 return 하도록 solution 함수를 완성해 주세요.

**제한사항**

n은 500,000,000이하의 자연수 입니다.

**입출력 예**

| n | result | 
| :---: | :---: |
| 1 | 1 | 
| 2 | 2 | 
| 3 | 4 | 
| 4 | 11 | 

````java
/**
 * @ClassName : NumberOf124Country
 * @ProblemName : 124나라의 숫자
 * @URL :https://programmers.co.kr/learn/courses/30/lessons/12899
 */
public class NumberOf124Country {
    public String solution(int n) {
        String[] countryNumbers = {"4", "1", "2"};
        StringBuilder answer = new StringBuilder();

        while (n > 0){
            answer.insert(0, countryNumbers[n % 3]);
            n = (- 1) / 3;
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        NumberOf124Country numberOf124Country = new NumberOf124Country();
        int n1 = 1;
        int n2 = 2;
        int n3 = 3;
        int n4 = 4;
        System.out.println(numberOf124Country.solution(n1));
        System.out.println(numberOf124Country.solution(n2));
        System.out.println(numberOf124Country.solution(n3));
        System.out.println(numberOf124Country.solution(n4));
    }
}
````