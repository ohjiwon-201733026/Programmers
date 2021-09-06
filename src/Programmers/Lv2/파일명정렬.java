package Programmers.Lv2;

import java.util.ArrayList;
import java.util.Collections;

public class 파일명정렬 {
    public static void main(String [] args){
        String [] files={"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        String [] result=solution(files);
        for(String s:result) System.out.println(s);
    }

    public static class File implements Comparable<File>{
        String head_lower;
        String head;
        int number_;
        String number;
        String tail;

        public File(String head_lower, String head, int number_, String number, String tail) {
            this.head_lower = head_lower;
            this.head = head;
            this.number_ = number_;
            this.number = number;
            this.tail = tail;
        }

        @Override
        public int compareTo(File o) {
            if(this.head_lower.equals(o.head_lower)){
                return this.number_-o.number_;
            }
            return this.head_lower.compareTo(o.head_lower);
        }
    }
    public static String [] solution(String [] files){
        ArrayList<File> list=new ArrayList<>();
        for(String file:files){

            int i=head(file);
            String head=file.substring(0,i);
            String head_lower=head.toLowerCase();
            file=file.substring(i);
            int j=number(file);
            String number=file.substring(0,j);
            int number_=Integer.parseInt(number);
            String tail=file.substring(j);
            list.add(new File(head_lower, head, number_,number,tail));
        }
        Collections.sort(list);

        String [] answer=new String[list.size()];
        for(int i=0;i<list.size();++i){
            File f=list.get(i);
            answer[i]=f.head+f.number+f.tail;
        }

        return answer;
    }

    public static int head(String s){
        s=s.toLowerCase();
        for(int i=0;i<s.length();++i){
            char c=s.charAt(i);
            if('0'<=c && c<='9') return i;
        }
        return -1;
    }
    public static int number(String s){
        int i=0;
        for(i=0;i<s.length();++i){
            char c=s.charAt(i);
            if('0'>c || c>'9') return i;
        }
        return i;
    }

}
