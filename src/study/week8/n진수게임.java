package study.week8;

public class n진수게임 {

    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<=t*m;++i){
            String s=toN(n,i);
            sb.append(s);
        }

        String order=sb.toString();
        for(int a=0;a<t;++a){
            answer+=order.charAt(a*m+p-1);
        }

        return answer;
    }

    public static String toN(int n,int i){
        String re="";
        while(i>0){
            String mod=i%n+"";
            if(n==16){
                if(mod.equals("10")) mod="A";
                if(mod.equals("11")) mod="B";
                if(mod.equals("12")) mod="C";
                if(mod.equals("13")) mod="D";
                if(mod.equals("14")) mod="E";
                if(mod.equals("15")) mod="F";
            }
            re=mod+""+re;
            i=i/n;
        }
        if(re.length()==0) return "0";
        return re;

    }
}
