package BaekJoon.Implementation;


import java.util.*;

public class B2304 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            ArrayList<int[]> list = new ArrayList<>();
            int max=0;
            while (N-- > 0) {
                int l = sc.nextInt();
                int h = sc.nextInt();
                list.add(new int[]{l, h});
                max=Math.max(max,h);
            }

            Collections.sort(list,(o1,o2)->o1[0]-o2[0]);
            System.out.println(max);
            int l1=list.get(0)[0];
            int h1=list.get(0)[1];
            int answer=0;
            for (int[] p : list) {
                int l=p[0];
                int h=p[1];

                if(h==max){
                    answer+=(l-l1)*h1;
                    l1=l;
                    h1=h;
                    break;
                }

                if(h>h1){
                    answer+=(l-l1)*h1;
                    l1=l;
                    h1=h;
                }
            }

            Collections.sort(list,(o1,o2)->o2[0]-o1[0]);
            int l2=list.get(0)[0];
            int h2=list.get(0)[1];
            for (int[] p : list) {
                int l=p[0];
                int h=p[1];

                if(h==h1){
                    answer+=(l2-l)*h2;
                    l2=l;
                    h2=h;
                    break;
                }

                if(h>h2){
                    answer+=(l2-l)*h2;
                    l2=l;
                    h2=h;
                }
            }
            answer+=max*(l2-l1+1);
            System.out.println(answer);
        }

}
