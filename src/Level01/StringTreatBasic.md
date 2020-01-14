# [프로그래머스] 코딩테스트 연습

## [문자열 다루기 기본](https://programmers.co.kr/learn/courses/30/lessons/12918)

### 간략한 문제 풀이

- 문자열 다루기 기본인데, 예외처리를 배웠다 ㅋㅋ

- 간단하지만, 예외처리가 어렵기도 했는데, 쉽게 풀어 나간것 같다.

- 여기서의 오류인 NumberFormatException에 대해서만 설명하면 될듯 하다.
    - 숫자 형식 오류로, 숫자형이 아닌 다른 값이 숫자로 변환하려고 할때 많이 발생
    
- [github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level01/StringTreatBasic.java)
    
### 문제 및 풀이

**문제 설명**

문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 예를 들어 s가 a234이면 False를 리턴하고 1234라면 True를 리턴하면 됩니다.

**제한 사항**

s는 길이 1 이상, 길이 8 이하인 문자열입니다.

**입출력 예**

| s | return |
| :---: | :---: |
| a234 | false |
| 1234 | true |

````
/**
 * @ClassName : StringTreatBasic
 * @ProblemName : 문자열 다루기 기본
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12918
 */
public class StringTreatBasic {
    public boolean solution(String s) {
        boolean answer = true;

        try{
            Integer.parseInt(s);
            if(s.length() == 4 || s.length() == 6){
                return answer;
            }
        }catch (NumberFormatException e){
            answer = false;
        }

        return answer;
    }

    //Test Case
    public static void main(String[] args) {
        StringTreatBasic stringTreatBasic = new StringTreatBasic();

        String s1 = "a234";
        String s2 = "1234";

        System.out.println(stringTreatBasic.solution(s1));
        System.out.println(stringTreatBasic.solution(s2));
    }
}
````