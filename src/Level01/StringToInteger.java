package Level01;

/**
 * @ClassName : StringToInteger
 * @ProblemName : 문자열을 정수로 바꾸기
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12925
 */
public class StringToInteger {
    public int solution(String s){
        int answer = Integer.parseInt(s);

        return answer;
    }

    // Test Case
    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();

        String str1 = "1234";
        String str2 = "-1234";

        System.out.println(stringToInteger.solution(str1));
        System.out.println(stringToInteger.solution(str2));

    }
}
