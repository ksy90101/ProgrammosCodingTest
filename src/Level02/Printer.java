package Level02;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @ClassName : Printer
 * @ProblemName : 프린터
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/42587
 */
public class Printer {
    public static void main(String[] args) {
        Printer printer = new Printer();
        int[] priorities1 = {2, 1, 3, 2};
        int[] priorities2 = {1, 1, 9, 1, 1, 1};
        int location1 = 2;
        int location2 = 0;

        System.out.println(printer.solution(priorities1, location1));
        System.out.println(printer.solution(priorities2, location2));
    }

    public int solution(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int priority : priorities) {
            priorityQueue.add(priority);
        }

        while (!priorityQueue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == priorityQueue.peek()) {
                    if (i == location) {
                        return answer;
                    }
                    priorityQueue.poll();
                    answer++;
                }
            }
        }
        return answer;
    }
}
