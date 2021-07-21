package Programmers.Lv2;


import java.util.HashSet;

public class 전화번호목록 {

    public static void main(String[] args) {
        String [] phone_book={"12","123","1235","567","88"};

        System.out.println(solution(phone_book));
    }

    public static boolean solution(String [] phone_book){

        HashSet<String> set=new HashSet<>();
        for(int i=0;i< phone_book.length;++i) set.add(phone_book[i]);

        for(int i=0;i< phone_book.length;++i){ //1000000
            for(int j=0;j< phone_book[i].length();++j){ //20
                if(set.contains(phone_book[i].substring(0,j))) return false;
            }
        }
        // 시간 복잡도
        // 1000000 + 1000000*20
        return true;
    }
}
