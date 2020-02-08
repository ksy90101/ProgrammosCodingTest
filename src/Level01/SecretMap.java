package Level01;

import java.util.Arrays;

/**
 * @ClassName : SecretMap
 * @ProblemName : 비밀지도
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/17681
 */
public class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        StringBuilder secretMapSide = new StringBuilder();
        for (int i = 0; i < arr1.length; i++) {
            secretMapSide.delete(0, secretMapSide.length());
            String arr1OrArr2Binary = Integer.toBinaryString(arr1[i] | arr2[i]);
            String[] binaryValues = arr1OrArr2Binary.split("");

            for (String binaryValue : binaryValues) {
                if (binaryValue.equals("1")) {
                    secretMapSide.append("#");
                    continue;
                }
                secretMapSide.append(" ");
            }

            while (secretMapSide.length() != n){
                secretMapSide.insert(0, " ");
            }

            answer[i] = secretMapSide.toString();
        }
        return answer;
    }

    // Test Case
    public static void main(String[] args) {
        SecretMap secretMap = new SecretMap();
        int n1 = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        int n2 = 6;
        int[] arr3 = {46, 33, 33, 22, 31, 50};
        int[] arr4 = {27, 56, 19, 14, 14, 10};

        System.out.println(Arrays.toString(secretMap.solution(n1, arr1, arr2)));
        System.out.println(Arrays.toString(secretMap.solution(n2, arr3, arr4)));

    }
}
