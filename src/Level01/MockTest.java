package Level01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

/**
 * @ClassName : MockTest
 * @ProblemName : 모의고사
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/42840
 */
public class MockTest {
    public int[] solution(int[] answers) {
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] scores = new int[3];

        OptionalInt maxScore;
        List<Integer> winners = new ArrayList<>();

        for (int i = 0; i < answers.length; i++) {
            scores[0] += (answers[i] == student1[i % 5]) ? 1 : 0;
            scores[1] += (answers[i] == student2[i % 8]) ? 1 : 0;
            scores[2] += (answers[i] == student3[i % 10]) ? 1 : 0;
        }

        maxScore = Arrays.stream(scores).max();

        for (int i = 0; i < scores.length; i++) {
            if (maxScore.getAsInt() == (scores[i])) {
                winners.add(i + 1);
            }
        }

        return winners.stream().mapToInt(winner -> winner).toArray();
    }

    // Test Case
    public static void main(String[] args) {
        MockTest mockTest = new MockTest();
        int[] answers1 = {1, 2, 3, 4, 5};
        int[] answers2 = {1, 3, 2, 4, 2};
        System.out.println(Arrays.toString(mockTest.solution(answers1)));
        System.out.println(Arrays.toString(mockTest.solution(answers2)));
    }
}
