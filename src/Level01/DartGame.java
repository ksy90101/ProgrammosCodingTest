package Level01;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName : DartGame
 * @ProblemName : 다트게임
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/17682
 */
public class DartGame {
    public int solution(String dartResult) {
        int answer = 0;
        String[] splittedDartResults = dartResult.split("");
        StringBuilder score = new StringBuilder();
        List<Integer> scores = new ArrayList<>();
        for (String splittedDartResult : splittedDartResults) {
            if (BONUS.get(splittedDartResult) == null) {
                score.append(splittedDartResult);
            } else if (splittedDartResult.equals("*")) {
                if (scores.size() == 1) {
                    scores.set(scores.size() - 1, BONUS.get(splittedDartResult).apply(scores.get(scores.size() - 1)));
                } else {
                    scores.set(scores.size() - 1, BONUS.get(splittedDartResult).apply(scores.get(scores.size() - 1)));
                    scores.set(scores.size() - 2, BONUS.get(splittedDartResult).apply(scores.get(scores.size() - 2)));
                }
            } else if (splittedDartResult.equals("#")) {
                scores.set((scores.size() - 1), BONUS.get(splittedDartResult).apply(scores.get((scores.size() - 1))));
            } else {
                scores.add(BONUS.get(splittedDartResult).apply(Integer.parseInt(score.toString())));
                score.delete(0, score.length());
            }
        }

        for (int i = 0; i < scores.size(); i++) {
            answer += scores.get(i);
        }
        return answer;
    }

    private final static Map<String, Bonus> BONUS = new HashMap<>();

    static {
        BONUS.put("S", Bonus.SINGLE);
        BONUS.put("D", Bonus.DOUBLE);
        BONUS.put("T", Bonus.TRIPLE);
        BONUS.put("*", Bonus.STAR);
        BONUS.put("#", Bonus.SUBORDINATE);
    }

    // Test Case
    public static void main(String[] args) {
        DartGame dartGame = new DartGame();
        String[] dartResults = {"1S2D*3T", "1D2S#10S", "1D2S0T", "1S*2T*3S", "1D#2S*3S", "1T2D3D#", "1D2S3T*"};

        List<Integer> answers = Arrays.stream(dartResults).map(dartGame::solution).collect(Collectors.toList());
        System.out.println(answers);
    }
}

enum Bonus {
    SINGLE("S") {
        @Override
        public int apply(int score) {
            return (int) Math.pow(score, 1);
        }
    },
    DOUBLE("D") {
        @Override
        public int apply(int score) {
            return (int) Math.pow(score, 2);
        }
    },
    TRIPLE("T") {
        @Override
        public int apply(int score) {
            return (int) Math.pow(score, 3);
        }
    },
    STAR("*") {
        @Override
        public int apply(int score) {
            return score * 2;
        }
    },
    SUBORDINATE("#") {
        @Override
        public int apply(int score) {
            return -score;
        }
    };

    private final String textBonus;

    private Bonus(String textBonus) {
        this.textBonus = textBonus;
    }

    public abstract int apply(int score);
}
