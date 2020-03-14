# [프로그래머스] 코딩테스트 연습

## [다리를 지나는 트럭](https://programmers.co.kr/learn/courses/30/lessons/42583)

### 간략한 문제 풀이

- 제대로된 큐를 사용하는 알고리즘 문제였다.

- `멀쩡한 사각형` 이후로 제일 어려웠던 문제였다고 생각한다.

- 트럭을 하나씩 빼면서 다리 위에 올리는데, 계속해서 무게와 비교하면서 시간을 더해주는 것이다.

- 문제에서 나오는 조건을 조건문으로 고쳐나가는 부분이 어려웠다...ㅎㅎ

- [Github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level02/BridgePassByTruck.java)

### 문제 및 풀이

**문제 설명**

트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다. 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.
트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.

예를 들어, 길이가 2이고 10kg 무게를 견디는 다리가 있습니다. 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.

| 경과 시간 | 다리를 지난 트럭 | 다리를 건너는 트럭 | 대기 트럭 | 
| :---: | :---: | :---: | :----: |  
| 0 | [] | [] | [7,4,5,6] | 
| 1~2 | [] | [7] | [4,5,6] | 
| 3 | [7] | [4] | [5,6] | 
| 4 | [7] | [4,5] | [6] | 
| 5 | [7,4] | [5] | [6] | 
| 6~7 | [7,4,5] | [6] | [] | 
| 8 | [7,4,5,6] | [] | [] | 

따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.

solution 함수의 매개변수로 다리 길이 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭별 무게 truck_weights가 주어집니다. 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.

**제한 조건**

- bridge_length는 1 이상 10,000 이하입니다.
- weight는 1 이상 10,000 이하입니다.
- truck_weights의 길이는 1 이상 10,000 이하입니다.
- 모든 트럭의 무게는 1 이상 weight 이하입니다.

**입출력 예**

| bridge_length | weight | truck_weights | return |
| :---: | :---: | :---: | :---:  
| 2 | 10 | [7,4,5,6] | 8 | 
| 100 | 100	[10] | 101 | 
| 100 | 100	[10,10,10,10,10,10,10,10,10,10]	110 | 

[출처](http://icpckorea.org/2016/ONLINE/problem.pdf)

````java
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName : BridgePassByTruck
 * @ProblemName : 다리를 지나는 트럭
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/42583
 */
public class BridgePassByTruck {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int[] endTime = new int[truck_weights.length];
        Queue<Integer> onBridge = new LinkedList<>();
        int currentBridgeWeight = 0;

        do {
            if (currentBridgeWeight < truck_weights.length && truck_weights[currentBridgeWeight] <= weight) {
                onBridge.add(currentBridgeWeight);
                endTime[currentBridgeWeight] = answer + bridge_length;
                weight -= truck_weights[currentBridgeWeight];
                currentBridgeWeight++;
            }

            if (!onBridge.isEmpty() && endTime[onBridge.peek()] == answer) {
                weight += truck_weights[onBridge.poll()];
            }

            answer++;
        } while (!onBridge.isEmpty());

        return answer;
    }

    public static void main(String[] args) {
        BridgePassByTruck bridgePassByTruck = new BridgePassByTruck();
        int bridge_length1 = 2;
        int weight1 = 10;
        int[] truck_weights1 = {7, 4, 5, 6};
        int bridge_length2 = 100;
        int weight2 = 100;
        int[] truck_weights2 = {10};
        int bridge_length3 = 100;
        int weight3 = 100;
        int[] truck_weights3 = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        System.out.println(bridgePassByTruck.solution(bridge_length1, weight1, truck_weights1));
        System.out.println(bridgePassByTruck.solution(bridge_length2, weight2, truck_weights2));
        System.out.println(bridgePassByTruck.solution(bridge_length3, weight3, truck_weights3));
    }
}
````