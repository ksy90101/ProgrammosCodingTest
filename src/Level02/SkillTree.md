# [프로그래머스] 코딩테스트 연습

## [스킬트리](https://programmers.co.kr/learn/courses/30/lessons/49993)

### 간략한 문제 풀이
- 정의한 `Skill`의 순서에 맞게 배웠어야 제대로된 `SkillTree`인 것을 찾는 문제였습니다.

- 따라서, 인덱스를 찾아서 비교한다면 문제가 풀릴거 같았습니다.

- 따라서 `String.indexOf()`를 이용하여 인덱스를 찾았습니다.

#### String.indexOf()
````
indexOf(String str)
indexOf(char ch)
indexOf(char ch, int fromIndex)
indexOf(String str, int fromIndex)
````
- 문자열에서 특정 문자의 `index`를 찾는 메서드입니다.

- 앞에서부터 처음 발견되는 인덱스를 반환하며, 찾지 못했을 경우 "-1"을 반환합니다.

- 시작할 위치도 지정할 수 있는데, 시작 위치을 생략한다면 0번째 인덱스 부터 찾기 시작합니다.

- [Github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level02/SkillTree.java)

### 문제 및 풀이

**문제 설명**

선행 스킬이란 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬을 뜻합니다.

예를 들어 선행 스킬 순서가 스파크 → 라이트닝 볼트 → 썬더일때, 썬더를 배우려면 먼저 라이트닝 볼트를 배워야 하고, 라이트닝 볼트를 배우려면 먼저 스파크를 배워야 합니다.

위 순서에 없는 다른 스킬(힐링 등)은 순서에 상관없이 배울 수 있습니다. 따라서 스파크 → 힐링 → 라이트닝 볼트 → 썬더와 같은 스킬트리는 가능하지만, 썬더 → 스파크나 라이트닝 볼트 → 스파크 → 힐링 → 썬더와 같은 스킬트리는 불가능합니다.

선행 스킬 순서 skill과 유저들이 만든 스킬트리1를 담은 배열 skill_trees가 매개변수로 주어질 때, 가능한 스킬트리 개수를 return 하는 solution 함수를 작성해주세요.

**제한 조건**

스킬은 알파벳 대문자로 표기하며, 모든 문자열은 알파벳 대문자로만 이루어져 있습니다.

스킬 순서와 스킬트리는 문자열로 표기합니다.

예를 들어, C → B → D 라면 CBD로 표기합니다

선행 스킬 순서 skill의 길이는 1 이상 26 이하이며, 스킬은 중복해 주어지지 않습니다.

- skill_trees는 길이 1 이상 20 이하인 배열입니다.
- skill_trees의 원소는 스킬을 나타내는 문자열입니다.
- skill_trees의 원소는 길이가 2 이상 26 이하인 문자열이며, 스킬이 중복해 주어지지 않습니다.

**입출력 예**

| skill | skill_trees | return |
| :---: | :---: | :---: |
| "CBD"	| ["BACDE", "CBADF", "AECB", "BDA"] | 2 |

**입출력 예 설명**

- BACDE: B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트립니다.
- CBADF: 가능한 스킬트리입니다.
- AECB: 가능한 스킬트리입니다.
- BDA: B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트리입니다.

1. 스킬 트리: 유저가 스킬을 배울 순서

````java
package Level02;

/**
 * @ClassName : SkillTree
 * @ProblemName : 스킬트리
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/49993
 */
public class SkillTree {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        int beforeIndex;
        int currentIndex;

        for (String skill_tree : skill_trees) {
            beforeIndex = skill_tree.indexOf(skill.charAt(0));

            for (int j = 1; j < skill.length(); j++) {
                currentIndex = skill_tree.indexOf(skill.charAt(j));
                if ((beforeIndex > currentIndex && currentIndex != -1) || (beforeIndex == -1 && currentIndex != -1)) {
                    answer--;
                    break;
                }
                beforeIndex = currentIndex;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        SkillTree skillTree = new SkillTree();
        System.out.println(skillTree.solution(skill, skill_trees));
    }
}
````