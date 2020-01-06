# [프로그래머스] 코딩테스트 연습

## [2016년](https://programmers.co.kr/learn/courses/30/lessons/12901)

### 간략한 문제 풀이

- 입력값은 '입력값/2' 이하만 압축 가능합니다.
(예를들어 8글자인 경우 4글자 이하, 7글자인 경우에는 3글자)

- 한글자 부터 입력값/2글자까지 반복을 하여, 압축을 하고 Math.min()을 이용하여 최소값을 찾게 됩니다.

- subString()을 이용하여 문자열을 잘랐습니다.

- StringBuffer를 사용하긴 했지만, compareStr1, 2에도 사용했다면, 시간이 덜 걸리게 나올수 있었을텐데, 쉽지가 않네요 ㅎㅎ

- 개인적으로 보안은 역시 어렵습니다. ㅠㅠ

### 문제 및 풀이

**문제 설명**

2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요? 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요. 요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT
입니다. 예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 TUE를 반환하세요.

**제한 조건**

2016년은 윤년입니다.
2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)

**입출력 예** 

| a | b | result |
| :---: | :---: | :---: |
|5 | 24 | "TUE" |

````
import java.util.Calendar;

/**
 * @ClassName : YearOf2016
 * @ProblemName : 2016년
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12901
 */
public class YearOf2016 {
    public String solution(int a, int b){
        final int YEAR = 2016;

        String answer = "";

        Calendar calendar = Calendar.getInstance();

        calendar.set(YEAR, a-1, b);

        switch (calendar.get(Calendar.DAY_OF_WEEK)){
            case 1:
                answer = "SUN";
                break;
            case 2:
                answer = "MON";
                break;
            case 3:
                answer = "TUE";
                break;
            case 4:
                answer = "WED";
                break;
            case 5:
                answer = "THU";
                break;
            case 6:
                answer = "FRI";
                break;
            case 7:
                answer = "SAT";
                break;
        }
        return answer;
    }

    // Test Case
    public static void main(String[] args) {
        YearOf2016 yearOf2016 = new YearOf2016();

        int a = 5;
        int b = 24;

        System.out.println(yearOf2016.solution(a, b));
    }
}
````