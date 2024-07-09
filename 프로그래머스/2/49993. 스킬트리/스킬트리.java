class Solution {
    public int solution(String skill, String[] skill_trees) {
        String[] skills = skill.split("");
        int count = 0;

        for (String skill_tree : skill_trees) {
            boolean flag = true;

            int nextSkillIndex = -1;
            int endCount = 0;
            boolean notNext = false;

            for(String s : skills) {

                if(nextSkillIndex < skill_tree.indexOf(s)) {
                    if (notNext) flag = false;
                    nextSkillIndex = skill_tree.indexOf(s);
                    endCount++;
                }else if(skill_tree.contains(s) && nextSkillIndex >= skill_tree.indexOf(s)) {
                    flag = false;
                }else {
                    notNext = true;
                }
            }

            if (flag) {
                count++;
            }
        }

        return count;
    }
}