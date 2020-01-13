# [프로그래머스] 코딩테스트 연습

## [문자열 내 p와 y의 개수](https://programmers.co.kr/learn/courses/30/lessons/12916)

### 간략한 문제 풀이

- 대문자와 소문자 두개다 같은지를 봐야 하지만, String 클래스 메소드 중 toUpperCase()나, toLowerCase가 있기 때문에, 
조건을 하나로 줄일 수 있는 것이 이 문제의 핵심인 듯 하다.

- for문으로 문제를 풀때 stream으로 간단히 풀수 없을지를 고민을 해야 되겠다. 다른 사람 풀이를 보고 대단하다는 생각이 들었다 ㅎㅎ

````
s.chars().filter( e -> 'P'== e).count() == s.chars().filter( e -> 'Y'== e).count();
````

- [Github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level01/POrYNumberOfString.java)

### 문제 및 풀이

**문제 설명**

대문자와 소문자가 섞여있는 문자열 s가 주어집니다. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요. 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.

예를 들어 s가 pPoooyY면 true를 return하고 Pyy라면 false를 return합니다.

**제한사항**

문자열 s의 길이 : 50 이하의 자연수

문자열 s는 알파벳으로만 이루어져 있습니다.

**입출력 예**

| s	| answer | 
| :---: | :---: | 
| pPoooyY | true | 
| Pyy | false | 

**입출력 예 설명**

**입출력 예 #1**

'p'의 개수 2개, 'y'의 개수 2개로 같으므로 true를 return 합니다.

**입출력 예 #2**

'p'의 개수 1개, 'y'의 개수 2개로 다르므로 false를 return 합니다.

````
/**
 * @ClassName : POrYNumberOfString
 * @ProblemName : 문자열 내 p와 y의 개수
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12916
 */
public class POrYNumberOfString {
    public boolean solution(String s) {
        boolean answer = true;
        int pNumber = 0;
        int yNumber = 0;

        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            pNumber += (s.charAt(i) == 'p') ? 1 : 0;
            yNumber += (s.charAt(i) == 'y') ? 1 : 0;
        }
        answer = (pNumber == yNumber);

        return answer;
    }

    //Test Case
    public static void main(String[] args) {
        POrYNumberOfString pOrYNumberOfString = new POrYNumberOfString();

        String s1 = "pPoooyY";
        String s2 = "Pyy";

        System.out.println(pOrYNumberOfString.solution(s1));
        System.out.println(pOrYNumberOfString.solution(s2));
    }
}
````