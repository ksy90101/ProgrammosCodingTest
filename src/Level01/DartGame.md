# [프로그래머스] 코딩테스트 연습

## [다트게임](https://programmers.co.kr/learn/courses/30/lessons/17682)

### 간략한 문제 풀이

- [카카오 신입 공채 1차 코딩 테스트 문제 해설](https://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/)

- Level1중에서 어려운 문제에 꼽히는 문제였습니다.
- 일단 문제해설을 살펴보면 문자열 처리(String Manipulation)을 묻는 문제라고 합니다. 한글자씩 잘라서 처리하고 Tokenizing, Semantic Analysis을 통해 계산하는 문제였습니다.
- 처음 생각한 로직대로 충분이 가능했지만, 생각을 못했던 부분이 *인 스타상이 들어오면 해당 점수와 바로 전에 얻은 점수를 각 2배로 만드는 부분을 생각을 못해서 조금 어려웠습니다.
- 코드가 깔끔하지가 않아서 리패토링을 해야 될것 같은데, 지금의 실력으로는 이정도가 최대인것 같습니다.
- 우아한테크코스에서 배웠던 다형성을 이용한 if문 대처방법을 사용하여 깔끔하게 정리는 했지만, if문이 계속 들어가긴 했네요 ㅎㅎ
- 다형성을 이용한 if문은 배운대로 블로그 포스팅을 할 생각입니다.
- 참고한 글들을 아래 링크에 남겨두겠습니다.
    - [다형성을 사용해 if/else를 제거하는 리팩토링을 하라](https://www.slipp.net/questions/566)
    - [Anti-OPP : if를 피하고 싶어서](http://redutan.github.io/2016/03/31/anti-oop-if)
    - [operators - 그것을 가능한 전달하는 연산자는 방법에 java?](https://answeright.com/ko/51527682)
- 크게 설명할 메소드는 없을 것 같습니다.

- [github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level01/DartGame.java)

### 문제 및 풀이

**문제 설명**

카카오톡에 뜬 네 번째 별! 심심할 땐? 카카오톡 게임별~

![Game Star](http://t1.kakaocdn.net/welcome2018/gamestar.png)

카카오톡 게임별의 하반기 신규 서비스로 다트 게임을 출시하기로 했다. 다트 게임은 다트판에 다트를 세 차례 던져 그 점수의 합계로 실력을 겨루는 게임으로, 모두가 간단히 즐길 수 있다.

갓 입사한 무지는 코딩 실력을 인정받아 게임의 핵심 부분인 점수 계산 로직을 맡게 되었다. 다트 게임의 점수 계산 로직은 아래와 같다.

1. 다트 게임은 총 3번의 기회로 구성된다.
2. 각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
3. 점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.
4. 옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 아차상(#) 당첨 시 해당 점수는 마이너스된다.
5. 스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
6. 스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
7. 스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
8. Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
9. 스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.

0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하라.

**입력 형식**

점수|보너스|[옵션]으로 이루어진 문자열 3세트.

예) 1S2D*3T
    - 점수는 0에서 10 사이의 정수이다.
    - 보너스는 S, D, T 중 하나이다.
    - 옵선은 *이나 # 중 하나이며, 없을 수도 있다.

**출력 형식**

3번의 기회에서 얻은 점수 합계에 해당하는 정수값을 출력한다.

예) 37

**입출력 예제**

| 예제 | dartResult | answer | 설명 | 
| :---: | :---: | :---: | :---: | 
| 1 | 1S2D*3T | 37 | 11 * 2 + 22 * 2 + 33 | 
| 2 | 1D2S#10S | 9 | 12 + 21 * (-1) + 101 | 
| 3 | 1D2S0T | 3 | 12 + 21 + 03 | 
| 4 | 1S*2T*3S | 23 | 11 * 2 * 2 + 23 * 2 + 31 | 
| 5 | 1D#2S*3S | 5 | 12 * (-1) * 2 + 21 * 2 + 31 | 
| 6 | 1T2D3D# | -4 | 13 + 22 + 32 * (-1) | 
| 7 | 1D2S3T* | 59 | 12 + 21 * 2 + 33 * 2 | 

````
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
````