// 기사 검색 a
package Programmers.Kakao;

public class Kakao2020_4a {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      String [] words= {"frodo", "front", "frost", "frozen", "frame", "kakao"};
      String [] queries= {"fro??", "????o", "fr???", "fro???", "pro?", "?????"};
      int [] ans=solution(words,queries);
      for(int a:ans) System.out.println(a);


   }

   private static int[] solution(String[] words,String[] queries) {
      // TODO Auto-generated method stub
      int [] result = new int[queries.length];

      for(int i=0;i<queries.length;++i) {
         String query=queries[i];

         int start,end,count=0,length=query.length();
         for(start=0;start<length&&query.charAt(start)=='?';++start);
         for(end=start;end<length&&query.charAt(end)!='?';++end);

         query=query.substring(start,end);
         for(String word:words) {
            if(word.length()!=length) continue;
            if(query.equals(word.substring(start,end))) ++count;
         }
         result[i]=count;


      }
      return result;
   }

}