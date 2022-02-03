package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class 다단계칫솔판매 {
    @Test
    public void test(){
        int [] result={360, 958, 108, 0, 450, 18, 180, 1080};
        int [] answer=solution(new String []{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}
        ,new String []{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String []{"young", "john", "tod", "emily", "mary"},
                new int []{12, 4, 2, 5, 10});

        for(int i=0;i<result.length;++i){
            Assertions.assertEquals(result[i],answer[i]);
        }
    }
    static HashMap<String, ArrayList<String>> refer=new HashMap<>();
    static HashMap<String,Integer> sum=new HashMap<>();
    public int [] solution(String [] enroll, String [] referral, String [] seller, int [] amount) {

        for(int i=0;i<enroll.length;++i){
            String referName=referral[i];
            ArrayList<String> tmp=new ArrayList<>();
            tmp.add(referName);
            if(refer.containsKey(referName)) tmp.addAll(refer.get(referName));
            refer.put(enroll[i],tmp);
            sum.put(enroll[i],0);
        }
        sum.put("-",0);

        for(int i=0;i<seller.length;++i){
            ArrayList<String> referArr=refer.get(seller[i]);
            int cost=amount[i]*100;

            String sell=seller[i];
            if(cost-cost*0.1>0){
                sum.put(sell,sum.get(sell)+(cost-(int)(cost*0.1)));
                cost=(int)(cost*0.1);
            }
            else {
                sum.put(sell,sum.get(sell)+cost);
                continue;
            }

            for(int j=0;j<referArr.size();++j){
                if(cost-cost*0.1>0){
                    if(referArr.get(j).equals("-")){
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
        for(int i=0;i<answer.length;++i){
            String name=enroll[i];
            int val=sum.get(name);
            answer[i]=val;
        }
        return answer;
    }
}
