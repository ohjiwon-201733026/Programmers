package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class 파일명정렬 {

    @Test
    public void test(){
        String [] answer={"img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"};
        String [] result=solution(new String []{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"});

        for(int i=0;i<answer.length;++i){
            Assertions.assertEquals(answer[i],result[i]);
        }

        answer=new String []{"A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"};
        result=solution(new String []{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"});

        for(int i=0;i<answer.length;++i){
            Assertions.assertEquals(answer[i],result[i]);
        }
    }

    public String [] solution(String [] files){

        ArrayList<File> list=new ArrayList<>();

        for (String file : files) {
            int headEnd=getHeadIdx(file);
            String head=file.substring(0,headEnd);
            int numberEnd=getNumberIdx(headEnd,file);
            String number=file.substring(headEnd,numberEnd);
            String tail=file.substring(numberEnd);

            list.add(new File(head,number,tail));
        }
        String [] answer=new String[list.size()];
        Collections.sort(list);

        for(int i=0;i<answer.length;++i){
            answer[i]=list.get(i).str();
        }


        return answer;

    }
    public int getNumberIdx(int start,String s){
        s=s.toLowerCase();
        int i=start;
        for(i=start;i<s.length();++i){
            char c=s.charAt(i);
            if('0'<=c && c<='9') continue;
            else break;
        }

        return i;
    }

    public int getHeadIdx(String s){

        for(int i=0;i<s.length();++i){
            char c=s.charAt(i);
            if('0'<=c && c<='9') return i;
        }
        return -1;
    }

    static class File implements Comparable<File>{
        String head;
        String number;
        String tail;

        public File(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        public String str(){
            return head+number+tail;
        }

        @Override
        public int compareTo(File o) {
            if(this.head.toLowerCase().compareTo(o.head.toLowerCase())==0){
                return Integer.parseInt(this.number)-Integer.parseInt(o.number);
            }
            return this.head.toLowerCase().compareTo(o.head.toLowerCase());
        }
    }
}
