package Programmers.Lv3.notKakao;

import java.util.ArrayList;
import java.util.HashMap;

public class 다단계칫솔판매 {
    public static void main(String[] args) {
        String [] enroll={"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String [] referral={"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String [] seller={"sam", "emily", "jaimie", "edward"};
        int [] amount={2, 3, 5, 4};
        int [] result=solution(enroll,referral,seller,amount);
        for(int n:result) System.out.println(n);
    }
    static HashMap<String, ArrayList<String>> refer=new HashMap<>();
    static HashMap<String,Integer> sum=new HashMap<>();
    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        for(int i=0;i< enroll.length;++i){
            String referName=referral[i];
            ArrayList<String> tmp=new ArrayList<>();
            tmp.add(referName);
            if(refer.containsKey(referName)) tmp.addAll(refer.get(referName));
            refer.put(enroll[i],tmp);
            sum.put(enroll[i],0);
        }
        sum.put("-",0); // center 넣어주기

        for(int i=0;i< seller.length;++i){
            ArrayList<String> referArr=refer.get(seller[i]);
            int cost=amount[i]*100;

            String sell=seller[i]; // 판사람
            if(cost-cost*0.1>0) {
                sum.put(sell,sum.get(sell)+(cost-(int)(cost*0.1)));
                cost=(int)(cost*0.1);
            }
            else {
                sum.put(sell,sum.get(sell)+cost);
                continue;
            }
            // 추천인
            for(int j=0;j<referArr.size();++j){ // edward, marry, -
                if(cost-cost*0.1>0) {
                    if(referArr.get(j).equals("-")) {
                        sum.put(referArr.get(j),sum.get(referArr.get(j))+cost);
                        break;
                    }
                    else{
                        sum.put(referArr.get(j),sum.get(referArr.get(j))+(cost-(int)(cost*0.1)));
                        cost=(int)(cost*0.1);
                    }

                }
                else{
                    sum.put(referArr.get(j),sum.get(referArr.get(j))+cost);
                    break;
                }
            }
        }

        int [] answer=new int [enroll.length];
        for(int i=0;i< answer.length;++i){
            String name=enroll[i];
            int val=sum.get(name);
            answer[i]=val;
        }

        return answer;
    }
}
