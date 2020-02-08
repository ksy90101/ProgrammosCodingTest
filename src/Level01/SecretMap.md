# [프로그래머스] 코딩테스트 연습

## [비밀지도](https://programmers.co.kr/learn/courses/30/lessons/17681)

### 간략한 문제 풀이

- 2017년 카카오 신입 공채 1차 코딩 테스트 문제입니다.
    - [카카오 신입 공채 1차 코딩 테스트 문제 해설](https://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/)

- OR 비트 연산과 2진수에 대한 지식만 있다면, 어렵지 않게 풀수 있는 문제인 것 같습니다.

- 처음 생각한 코딩 방향과 일치하도록 설계를 했지만, 10진수를 2진수로 변환하면, 앞에 있는 '0'들은 생략이 되버립니다.
    - Ex) 실제값 : 0000 1011 -> 출력값 : 1011

- 이 부분을 구현하는 데 처음에는 String.format을 사용하여 0을 추가했지만, 이상하게 값이 변경을 하는 바람에, while문으로 매개변수로 주어진 n과 변 문자열의 길이가 다르면 공백을 앞에 추가하도록 하였습니다.

- 문자열을 연산해야 하는 경우가 많은 문제이기 때문에 String을 쓰는것보다 StringBuffer / StringBuilder를 사용하시는 걸 추천드립니다.(효율성)

- 카카오 블로그 내 문제 해설 내용 정리
    - 이 문제는 Bitwise Operation(비트연산)을 묻는 문제
    - OR로 처리하면 간단히 풀 수 있었습니다.
    - if else문으로 풀수 있는 문제이지만, 비트 연산을 활용하는 것이 목적이었던 문제였습니다.

