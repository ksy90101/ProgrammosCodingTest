package Level01;

/**
 * @ClassName : SuBack
 * @ProblemName : 수박수박수박수박수박수?
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12922
 */
public class SuBack {
    public String solution(int n) {
        StringBuffer answer = new StringBuffer();
        final char SU = '수';
        final char BACK = '박';

        for (int i = 1; i <= n; i++) {
            answer.append((i % 2 == 0)?BACK : SU);
        }
        return answer.toString();
    }

    // Test Case
    public static void main(String[] args) {
        SuBack suBack = new SuBack();
        int n1 = 3;
        int n2 = 4;

        System.out.println(suBack.solution(n1));
        System.out.println(suBack.solution(n2));

    }
}
