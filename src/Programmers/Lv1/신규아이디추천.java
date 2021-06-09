package Programmers.Lv1;

public class 신규아이디추천 {

    public static void main(String[] args) {
        String new_id="abcdefghijklmn.p";
        String answer=solution(new_id);
        System.out.println(answer);

    }

    private static String solution(String new_id) {
        // 1. 대문자 -> 소문자
        new_id=new_id.toLowerCase();
        System.out.println("1 "+new_id);
        // 2. 제외 문자 빼기
        new_id=second(new_id);
        System.out.println("2 "+new_id);
        //3. 마침표 2개이상 -> 1개로 치환
        new_id=third(new_id);
        System.out.println("3 "+new_id);
        //4. 마침표 처음,끝이면 제거
        new_id=fourth(new_id);
        System.out.println("4 "+new_id);
        //5. 빈문자열이면 a 대입
        new_id=fifth(new_id);
        System.out.println("5 "+new_id);
        //6. 길이 16자 이상이면 첫 15자 제외 모두 제거
        new_id=sixth(new_id);
        System.out.println("6 "+new_id);
        //7. 길이 2자 이하면 마지막 문자 반복해서 3자 채움
        new_id=seventh(new_id);
        System.out.println("7 "+new_id);

        return new_id;
    }

    private static String second(String new_id) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<new_id.length();++i){
            char c=new_id.charAt(i);

            if(('a'<=c && c<='z') || 0<=c-'0' && (int)c-'0'<=9 || c=='-' || c=='_' || c=='.'){
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static String third(String new_id) {
        StringBuilder sb=new StringBuilder();
        boolean flag=false;
        for(int i=0;i<new_id.length();++i){
            char c=new_id.charAt(i);
            if(c=='.') {
                flag=true;
            }
            else {
                if(flag) {
                    sb.append(".");
                    flag=false;
                }
                sb.append(c);
            }
        }
        if(new_id.equals(".")) return ".";
        return sb.toString();
    }

    private static String fourth(String new_id) {
        if(new_id.equals("")) return new_id;
        if(new_id.charAt(0)=='.') {
            if(new_id.length()==1) return new_id="";
            else new_id=new_id.substring(1);
        }
        if(new_id.charAt(new_id.length()-1)=='.') {
            new_id=new_id.substring(0,new_id.length()-1);
        }
        return new_id;
    }

    private static String fifth(String new_id) {
        if(new_id.length()==0) new_id="a";

        return new_id;
    }

    private static String sixth(String new_id) {
        if(new_id.length()>=16) {
            new_id = new_id.substring(0,15);
            System.out.println(new_id);
            new_id = fourth(new_id);
        }

        return new_id;
    }

    private static String seventh(String new_id) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<new_id.length();++i){
            sb.append(new_id.charAt(i));
        }
        while(new_id.length()<=2){
            sb.append(new_id.charAt(new_id.length()-1));
            new_id=sb.toString();
        }

        return new_id;
    }




}
