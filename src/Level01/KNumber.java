package Level01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName : KNumber
 * @ProblemName : k번째수
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/42748
 */
public class KNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList();

        for (int[] command : commands) {
            int[] tempArray = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(tempArray);
            answerList.add(tempArray[command[2] - 1]);
        }

        answer = answerList.stream().mapToInt(i -> i).toArray();

        return answer;
    }

    // Test Case
    public static void main(String[] args) {
        KNumber kNumber = new KNumber();

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        System.out.println(Arrays.toString(kNumber.solution(array, commands)));
    }
}
