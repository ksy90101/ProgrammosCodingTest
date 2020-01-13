# [프로그래머스] 코딩테스트 연습

## [문자열 내림차순으로 배치하기](https://programmers.co.kr/learn/courses/30/lessons/12917)

### 간략한 문제 풀이

- 오름차순 정렬은 쉽게 할 수 있지만, 내림차순은 따로 메소드를 많이 지원하지 않는것 같다.

- 이 문제는 풀면서 정렬한 후, reverse 메소드를 이용하여, 문자열을 반대로 했다.

- reverse 메소드를 처음 써봤는데, 새로운 메소드를 배운 것 같아 좋다 ㅎㅎ

- 다른 사람 풀이 보니 StringBuilder를 통해서도 reverse를 했던데, 새로운 메소드를 또 배우게 되었다.

- 마지막으로, 문자열을 나누는것과 합치는 메소드 2개도 배웠다.
    - 문자열 나누는 메소드
        1. public String split(String regex)
        2. public String split(String regex, int limit)
        - regex : 문자열을 나누기 위한 정규 표현식
        - limit : 분류할 문자열의 수
    - 문자열을 합치는 메소드
        - public static String join(CharSequence delimiter, CharSequence... elements) {
        - delimiter : 구분문자
        - elements : 결합할 요소들
        
- [github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level01/DescendingString.java)

### 문제 및 풀이

**문제 설명**

문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.

s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.

**제한 사항**

str은 길이 1 이상인 문자열입니다.

**입출력 예**

| s | return |
| :---: | :---: |
| Zbcdefg | gfedcbZ |

````
import java.util.Arrays;
import java.util.Collections;

/**
 * @ClassName : DescendingString
 * @ProblemName : 문자열 내림차순으로 배치하기
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12917
 */
public class DescendingString {

    public String solution(String s) {
        String answer = "";
        String[] sArray = s.split("");
        Arrays.sort(sArray);

        Collections.reverse(Arrays.asList(sArray));

        answer = String.join("", sArray);

        return answer;
    }

    //TestCase
    public static void main(String[] args) {
        DescendingString descendingString = new DescendingString();

        String s = "Zbcdefg";

        System.out.println(descendingString.solution(s));
    }
}
````