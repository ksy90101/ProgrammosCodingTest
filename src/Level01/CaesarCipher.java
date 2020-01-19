package Level01;

import java.util.Arrays;

/**
 * @ClassName : CaesarCipher
 * @ProblemName : 시저암호
 * @URL :https://programmers.co.kr/learn/courses/30/lessons/12926
*/
public class CaesarCipher {
    public String solution(String s, int n){
        StringBuffer answer = new StringBuffer();
        char[] uppers = new char[26];
        int temp = 0;

        for (int i = 0; i < uppers.length; i++){
            uppers[i] = (char)('A' + i);
        }

        for (char c : s.toCharArray()){
            if (c == ' '){
                answer.append(c);
                continue;
            }

            temp = Arrays.binarySearch(uppers, Character.toUpperCase(c)) + n;
            temp -= (temp > 25) ? 26 : 0;

            if(Character.isUpperCase(c)){
                answer.append(uppers[temp]);
            }else if(Character.isLowerCase(c)){
                answer.append(Character.toLowerCase(uppers[temp]));
            }
        }
        return answer.toString();
    }

    // Test Case
    public static void main(String[] args) {
        CaesarCipher caesarCipher = new CaesarCipher();

        String s1 = "AB";
        String s2 = "z";
        String s3 = "a B z";

        int n1 = 1;
        int n2 = 1;
        int n3 = 4;

        System.out.println(caesarCipher.solution(s1, n1));
        System.out.println(caesarCipher.solution(s2, n2));
        System.out.println(caesarCipher.solution(s3, n3));
    }
}
