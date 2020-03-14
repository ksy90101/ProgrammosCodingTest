package Level02;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName : BridgePassByTruck
 * @ProblemName : 다리를 지나는 트럭
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/42583
 */
public class BridgePassByTruck {
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
}
