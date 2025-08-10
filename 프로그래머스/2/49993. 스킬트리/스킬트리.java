import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        char[] temp = skill.toCharArray();
        int answer = 0;
        List<Character> sk = new ArrayList<>();
        for (char c : temp){
            sk.add(c);
        }
        for (String str : skill_trees) {
            char[] skillTree = str.toCharArray();
            List<Character> skillList = new ArrayList<>();
            for (char c : skillTree) {
                if (sk.contains(c)) {
                    skillList.add(c);
                }
            }
            // System.out.println(skillList);
            
            if(skillList.size() > 0) {
                boolean check = true;
                for (int i = 0; i<skillList.size(); i++) {
                    if(skillList.get(i) != temp[i]) check = false;
                }
                if(check) answer++;
            } else {
                answer++;
            }
        }
        return answer;
    }
}