package Level01;

import java.util.*;

/**
 * @ClassName : FailureRate
 * @ProblemName : 실패율
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/42889
 */
public class FailureRate {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        List<Stage> stageObjects = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            stageObjects.add(new Stage(i + 1));
        }

        for (int stage : stages) {
            for (int j = 0; j < stage; j++) {
                if (j == stage - 1 && stage > N) {
                    break;
                }
                stageObjects.get(j).reachUser++;
            }
            if (stage > N) continue;
            stageObjects.get(stage - 1).stayUser++;
        }

        for (int i = 0; i < N; i++) {
            stageObjects.get(i).failureRateCalculator();
        }

        StageComparator stageComparator = new StageComparator();
        stageObjects.sort(stageComparator);

        for (int i = 0; i < N; i++) {
            answer[i] = stageObjects.get(i).stageNumber;
        }

        return answer;
    }

    // Test Case
    public static void main(String[] args) {
        FailureRate failureRate = new FailureRate();
        int N1 = 5;
        int N2 = 4;
        int[] stages1 = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] stages2 = {4, 4, 4, 4, 4};

        System.out.println(Arrays.toString(failureRate.solution(N1, stages1)));
        System.out.println(Arrays.toString(failureRate.solution(N2, stages2)));
    }
}

class Stage {
    int reachUser;
    int stayUser;
    int stageNumber;
    double failureRate;

    public Stage(int stageNumber) {
        this.stageNumber = stageNumber;
    }

    public void failureRateCalculator() {
        if (reachUser == 0) {
            this.failureRate = 0.0;
            return;
        }
        this.failureRate = (double) this.stayUser / this.reachUser;
    }
}

class StageComparator implements Comparator<Stage> {
    @Override
    public int compare(Stage o1, Stage o2) {
        double firstValue = o1.failureRate;
        double secondValue = o2.failureRate;
        return Double.compare(secondValue, firstValue);
    }
}