# [프로그래머스] 코딩테스트 연습

## [완주하지 못한 선수](https://programmers.co.kr/learn/courses/30/lessons/42576)

### 간략한 문제 풀이

- 검색 알고리즘이라고 생각하여, 정렬 후 하나씩 비교하는 것이 더 빠르다고 생각했습니다.

- 프로그래머스에서 해시로 구분이 되어있어서 정렬한 후와 해시로 푼 경우 두가지를 해봤습니다.

- Arrays.sort()로 배열을 정렬하였습니다.

- hash 알고리즘은 너무 어렵네요 ㅠㅠ

- 뭔가 더 아름답게(?) 할수 있을 것 같은데.... 아직 실력 부족인듯..ㅠㅠ

#### 해쉬 

- [Java HashMap은 어떻게 동작하는가?](https://d2.naver.com/helloworld/831311)
- 어려운 개념이지만, 위의 글을 한번 보는 것이 많은 도움이 될듯..

### 문제 및 풀이

**문제 설명**

수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

**제한사항**

마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.

completion의 길이는 participant의 길이보다 1 작습니다.

참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.

참가자 중에는 동명이인이 있을 수 있습니다.

**입출력 예**

| participant | completion | return | 
| :---: | :---: | :---: | 
| [leo, kiki, eden] | [eden, kiki] | leo | 
| [marina, josipa, nikola, vinko, filipa] | [josipa, filipa, marina, nikola] | vinko | 
| [mislav, stanko, mislav, ana] | [stanko, ana, mislav] | mislav | 

**입출력 예 설명**

예제 #1

leo는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

예제 #2

vinko는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

예제 #3

mislav는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.

- Hash 사용 X
````
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
````

- Hash 사용 O
````
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
````