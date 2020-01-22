# [프로그래머스] 코딩테스트 연습

## [이상한 문자 만들기](https://programmers.co.kr/learn/courses/30/lessons/12930)

### 간략한 문제 풀이

- 처음에는 쉬워보여서 쉽게 풀 수 있다고 생각했는데, 제한 사항에는 없지만 공백이 연속으로 나올 수 있는 상황이 있을 수도 있었습니다.
처음에 split()를 사용했더니, 그런 부분들에 대해서는 체크를 못하기 때문에 100점이 나오지 않았습니다.
그래서 문자별대로 나눠서 따로 단어 길이를 측정해서 변경하였습니다.
조건식을 적는 것이 처음하시는 분들은 조금 까다로울 수도 있지만, 알고리즘 입문자에게는 적당한 난이도가 아닐까 생각합니다.

- character를 사용하다보니, 아스키 코드를 사용했어야 합니다.

![아스키코드표](https://t1.daumcdn.net/cfile/tistory/216CE84C52694FF020)

- [String.valueOf()](https://swjeong.tistory.com/146)

- [github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level01/MakeWeirdString.java)

### 문제 및 풀이

**문제 설명**

문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나 이상의 공백문자로 구분되어 있습니다. 각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.

**제한 사항**

문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.

첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.

**입출력 예**

| s | return |
| :---: | :---: |
| try hello world | TrY HeLlO WoRlD | 

**입출력 예 설명**

try hello world는 세 단어 try, hello, world로 구성되어 있습니다. 각 단어의 짝수번째 문자를 대문자로, 홀수번째 문자를 소문자로 바꾸면 TrY, HeLlO, WoRlD입니다. 따라서 TrY HeLlO WoRlD 를 리턴합니다.

````
/**
 * @ClassName : MakeWeirdString
 * @ProblemName : 이상한 문자 만들기
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12930
 */
public class MakeWeirdString {
    public String solution(String s) {
        char[] alphabets = s.toCharArray();
        int wordLength = 0;

        for (int i = 0; i < alphabets.length; i++) {
            if (alphabets[i] == ' ') {
                wordLength = 0;
                continue;
            }

            if (wordLength % 2 == 0 && alphabets[i] >= 'a' && alphabets[i] <= 'z') {
                alphabets[i] -= 32;
            } else if (wordLength % 2 != 0 && alphabets[i] >= 'A' && alphabets[i] <= 'Z') {
                alphabets[i] += 32;
            }
            wordLength++;
        }

        return String.valueOf(alphabets);
    }

    // Test Case
    public static void main(String[] args) {
        MakeWeirdString makeWeirdString = new MakeWeirdString();
        String s = "try hello world";

        System.out.println(makeWeirdString.solution(s));
    }
}
````