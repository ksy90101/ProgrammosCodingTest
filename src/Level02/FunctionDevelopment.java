package Level02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName : FunctionDevelopment
 * @ProblemName : 기능개발
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/42586
 */
public class FunctionDevelopment {
    public static void main(String[] args) {
        FunctionDevelopment functionDevelopment = new FunctionDevelopment();
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        System.out.println(Arrays.toString(functionDevelopment.solution(progresses, speeds)));
    }

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> progressDate = new ArrayList<>();
        final int MAX_PROGRESS = 100;
        int count = 1;
        int temp;

        for (int i = 0; i < progresses.length; i++) {
            progresses[i] = MAX_PROGRESS - progresses[i];
            progressDate.add(progresses[i] / speeds[i]);
        }

        temp = progressDate.get(0);

        progressDate.remove(0);
        while (!progressDate.isEmpty()) {
            if (temp >= progressDate.get(0)) {
                count++;
            } else {
                answer.add(count);
                temp = progressDate.get(0);
                count = 1;
            }
            progressDate.remove(0);
        }

        answer.add(count);

        return answer.stream().mapToInt(n -> n).toArray();
    }
}
