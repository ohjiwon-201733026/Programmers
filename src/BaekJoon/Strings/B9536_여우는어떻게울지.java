package BaekJoon.Strings;

import java.util.Scanner;

public class B9536_여우는어떻게울지 {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        String T=sc.nextLine();
        int t=Integer.parseInt(T);
        while(t-->0){
            String [] goes=sc.nextLine().split(" ");

            while(true){
                String s=sc.nextLine();
                if(s.equals("what does the fox say?")) break;
                String [] arr=s.split(" ");

               for(int i=0;i<goes.length;++i){
                   if(goes[i].equals(arr[2])) goes[i]="";
               }
            }
            StringBuilder sb=new StringBuilder();
            for(int i=0;i< goes.length;++i){
                if(goes[i].equals("")) continue;
                else sb.append(goes[i]+" ");
            }
            System.out.println(sb.toString());
        }


    }
}
