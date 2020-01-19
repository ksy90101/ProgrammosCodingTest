# [프로그래머스] 코딩테스트 연습

## [문자열을 정수로 바꾸기](https://programmers.co.kr/learn/courses/30/lessons/12925)

### 간략한 문제 풀이

- 어렵지 않았지만, 저는 메소드를 이용하여 풀었습니다.

- 사실, 메소드로 풀수 있던 이유는 제한조건에서 부호와 숫자로만 이루어져 있고 0으로 시작하지 않는다는 조건이 있었기 때문에 가능했습니다.

- 그냥 parse~()에 대한 메소드를 이해할 수 있는 문제였던 것 같습니다.

-  Integer뿐만아니라, Double, Byte, 등등 모든 타입에 존재합니다.

- 또한 static 함수로써 import를 하지 않아도 사용할 수 있습니다.

- [Github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level01/StringToInteger.java)
### 문제 및 풀이

**문제 설명**

문자열 s를 숫자로 변환한 결과를 반환하는 함수, solution을 완성하세요.

**제한 조건**

s의 길이는 1 이상 5이하입니다.

s의 맨앞에는 부호(+, -)가 올 수 있습니다.

s는 부호와 숫자로만 이루어져있습니다.

s는 0으로 시작하지 않습니다.

**입출력 예**

예를들어 str이 1234이면 1234를 반환하고, -1234이면 -1234를 반환하면 됩니다.

str은 부호(+,-)와 숫자로만 구성되어 있고, 잘못된 값이 입력되는 경우는 없습니다.

````
/**
 * @ClassName : StringToInteger
 * @ProblemName : 문자열을 정수로 바꾸기
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12925
 */
public class StringToInteger {
    public int solution(String s){
        int answer = Integer.parseInt(s);

        return answer;
    }

    // Test Case
    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();

        String str1 = "1234";
        String str2 = "-1234";

        System.out.println(stringToInteger.solution(str1));
        System.out.println(stringToInteger.solution(str2));

    }
}
````