# [프로그래머스] 코딩테스트 연습

## [2016년](https://programmers.co.kr/learn/courses/30/lessons/12901)

### 간략한 문제 풀이

- Calendar 클래스를 이용하여 날짜를 검색하여 요일을 출력하는 문제

- 사실, 월이 1 ~ 12가 아닌, 0 ~ 11이다 보니, 그 부분을 알수 있었다.

- set()메서드에 넣을때 따라서 month인자값에 넣을때 a-1로 했다.

- 날짜 클래스를 쓸수 있는 좋은 문제였던 것 같다.

- [Calendar Class](http://tcpschool.com/java/java_api_calendar)

- [Github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level01/YearOf2016.java)

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