// 기사 검색 b
package Programmers.Kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kakao2020_4b {

	private static Map<Integer,List<String>> split(String [] words){
		Map<Integer,List<String>> spl=new HashMap<>();

		for(String word:words) {
			int key=word.length();
			List<String> list=spl.get(key);
			if(list==null) {
				list=new ArrayList<String>();
				spl.put(key,list);
			}
			list.add(word);

		}
		 return spl;

	}

	private static int [] solution(String [] words, String [] queries) {
		int [] answer=new int [queries.length];
		Map<Integer,List<String>> map=split(words);

		for(int i=0;i<queries.length;++i) {
			String query=queries[i];
			int count=0,start,end,length=query.length();

			for(start=0;start<length&&query.charAt(start)=='?';++start);
			for(end=start;end<length&&query.charAt(end)!='?';++end);

			query=query.substring(start,end);
			List<String> list=map.get(length);

			if(list!=null) {
				for(String s:list)
					if(query.equals(s.substring(start,end))) ++count;
				answer[i]=count;
			}

		}

		return answer;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = { "frodo", "front", "frost", "frozen", "frame", "kakao" };
		String[] queries = { "fro??", "????o", "fr???", "fro???", "pro?", "?????" };
		int [] answer=solution(words,queries);
		for(int a:answer) System.out.println(a);
	}

}
