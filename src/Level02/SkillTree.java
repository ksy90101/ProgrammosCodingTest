package Level02;

/**
 * @ClassName : SkillTree
 * @ProblemName : 스킬트리
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/49993
 */
public class SkillTree {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        SkillTree skillTree = new SkillTree();
        System.out.println(skillTree.solution(skill, skill_trees));
    }

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
}
