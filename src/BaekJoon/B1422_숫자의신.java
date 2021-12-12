package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1422_숫자의신 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,K;
    static int max;
    static String [] numList;
    static String answer="";

    public static void main(String[] args) throws IOException {
        setData();
        getMaxValue();
        System.out.println(answer);
    }

    public static void setData() throws IOException {
        st=new StringTokenizer(br.readLine());
        K=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        numList=new String[K];
        for(int i=0;i<K;++i){
            String sv=br.readLine();
            int value=Integer.parseInt(sv);

            if(max<value) max=value;
            numList[i]=sv;
        }

        Arrays.sort(numList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String o=o1+o2;
                return -o.compareTo(o2+o1);
            }
        });
    }

    private static void getMaxValue(){
        boolean flag=false;
        for(int i=0;i<K;++i){
            answer+=numList[i];
            if(max==Integer.parseInt(numList[i]) && flag==false){
                flag=true;
                for(int j=0;j<N-K;++j){
                    answer+=numList[i];
                }
            }
        }
    }
}

