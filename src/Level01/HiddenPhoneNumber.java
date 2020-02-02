package Level01;

/**
 * @ClassName : HiddenPhoneNumber
 * @ProblemName : 핸드폰 번호 가리기
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12948
 */
public class HiddenPhoneNumber {
    public String solution(String phone_number){
        StringBuffer answer = new StringBuffer();

        for (int i = 0; i < phone_number.length()-4; i++){
            answer.append("*");
        }

        answer.append(phone_number.substring(phone_number.length() - 4));

        return answer.toString();
    }

    // Test Case
    public static void main(String[] args) {
        HiddenPhoneNumber hiddenPhoneNumber = new HiddenPhoneNumber();
        String phone_number1 = "01033334444";
        String phone_number2 = "027778888";

        System.out.println(hiddenPhoneNumber.solution(phone_number1));
        System.out.println(hiddenPhoneNumber.solution(phone_number2));
    }
}
