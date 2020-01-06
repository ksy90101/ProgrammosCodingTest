package Level01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName : NoCommonNumber
 * @ProblemName : 같은 숫자는 싫어
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12906
 */
public class NoCommonNumber {
    public int[] solution(int[] arr) {
        int[] answer = {};
        List<Integer> numberFilter = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                numberFilter.add(arr[i]);
            }
            if (i == arr.length - 2){
                numberFilter.add(arr[i+1]);
            }
        }

        answer = numberFilter.stream().mapToInt(number -> number).toArray();

        return answer;
    }

    // Test Case
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 3, 3, 0, 1, 1};
        int[] arr2 = {4, 4, 4, 3, 3};

        NoCommonNumber noCommonNumber = new NoCommonNumber();

        System.out.println(Arrays.toString(noCommonNumber.solution(arr1)));
        System.out.println(Arrays.toString(noCommonNumber.solution(arr2)));
    }
}
