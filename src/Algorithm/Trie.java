package Algorithm;

import java.util.Arrays;

public class Trie {

	public static class Solution {
		static class Node{
		int count;
		Node[] nodes;

		public void add(String word, int index) {
			++count; // 이 노드를 거치면 +1
			if(index==word.length()) return; // index가 범위 밖으로 나갔을 때
			if(nodes==null) nodes=new Node[26]; // 알파벳 숫자만큼 자식 node 새로 생성
			int c=word.charAt(index)-'a'; // node의 인덱스, 'a'이면 0 'b'이면 1 ...


			if(nodes[c]==null) // 자식 노드가 없으면
				nodes[c]=new Node();
			nodes[c].add(word, index+1); // 다음 글자 트리에 추가


			}

		public int count(String query, int index) {
			if(nodes==null) return count;  // 리프노드에 온경우 count 리턴
			char ch=query.charAt(index);
			if(ch=='?') return count;  // '?' 만나면 count 멈춤
			Node node=nodes[ch-'a'];
			if(node ==null) return 0; // 자식노드가 없는 경우( 단어가 끝난 경우 )
			return node.count(query,index+1); // 쿼리의 다음 글자 보기
			}
		}

		static Node [] roots1=new Node[10000], roots2=new Node[10000]; // roots1은 정방향, roots2는 역방향
																		// 단어 길이마다 트리 만들기(최대길이 10000 )

		String reverse(String s) { // string 뒤집기
			return new StringBuilder(s).reverse().toString();
		}

		void createTree(String [] words) { // 트리만들기
			for(String word: words) { // words 배열에서 하나하나
				int i=word.length()-1; // 단어 길이로 저장하기
				if(roots1[i]==null) roots1[i]=new Node(); // 정방향
				if(roots2[i]==null) roots2[i]=new Node(); // 역방향

				roots1[i].add(word, 0); // 트리에 추가
				roots2[i].add(reverse(word), 0); // 역방향 트리에 추가
			}
		}


		public int[] solution(String[] words, String[] queries) {
			// TODO Auto-generated method stub
			int [] answer=new int[queries.length]; // 답 적을 배열
			createTree(words); // 트리 만들고
			for (int i = 0; i < queries.length; ++i) { // 쿼리에 패턴들 하나하나씩
				String query = queries[i];
				int j = query.length() - 1; // 쿼리 패턴의 길이-> 길이별로 나눠놨으므로
				if (roots1[j] == null) // 같은 길이의 word 없는 경우
					continue; // 다음 쿼리로!이떄 answer값은 0
				if (query.charAt(0) != '?') // 쿼리 맨앞 부터 '?'이면 역방향으로 바꾸기
					answer[i] = roots1[j].count(query, 0);
				else
					answer[i] = roots2[j].count(reverse(query), 0);
			}
			return answer;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = { "frodo", "front", "frost", "frozen", "frame", "kakao" };
		String[] queries = { "fro??", "????o", "fr???", "fro???", "pro?", "?????" };
		System.out.println(Arrays.toString(new Solution().solution(words, queries)));
	}

}
