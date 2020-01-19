# [프로그래머스] 코딩테스트 연습

## [시저 암호](https://programmers.co.kr/learn/courses/30/lessons/12926)

### 간략한 문제 풀이

- Level01중에서는 난이도가 조금 있던 문제였던것 같습니다.

- 처음에 너무 하드코딩으로 풀어서, 최대한 코드 간략화를 시켰습니다.

- 처음에는 소문자 배열과 대문자 배열을 모두 생성했지만, 아래 메소드를 이용하여 대문자 배열로만 코드를 줄였습니다.(그러다 보니 중복 코딩이 사라졌습니다.)

- 이번 문제를 풀면서 조금만 더 생각을 하면, 코드를 하나씩 지워나갈수 있다는 걸 알게 되었습니다.

- 역시 문자열 연산을 하는 문제는 String을 쓰면 효율성이 너무 떨어지네요. StringBuffer나, StringBuilder를 쓰기를 권장합니다.

- 이번에는 새로운 메소드들이 많이 나왔는데요.

    1. Arrays.binarySearch()
        - [Java API 설명](https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html#binarySearch-char:A-char-)
        
        - 쉽게 생각하면, 배열안에 있는 값에서 지정된 값을 검색하는 알고리즘이라고 생각하시면 됩니다. 
        
        - 2진검색은 알고리즘입니다. 알고리즘도 한번 보면 좋습니다.
        
        - [2진검색 알고리즘](https://ledgku.tistory.com/35)
        
    2. Character.isUpperCase & Character.isLowerCase
    
        - 메소드명에서 보이는것 처럼, 대문자 & 소문자 여부를 boolean형태로 리턴해주는 것 입니다.
        
        - [Java API 설명](https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html#isLowerCase-char-)
        
    3. Character.toUpperCase & Character.toLowerCase
    
        - 메소드명에서 보이는것 처럼, 대문자 & 소문자로 변환해주는 메소드입니다.
        
        - [Java API 설명](https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html#toLowerCase-char-)
        
- [Stream github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level01/CaesarCipher.java)

### 문제 및 풀이

**문제 설명**

어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다. 예를 들어 AB는 1만큼 밀면 BC가 되고, 3만큼 밀면 DE가 됩니다. z는 1만큼 밀면 a가 됩니다. 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.

**제한 조건**

공백은 아무리 밀어도 공백입니다.

s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.

s의 길이는 8000이하입니다.

n은 1 이상, 25이하인 자연수입니다.

**입출력 예**

|s | n | result | 
| :---: | :---: | :---: | 
| AB | 1 | BC | 
| z | 1 | a | 
| a B z | 4 | e F d | 

````
import java.util.Arrays;

/**
 * @ClassName : CaesarCipher
 * @ProblemName : 시저암호
 * @URL :https://programmers.co.kr/learn/courses/30/lessons/12926
*/
public class CaesarCipher {
    public String solution(String s, int n){
        StringBuffer answer = new StringBuffer();
        char[] uppers = new char[26];
        int temp = 0;

        for (int i = 0; i < uppers.length; i++){
            uppers[i] = (char)('A' + i);
        }

        for (char c : s.toCharArray()){
            if (c == ' '){
                answer.append(c);
                continue;
            }

            temp = Arrays.binarySearch(uppers, Character.toUpperCase(c)) + n;
            temp -= (temp > 25) ? 26 : 0;

            if(Character.isUpperCase(c)){
                answer.append(uppers[temp]);
            }else if(Character.isLowerCase(c)){
                answer.append(Character.toLowerCase(uppers[temp]));
            }
        }
        return answer.toString();
    }

    // Test Case
    public static void main(String[] args) {
        CaesarCipher caesarCipher = new CaesarCipher();

        String s1 = "AB";
        String s2 = "z";
        String s3 = "a B z";

        int n1 = 1;
        int n2 = 1;
        int n3 = 4;

        System.out.println(caesarCipher.solution(s1, n1));
        System.out.println(caesarCipher.solution(s2, n2));
        System.out.println(caesarCipher.solution(s3, n3));
    }
}
````