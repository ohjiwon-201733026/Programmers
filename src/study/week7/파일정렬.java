package study.week7;

import java.util.ArrayList;
import java.util.Collections;


public class 파일정렬 {
//img12.png
    public static void main(String[] args) {
        String [] files={"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        String [] answer=solution(files);
        for(String s: answer) System.out.println(s);
    }

    public static class File implements Comparable<File>{
        String head; // 원래 head
        String lowerHead; // 소문자 head
        String originNum; //원래 number
        int number;  
        String tail;

        public File(String head, String lowerHead,String originNum,int number,String tail){ // 생성자
            this.head=head;
            this.lowerHead=lowerHead;
            this.originNum=originNum;
            this.number=number;
            this.tail=tail;
        }

        @Override
        public int compareTo(File o) { // 정렬 head -> number
            if(this.lowerHead.equals(o.lowerHead)) return this.number-o.number;
            return this.lowerHead.compareTo(o.lowerHead);
        }

        public void print(){
            System.out.println(head+" ,"+lowerHead+", "+originNum+","+number+","+tail);
        }

        public String append(){
            return this.head+this.originNum+this.tail;
        } // head+number+tail
    }

    private static String[] solution(String[] files) {
        String [] answer=new String [files.length];
        ArrayList<File> fileList=new ArrayList<>();

        for(String file:files){
            int headEnd=setHead(file); // number 시작 idx
            String head=file.substring(0,headEnd); // head
            String lowerHead=head.toLowerCase(); // 소문자 head
            int numEnd=setNum(file,headEnd); // tail 시작 idx
            String originNum=file.substring(headEnd,numEnd); // 원래 number
            int num=Integer.parseInt(originNum); // int number
            String tail=file.substring(numEnd); // tail
            fileList.add(new File(head,lowerHead,originNum,num,tail));
        }

        Collections.sort(fileList); // 정렬
        for(int i=0;i<fileList.size();++i) answer[i]=fileList.get(i).append();

        return answer;
    }
 
    private static int setNum(String file, int headEnd) { // number 범위 ( 숫자 아니면 break )
        int i=0;
        for(i=headEnd;i<file.length();++i){
            char c=file.charAt(i);
            if(!(c>='0'&&c<='9')) break;
        }

        return i;
    }

    private static int setHead(String file) { // 숫자 나오면 break
        int i=0;
        for(i=0;i<file.length();++i){
            char c=file.charAt(i);
            if(c>='0'&&c<='9') break;
        }

        return i;
    }
}
