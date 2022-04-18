package BaekJoon;

import java.util.Scanner;

public class B3568_iSharp {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        s=s.substring(0,s.length()-1);

        String [] arr=s.split(",");

        String base=arr[0].split(" ")[0];
        arr[0]=arr[0].split(" ")[1];
        for(int i=1;i<arr.length;++i) arr[i]=arr[i].trim();

        for (String str : arr) {
            int idx=getIdx(str);
            String var=str.substring(0,idx);
            String add=reverse(str.substring(idx));

            System.out.println(base+add+" "+var+";");
        }

    }
    static String reverse(String s){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();++i){
            char c=s.charAt(i);
            if(c=='[') {
                sb.insert(0,"[]");
                i++;
            }
            else sb.insert(0,c);
        }
        return sb.toString();
    }

    static int getIdx(String s){
        int i=0;
        for(i=0;i<s.length();++i){
            char c=s.charAt(i);
            if(c=='*' || c=='[' || c==']' || c=='&') return i;
        }
        return i;
    }
}
