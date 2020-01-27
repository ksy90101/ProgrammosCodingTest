package Level01;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName : MinNumberRemoval
 * @ProblemName : 제일 작은 수 제거하기
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12935
 */
public class MinNumberRemoval {
    public int[] solution(int[] arr) {
        if (arr.length > 2) {
            List<Integer> answer = Arrays.stream(arr).boxed().collect(Collectors.toList());
            int minNumberIndex = answer.indexOf(Collections.min(answer));
            answer.remove(minNumberIndex);
            return answer.stream().mapToInt(element -> element).toArray();
        }
        return new int[]{-1};
    }

    // Test Case
    public static void main(String[] args) {
        MinNumberRemoval minNumberRemoval = new MinNumberRemoval();
        int[] arr1 = {4, 3, 2, 1};
        int[] arr2 = {10};

        System.out.println(Arrays.toString(minNumberRemoval.solution(arr1)));
        System.out.println(Arrays.toString(minNumberRemoval.solution(arr2)));
    }
}
