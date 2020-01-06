# [프로그래머스] 코딩테스트 연습

## [문자열압축](https://programmers.co.kr/learn/courses/30/lessons/60057)

### 간략한 문제 풀이

- 입력값은 '입력값/2' 이하만 압축 가능합니다.
(예를들어 8글자인 경우 4글자 이하, 7글자인 경우에는 3글자)

- 한글자 부터 입력값/2글자까지 반복을 하여, 압축을 하고 Math.min()을 이용하여 최소값을 찾게 됩니다.

- subString()을 이용하여 문자열을 잘랐습니다.

- StringBuffer를 사용하긴 했지만, compareStr1, 2에도 사용했다면, 시간이 덜 걸리게 나올수 있었을텐데, 쉽지가 않네요 ㅎㅎ

- 개인적으로 보안은 역시 어렵습니다. ㅠㅠ

### 문제 및 풀이

**문제 설명**

데이터 처리 전문가가 되고 싶은 어피치는 문자열을 압축하는 방법에 대해 공부를 하고 있습니다. 최근에 대량의 데이터 처리를 위한 간단한 비손실 압축 방법에 대해 공부를 하고 있는데, 문자열에서 같은 값이 연속해서 나타나는 것을 그 문자의 개수와 반복되는 값으로 표현하여 더 짧은 문자열로 줄여서 표현하는 알고리즘을 공부하고 있습니다.
간단한 예로 aabbaccc의 경우 2a2ba3c(문자가 반복되지 않아 한번만 나타난 경우 1은 생략함)와 같이 표현할 수 있는데, 이러한 방식은 반복되는 문자가 적은 경우 압축률이 낮다는 단점이 있습니다. 예를 들면, abcabcdede와 같은 문자열은 전혀 압축되지 않습니다. 어피치는 이러한 단점을 해결하기 위해 문자열을 1개 이상의 단위로 잘라서 압축하여 더 짧은 문자열로 표현할 수 있는지 방법을 찾아보려고 합니다.

예를 들어, ababcdcdababcdcd의 경우 문자를 1개 단위로 자르면 전혀 압축되지 않지만, 2개 단위로 잘라서 압축한다면 2ab2cd2ab2cd로 표현할 수 있습니다. 다른 방법으로 8개 단위로 잘라서 압축한다면 2ababcdcd로 표현할 수 있으며, 이때가 가장 짧게 압축하여 표현할 수 있는 방법입니다.

다른 예로, abcabcdede와 같은 경우, 문자를 2개 단위로 잘라서 압축하면 abcabc2de가 되지만, 3개 단위로 자른다면 2abcdede가 되어 3개 단위가 가장 짧은 압축 방법이 됩니다. 이때 3개 단위로 자르고 마지막에 남는 문자열은 그대로 붙여주면 됩니다.

압축할 문자열 s가 매개변수로 주어질 때, 위에 설명한 방법으로 1개 이상 단위로 문자열을 잘라 압축하여 표현한 문자열 중 가장 짧은 것의 길이를 return 하도록 solution 함수를 완성해주세요.

**제한사항**

s의 길이는 1 이상 1,000 이하입니다.

s는 알파벳 소문자로만 이루어져 있습니다.

| 입출력 | 예 |
| :---: | :---: | 
| s	| result |
| "aabbaccc" | 7 |
| "ababcdcdababcdcd" | 9 |
| "abcabcdede" | 8 |
| "abcabcabcabcdededededede" | 14 |
| "xababcdcdababcdcd" | 17 |

**입출력 예에 대한 설명**

입출력 예 #1


문자열을 1개 단위로 잘라 압축했을 때 가장 짧습니다.

입출력 예 #2


문자열을 8개 단위로 잘라 압축했을 때 가장 짧습니다.


입출력 예 #3


문자열을 3개 단위로 잘라 압축했을 때 가장 짧습니다.


입출력 예 #4


문자열을 2개 단위로 자르면 abcabcabcabc6de 가 됩니다.

문자열을 3개 단위로 자르면 4abcdededededede 가 됩니다.

문자열을 4개 단위로 자르면 abcabcabcabc3dede 가 됩니다.

문자열을 6개 단위로 자를 경우 2abcabc2dedede가 되며, 이때의 길이가 14로 가장 짧습니다.


입출력 예 #5


문자열은 제일 앞부터 정해진 길이만큼 잘라야 합니다.

따라서 주어진 문자열을 x / ababcdcd / ababcdcd 로 자르는 것은 불가능 합니다.

이 경우 어떻게 문자열을 잘라도 압축되지 않으므로 가장 짧은 길이는 17이 됩니다.

````
package Level01;

/**
 * @ClassName : StringCompression
 * @ProblemName : 문자열 압축
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/60057
 */
public class StringCompression {

    public int solution(String s) {
        final int S_LENGTH = s.length();
        int answer = S_LENGTH;

        for (int i = 1; i <= S_LENGTH / 2; i++) {
            String compareStr1 = "";
            StringBuffer result = new StringBuffer();
            int count = 1;

            for (int j = 0; j < S_LENGTH / i; j++){
                String compareStr2 = s.substring((i * j), (i * j) + i);
                if(compareStr1.equals(compareStr2)){
                    count++;
                    continue;
                }

                result.append((count > 1) ? count + compareStr1 : compareStr1);

                compareStr1 = compareStr2;
                count = 1;
            }

            result.append((count > 1) ? count + compareStr1 : compareStr1);

            if(S_LENGTH % i != 0){
                result.append(s.substring(S_LENGTH - (S_LENGTH % i), S_LENGTH));
            }
            answer = Math.min(result.length(), answer);
        }

        return answer;
    }

    //TestCase
    public static void main(String[] args) {
        StringCompression stringCompression = new StringCompression();

        String testCase1 = "aabbaccc";
        String testCase2 = "ababcdcdababcdcd";
        String testCase3 = "abcabcdede";
        String testCase4 = "abcabcabcabcdededededede";
        String testCase5 = "xababcdcdababcdcd";

        System.out.println(stringCompression.solution(testCase1));
        System.out.println(stringCompression.solution(testCase2));
        System.out.println(stringCompression.solution(testCase3));
        System.out.println(stringCompression.solution(testCase4));
        System.out.println(stringCompression.solution(testCase5));
    }
}
````