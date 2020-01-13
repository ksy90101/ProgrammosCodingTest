package Level01;

/**
 * @ClassName : StringTreatBasic
 * @ProblemName : 문자열 다루기 기본
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12918
 */
public class StringTreatBasic {
    public boolean solution(String s) {
        boolean answer = true;

        try{
            Integer.parseInt(s);
            if(s.length() == 4 || s.length() == 6){
                return answer;
            }
        }catch (NumberFormatException e){
            answer = false;
        }

        return answer;
    }

    //Test Case
    public static void main(String[] args) {
        StringTreatBasic stringTreatBasic = new StringTreatBasic();

        String s1 = "a234";
        String s2 = "1234";

        System.out.println(stringTreatBasic.solution(s1));
        System.out.println(stringTreatBasic.solution(s2));
    }
}