- OR 비트 연산자
    - | 연산자로 두 비트 중 하나라도 1이면 1을 반환하는 연산자 입니다.
    - [참고자료](https://donologue.tistory.com/55)
    
- [StringBuilder](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/lang/StringBuilder.html)
    - public final class StringBuilder extends Object implements Serializable, Comparable<StringBuilder>, CharSequence
    - 문자열을 변경할 수 있는 클래스로 serialize가 가능하며, 문자열이고 비교가능한 값.
    - final class이기 때문에 String class를 상속받을 수 없음.
    - StringBuilder와 StringBuffer의 차이점
        - StringBuilder는 변경가능한 문자열이지만, synchronization(동기화)가 적용되지 않음
        - StringBuffer는 thread-safe라는 말에서 처럼 변경가능하지만 multiple thread환경에서 안전한 클래스
        - [참고자료](https://novemberde.github.io/2017/04/15/String_0.html)
    - [StringBuilder.append()](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/lang/StringBuilder.html#append(java.lang.String\))
        - public StringBuilder append(String str)
        - 지정한 문자열을 문자열 순서에 맞춰 추가합니다.
    - [StringBuilder.delete()](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/lang/StringBuilder.html#delete(int,int\))
        - public StringBuilder delete(int start, int end)
        - 매개변수로 문자열의 start(시작 인덱스), end(끝 인덱스)를 받아 범위 만큼(start ~ end - 1)의 문자를 삭제합니다.
    - [StringBuilder.insert()](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/lang/StringBuilder.html#insert(int,java.lang.String\))
        - public StringBuilder insert(int offset, String str)
        - 매개변수로 문자열의 offset(문자열을 추가할 인덱스)와 str(추가할 문자열)을 받아 추가할 문자열을 offset(추가할 인덱스)에 맞춰 삽입합니다.
    - [StringBuilder.toString()](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/lang/CharSequence.html#toString())
        - String toString()
        - java.lang.CharSequence의 메소드로 타입을 String으로 변환합니다.
        
- [Integer.toBinaryString()](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/lang/Integer.html#toBinaryString(int\))
    - public static String toBinaryString(int i)
    - 2진수 값을 문자열로 반환해주는 메소드입니다.(양수, 음수 기준을 제대로 하지 않습니다.)
    - 변환한 값이 음수이면, 매개변수의 값 + 232의 2진수가 ㅄ이 나오게 됩니다.
    - 매개변수 값을 Integer.parseUnsignedInt(s, 2)를 호출하면 반환된 문자열 s에서 복구 할 수 있습니다.
    
- [String.format()](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/lang/String.html#format(java.util.Locale,java.lang.String,java.lang.Object...\))
    - public static String format(Locale l, String format)
    - 매개변수의 format 문자열을 지정된 형식 문자열(l)을 이용하여 문자열을 반환합니다.

- [Github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level01/SecretMap.java)

### 문제 및 풀이

**문제 설명**

네오는 평소 프로도가 비상금을 숨겨놓는 장소를 알려줄 비밀지도를 손에 넣었다. 그런데 이 비밀지도는 숫자로 암호화되어 있어 위치를 확인하기 위해서는 암호를 해독해야 한다. 다행히 지도 암호를 해독할 방법을 적어놓은 메모도 함께 발견했다.

1. 지도는 한 변의 길이가 n인 정사각형 배열 형태로, 각 칸은 공백(" ) 또는벽(#") 두 종류로 이루어져 있다.

2. 전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다. 각각 지도 1과 지도 2라고 하자. 지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다. 지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.

3. 지도 1과 지도 2는 각각 정수 배열로 암호화되어 있다.

4. 암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다.

![secret map](http://t1.kakaocdn.net/welcome2018/secret8.png)

네오가 프로도의 비상금을 손에 넣을 수 있도록, 비밀지도의 암호를 해독하는 작업을 도와줄 프로그램을 작성하라.

**입력 형식**

입력으로 지도의 한 변 크기 n 과 2개의 정수 배열 arr1, arr2가 들어온다.

- 1 ≦ n ≦ 16
- arr1, arr2는 길이 n인 정수 배열로 주어진다.
- 정수 배열의 각 원소 x를 이진수로 변환했을 때의 길이는 n 이하이다. 즉, 0 ≦ x ≦ 2n - 1을 만족한다.

**출력 형식**

원래의 비밀지도를 해독하여 '#', 공백으로 구성된 문자열 배열로 출력하라.

**입출력 예제**

| 매개변수 | 값 | 
| :---: | :---: | 
| n | 5 | 
| arr1 | [9, 20, 28, 18, 11] | 
| arr2 | [30, 1, 21, 17, 28] | 
| 출력 | ["#####","# # #", "### #", "# ##", "#####"] | 

| 매개변수 | 값 | 
| :---: | :---: | 
| n | 6 | 
| arr1 | [46, 33, 33 ,22, 31, 50] | 
| arr2 | [27 ,56, 19, 14, 14, 10] | 
| 출력 | ["######", "### #", "## ##", " #### ", " #####", "### # "] | 

````
import java.util.Arrays;

/**
 * @ClassName : SecretMap
 * @ProblemName : 비밀지도
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/17681
 */
public class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        StringBuilder secretMapSide = new StringBuilder();
        for (int i = 0; i < arr1.length; i++) {
            secretMapSide.delete(0, secretMapSide.length());
            String arr1OrArr2Binary = Integer.toBinaryString(arr1[i] | arr2[i]);
            String[] binaryValues = arr1OrArr2Binary.split("");

            for (String binaryValue : binaryValues) {
                if (binaryValue.equals("1")) {
                    secretMapSide.append("#");
                    continue;
                }
                secretMapSide.append(" ");
            }

            while (secretMapSide.length() != n){
                secretMapSide.insert(0, " ");
            }

            answer[i] = secretMapSide.toString();
        }
        return answer;
    }

    // Test Case
    public static void main(String[] args) {
        SecretMap secretMap = new SecretMap();
        int n1 = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        int n2 = 6;
        int[] arr3 = {46, 33, 33, 22, 31, 50};
        int[] arr4 = {27, 56, 19, 14, 14, 10};

        System.out.println(Arrays.toString(secretMap.solution(n1, arr1, arr2)));
        System.out.println(Arrays.toString(secretMap.solution(n2, arr3, arr4)));

    }
}
````