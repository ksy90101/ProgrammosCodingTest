# [프로그래머스] 코딩테스트 연습

## [가운데 글자 가져오기](https://programmers.co.kr/learn/courses/30/lessons/12903)

### 간략한 문제 풀이

- String Class의 subString()메소드를 배울 수 있는 문제 인 것 같습니다.

- 문자열을 자를 수 있는 것으로 수학적으로 조금만 생각해보면 풀수 있었습니다.

- 더 간단하게 푸신 분들이 많았는데, 저는 가장 기본적으로 생각해서 푼것 같았습니다.

### 문제 및 풀이

**문제 설명**

단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.

**재한사항**

s는 길이가 1 이상, 100이하인 스트링입니다.

**입출력 예**

| s | return | 
| :---: | :---: | 
| abcde | c |

````
/**
 * @ClassName : GetMiddleCharacter
 * @ProblemName : 가운데 글자 가져오기
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12903
 */
public class GetMiddleCharacter {
    public String solution(String s) {
        String answer = "";
        if (s.length() % 2 == 0) {
            answer = s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
        } else if (s.length() % 2 == 1) {
            answer = s.substring(s.length() / 2, s.length() / 2 + 1);
        }

        return answer;
    }

    // Test Case
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "qwer";

        GetMiddleCharacter getMiddleCharacter = new GetMiddleCharacter();

        System.out.println(getMiddleCharacter.solution(s1));
        System.out.println(getMiddleCharacter.solution(s2));
    }
}
````