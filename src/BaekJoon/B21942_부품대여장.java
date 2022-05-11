package BaekJoon;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class B21942_부품대여장 {

    public static void main(String[] args) throws ParseException {
        Scanner sc=new Scanner(System.in);
        String[] a=sc.nextLine().split(" ");
        int N=Integer.parseInt(a[0]);
        long L=toMin(a[1]); // 대여 기간(분)
        int F=Integer.parseInt(a[2]); // 분당 벌금
        HashMap<String, ArrayList<String>> hm=new HashMap<>();
        HashMap<String,Long> fair=new HashMap<>();

        for(int i=0;i<N;++i){
            a=sc.nextLine().split(" ");

            String time=a[0]+" "+a[1];
            String key=a[3]+","+a[2];
            if(!hm.containsKey(key)){
                hm.put(key,new ArrayList<>());
            }
             hm.get(key).add(time);

        }


        for (String s : hm.keySet()) {
            long time=getTime(hm.get(s).get(0),hm.get(s).get(1));
            if(time>L){
                time-=L;
                String name=s.split(",")[0];
                if(fair.containsKey(name)){
                    fair.put(name,fair.get(name)+time*F);
                }
                else fair.put(name,time*F);
            }

        }


        if(fair.size()==0) System.out.println(-1);
        else {
            ArrayList<String> tmp=new ArrayList<>();
            for (String s : fair.keySet()) {
                tmp.add(s + " " + fair.get(s));
            }

            Collections.sort(tmp);
            for (String s : tmp) {
                System.out.println(s);
            }
        }


    }

    public static long getTime(String a,String b) throws ParseException {
        Date date=new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(a);
        Date date2=new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(b);

        long diffMin=(date2.getTime()-date.getTime())/60000;

        return diffMin;
    }

    public static long toMin(String s){
        String [] a=s.split("/");
        long sum=0;
        sum+=Integer.parseInt(a[0])*1440;

        a=a[1].split(":");
        sum+=Integer.parseInt(a[0])*60;
        sum+=Integer.parseInt(a[1]);

        return sum;
    }
}
