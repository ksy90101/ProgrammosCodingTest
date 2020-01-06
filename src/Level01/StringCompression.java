package Level01;

/**
 * @ClassName : StringCompression
 * @ProblemName : 문자열 압축
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/60057
 */
public class StringCompression {

    public int solution(String s) {
        final int S_LENGTH = s.length();
        int answer = S_LENGTH;

        for (int i = 1; i <= S_LENGTH / 2; i++) {
            String compareStr1 = "";
            StringBuffer result = new StringBuffer();
            int count = 1;

            for (int j = 0; j < S_LENGTH / i; j++){
                String compareStr2 = s.substring((i * j), (i * j) + i);
                if(compareStr1.equals(compareStr2)){
                    count++;
                    continue;
                }

                result.append((count > 1) ? count + compareStr1 : compareStr1);

                compareStr1 = compareStr2;
                count = 1;
            }

            result.append((count > 1) ? count + compareStr1 : compareStr1);

            if(S_LENGTH % i != 0){
                result.append(s.substring(S_LENGTH - (S_LENGTH % i), S_LENGTH));
            }
            answer = Math.min(result.length(), answer);
        }

        return answer;
    }

    //TestCase
    public static void main(String[] args) {
        StringCompression stringCompression = new StringCompression();

        String testCase1 = "aabbaccc";
        String testCase2 = "ababcdcdababcdcd";
        String testCase3 = "abcabcdede";
        String testCase4 = "abcabcabcabcdededededede";
        String testCase5 = "xababcdcdababcdcd";

        System.out.println(stringCompression.solution(testCase1));
        System.out.println(stringCompression.solution(testCase2));
        System.out.println(stringCompression.solution(testCase3));
        System.out.println(stringCompression.solution(testCase4));
        System.out.println(stringCompression.solution(testCase5));
    }
}
