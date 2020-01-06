package Level01;

import java.util.Arrays;

/**
 * @ClassName : FailToCompletePlayer
 * @ProblemName : 완주하지 못한 선수
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/42576
 */
public class FailToCompletePlayer {

    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < completion.length; i++) {
            if (!completion[i].equals(participant[i])) {
                return participant[i];
            }
        }
        return participant[participant.length - 1];
    }

    // Test Case
    public static void main(String[] args) {
        String[] participant1 = {"leo", "kiki", "eden"};
        String[] completion1 = {"eden", "kiki"};
        String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion2 = {"marina", "josipa", "nikola", "filipa"};
        String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
        String[] completion3 = {"stanko", "mislav", "ana"};

        FailToCompletePlayer failToCompletePlayer = new FailToCompletePlayer();
        System.out.println(failToCompletePlayer.solution(participant1, completion1));
        System.out.println(failToCompletePlayer.solution(participant2, completion2));
        System.out.println(failToCompletePlayer.solution(participant3, completion3));
    }
}
