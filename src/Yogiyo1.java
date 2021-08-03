import java.util.HashMap;
import java.util.Locale;

public class Yogiyo1 {

    public static void main(String[] args) {
        String S="John Doe; John A Doe; John B Doe; John Doe; John Evan Doe; Jane Doe; John Doe";
        String C="Example";

        String answer=solution(S,C);
        System.out.println(answer);
    }

    private static String solution(String S, String C) {
        String [] names=S.split("; ");
        StringBuilder answer=new StringBuilder();
        HashMap<String,Integer> map=new HashMap<>();

        for(int i=0;i< names.length;++i){
            StringBuilder tmp=new StringBuilder();
            String lower_name=names[i].toLowerCase();
            String [] nameArr=lower_name.split(" ");
            tmp.append(nameArr[0]);
            String lastName=nameArr[nameArr.length - 1].replaceAll("-", "");
            if(nameArr[nameArr.length-1].length()>8) {
                lastName = lastName.substring(0, 8);
            }

            tmp.append("." + lastName + "@");
            tmp.append(C.toLowerCase() + ".com");

            if(map.containsKey(tmp.toString())){
                String s=tmp.toString();
                int n=map.get(tmp.toString());
                tmp=new StringBuilder();
                n++;
                tmp.append(nameArr[0]+"."+lastName+n+"@"+C.toLowerCase()+".com");
                map.put(s,n);
            }
            else{
                map.put(tmp.toString(),1);
            }
            if(i== names.length-1) answer.append(tmp);
            else answer.append(tmp+"; ");


        }
        return answer.toString();
    }
}
