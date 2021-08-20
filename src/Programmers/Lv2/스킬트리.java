package Programmers.Lv2;

public class 스킬트리 {
    public static void main(String [] args){
        String skill="CBD";
        String [] skill_trees={"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(solution(skill,skill_trees));
    }

    public static int solution(String skill, String [] skills){
        int answer=0;
        for(String s: skills){
            s=s.replaceAll("[^"+skill+"]","");
            int i=0,j=0;
            boolean flag=true;
            for(i=0;i<s.length();++i){
                if(skill.charAt(j)!=s.charAt(i)) flag=false;
                else j++;
            }
            if(flag) answer++;

        }
        return answer;
    }

}
