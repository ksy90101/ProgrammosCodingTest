package Level01;

/**
 * @ClassName : POrYNumberOfString
 * @ProblemName : 문자열 내 p와 y의 개수
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12916
 */
public class POrYNumberOfString {
    public boolean solution(String s) {
        boolean answer = true;
        int pNumber = 0;
        int yNumber = 0;

        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            pNumber += (s.charAt(i) == 'p') ? 1 : 0;
            yNumber += (s.charAt(i) == 'y') ? 1 : 0;
        }
        answer = (pNumber == yNumber);

        return answer;
    }

    //Test Case
    public static void main(String[] args) {
        POrYNumberOfString pOrYNumberOfString = new POrYNumberOfString();

        String s1 = "pPoooyY";
        String s2 = "Pyy";

        System.out.println(pOrYNumberOfString.solution(s1));
        System.out.println(pOrYNumberOfString.solution(s2));
    }
}
