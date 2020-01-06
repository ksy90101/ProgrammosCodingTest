package Level01;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : FailToCompletePlayerHash
 * @ProblemName : 완주하지 못한 선수 Hash 사용
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/42576
 */
public class FailToCompletePlayerHash {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        int value = 0;
        Map<String, Integer> hashMap = new HashMap<>();

        for(String participantValue: participant){                      // 동명이인이 있을 수 있기 때문에 조건식을 둔것.
            if(hashMap.get(participantValue) == null){
                hashMap.put(participantValue,1);
            }else{
                value = hashMap.get(participantValue) + 1;
                hashMap.put(participantValue, value);
            }
        }

        for (String completionValue : completion){
            value = hashMap.get(completionValue) - 1;
            hashMap.put(completionValue, value);
        }

        for (String key : hashMap.keySet()){
            if(hashMap.get(key) == 1){
                answer = key;
            }
        }

        return answer;
    }

    // Test Case
    public static void main(String[] args) {
        String[] participant1 = {"leo", "kiki", "eden"};
        String[] completion1 = {"eden", "kiki"};
        String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion2 = {"marina", "josipa", "nikola", "filipa"};
        String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
        String[] completion3 = {"stanko", "mislav", "ana"};

        FailToCompletePlayerHash failToCompletePlayer = new FailToCompletePlayerHash();
        System.out.println(failToCompletePlayer.solution(participant1, completion1));
        System.out.println(failToCompletePlayer.solution(participant2, completion2));
        System.out.println(failToCompletePlayer.solution(participant3, completion3));
    }
}
