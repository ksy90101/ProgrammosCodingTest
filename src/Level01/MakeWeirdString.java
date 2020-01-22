package Level01;

/**
 * @ClassName : MakeWeirdString
 * @ProblemName : 이상한 문자 만들기
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12930
 */
public class MakeWeirdString {
    public String solution(String s) {
        char[] alphabets = s.toCharArray();
        int wordLength = 0;

        for (int i = 0; i < alphabets.length; i++) {
            if (alphabets[i] == ' ') {
                wordLength = 0;
                continue;
            }

            if (wordLength % 2 == 0 && alphabets[i] >= 'a' && alphabets[i] <= 'z') {
                alphabets[i] -= 32;
            } else if (wordLength % 2 != 0 && alphabets[i] >= 'A' && alphabets[i] <= 'Z') {
                alphabets[i] += 32;
            }
            wordLength++;
        }

        return String.valueOf(alphabets);
    }

    // Test Case
    public static void main(String[] args) {
        MakeWeirdString makeWeirdString = new MakeWeirdString();
        String s = "try hello world";

        System.out.println(makeWeirdString.solution(s));
    }
}
