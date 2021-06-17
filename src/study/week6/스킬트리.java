package study.week6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class 스킬트리 {

    public static void main(String[] args) {
        String skill="CBD";
        String [] skill_trees={"BACDE", "CBADF", "AECB", "BDA"};
        int answer=solution(skill,skill_trees);
        System.out.println(answer);

    }

    private static int solution(String skill, String[] skill_trees) {
        int answer=0;

        String [] skills=skill.split("");
        Stack<String> stack=new Stack<>();

        boolean flag=false;

        for(String s:skill_trees){
            flag=false;
            stack.clear();

            for(int k= skills.length-1;k>=0;--k){
                stack.push(skills[k]);
            }

            String [] temp=s.split("");

            for(int i=0;i<temp.length;++i){
                if(skill.indexOf(temp[i])!=-1){
                    if(stack.peek().equals(temp[i])) stack.pop();
                    else{
                        flag=true;
                        break;
                    }
                }
            }

            if(!flag) answer++;
        }

        return answer;
    }
}
