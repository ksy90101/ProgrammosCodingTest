# [프로그래머스] 코딩테스트 연습

## [핸드폰 번호 가리기](https://programmers.co.kr/learn/courses/30/lessons/12948)

### 간략한 문제 풀이

- [String.substring()](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/lang/String.html#substring)
    - public String substring(int beginIndex, int endIndex)
    - 문자열을 자르는 메소드로, 시작 위치(beginIndex)와 끝 위치(endIndex - 1)까지의 문자열을 반환합니다.
    - beginIndex가 음수이거나, endIndex의 길이가 String객체의 length보다 크다면 IndexOutOfBoundsException이 발생

- [github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level01/HiddenPhoneNumber.java)

### 문제 및 풀이

**문제 설명**

프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.
전화번호가 문자열 phone_number로 주어졌을 때, 전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요.

**제한 조건**

s는 길이 4 이상, 20이하인 문자열입니다.

**입출력 예**

| phone_number | return |
| :---: | :---: |
| 01033334444 | *******4444 |
| 027778888 | *****8888 | 

````
/**
 * @ClassName : HarshadNumber
 * @ProblemName : 하샤드 수
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12947
 */
public class HarshadNumber {
    public boolean solution(int x){
        char[] harshads = Integer.toString(x).toCharArray();
        int harshadSum = 0;

        for (char harshad : harshads){
            harshadSum += Integer.parseInt(Character.toString(harshad));
        }

        return (x % harshadSum == 0);
    }

    // Test Case
    public static void main(String[] args) {
        HarshadNumber harshadNumber = new HarshadNumber();
        int arr1 = 10;
        int arr2 = 12;
        int arr3 = 11;
        int arr4 = 13;

        System.out.println(harshadNumber.solution(arr1));
        System.out.println(harshadNumber.solution(arr2));
        System.out.println(harshadNumber.solution(arr3));
        System.out.println(harshadNumber.solution(arr4));
    }
}
````