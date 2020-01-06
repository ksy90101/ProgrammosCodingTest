package Level01;

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
