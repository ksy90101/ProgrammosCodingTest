package Level01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName : dividingNumberArray
 * @ProblemName : 나누어 떨어지는 숫자 배열
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12910
 */
public class DividingNumberArray {
    public int[] solution(int[] arr, int divisor) {

        List<Integer> dividingNumbers = new ArrayList<>();

        int[] answer = {-1};
        for (int number : arr) {
            if (number % divisor == 0) {
                dividingNumbers.add(number);
            }
        }

        dividingNumbers.sort(null);

        if (dividingNumbers.isEmpty()) {
            return answer;
        } else {
            answer = dividingNumbers.stream().mapToInt(n -> n).toArray();
        }
        return answer;
    }

    // Test Case
    public static void main(String[] args) {
        DividingNumberArray dividingNumberArray = new DividingNumberArray();

        int[] arr1 = {5, 9, 7, 10};
        int[] arr2 = {2, 36, 1, 3};
        int[] arr3 = {3, 2, 6};

        int divisor1 = 5;
        int divisor2 = 1;
        int divisor3 = 10;

        System.out.println(Arrays.toString(dividingNumberArray.solution(arr1, divisor1)));
        System.out.println(Arrays.toString(dividingNumberArray.solution(arr2, divisor2)));
        System.out.println(Arrays.toString(dividingNumberArray.solution(arr3, divisor3)));
    }
}
