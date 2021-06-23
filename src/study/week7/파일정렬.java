package study.week7;

import java.util.ArrayList;
import java.util.Collections;


public class 파일정렬 {

    public static void main(String[] args) {
        String [] files={"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        String [] answer=solution(files);
        for(String s: answer) System.out.println(s);
    }

    public static class File implements Comparable<File>{
        String head; // 원래 head
        String lowerHead;
        String originNum; //원래 number
        int number;
        String tail;

        public File(String head, String lowerHead,String originNum,int number,String tail){
            this.head=head;
            this.lowerHead=lowerHead;
            this.originNum=originNum;
            this.number=number;
            this.tail=tail;
        }

        @Override
        public int compareTo(File o) {
            if(this.lowerHead.equals(o.lowerHead)) return this.number-o.number;
            return this.lowerHead.compareTo(o.lowerHead);
        }

        public void print(){
            System.out.println(head+" ,"+lowerHead+", "+originNum+","+number+","+tail);
        }

        public String append(){
            return this.head+this.originNum+this.tail;
        }
    }

    private static String[] solution(String[] files) {
        String [] answer=new String [files.length];
        ArrayList<File> fileList=new ArrayList<>();

        for(String file:files){
            int headEnd=setHead(file);
            String head=file.substring(0,headEnd);
            String lowerHead=head.toLowerCase();
            int numEnd=setNum(file,headEnd);
            String originNum=file.substring(headEnd,numEnd);
            int num=Integer.parseInt(originNum);
            String tail=file.substring(numEnd);
            fileList.add(new File(head,lowerHead,originNum,num,tail));
        }

        Collections.sort(fileList);
        for(int i=0;i<fileList.size();++i) answer[i]=fileList.get(i).append();

        return answer;
    }

    private static int setNum(String file, int headEnd) {
        int i=0;
        for(i=headEnd;i<file.length();++i){
            char c=file.charAt(i);
            if(!(c>='0'&&c<='9')) break;
        }

        return i;
    }

    private static int setHead(String file) {
        int i=0;
        for(i=0;i<file.length();++i){
            char c=file.charAt(i);
            if(c>='0'&&c<='9') break;
        }

        return i;
    }
}
