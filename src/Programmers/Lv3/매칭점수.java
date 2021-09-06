package Programmers.Lv3;

import java.util.ArrayList;
import java.util.HashMap;


public class 매칭점수 {
    public static void main(String [] args){
        String word="Muzi";
        String [] pages={
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"
        };
        System.out.println(solution(word,pages));
    }

    public static int solution(String word, String [] pages){
        word=word.toLowerCase();
        HashMap<String, Integer> page=new HashMap<>();
        // 웹페이지 HashMap에 저장
        for(int k=0;k<pages.length;++k){
            String p=pages[k];
            int i=p.indexOf("<meta",2);
            int j=p.indexOf("</head>");
            String s=p.substring(i,j);
            pages[k]=p.substring(j)
                    .replaceAll("</head>","")
                    .replaceAll("\\n<body>\\n","")
                    .replaceAll("\\n</body>\\n</html>","");
            String [] arr=s.split(" ");
            for(int x=0;x< arr.length;++x){
                if(arr[x].contains("content=")){
                    String [] tmp=arr[x].split("\"");
                   page.put(tmp[1].substring(8),k);
                };
            }
        }
        int [] 기본=new int [page.size()];
        int [] 외부=new int [page.size()];
        ArrayList<Integer> [] 링크=new ArrayList[page.size()];
        for(int i=0;i<page.size();++i) 링크[i]=new ArrayList<>();
        // a 태그
        for(int k=0;k<pages.length;++k) {
            String p = pages[k];
            int n=0;
            while(true){
                n=p.indexOf("<a href=");
                if(n==-1) break;
                int m=p.indexOf("</a>");
                String [] s=p.substring(n,m).split("\"");
                String key=s[1].substring(8);
                if(page.containsKey(key)) {
                    int i = page.get(key);
                    링크[i].add(k);
                }
                외부[k]++;
                p=p.substring(0,n)+p.substring(m+4);
            }
            pages[k]=p;
        }



        // 기본 점수
        for(int k=0;k<pages.length;++k){
            String p=pages[k];
            p=p.toLowerCase();
            String [] words=p.split("[^a-z]");
            for(String w:words){
                if(w.equals(word)) 기본[k]++;
            }
        }

        for(int i=0;i<pages.length;++i){
            System.out.println(i+" "+기본[i]+" "+외부[i]);
        }

        double max=0;
        double []링크점수=new double [기본.length];
        for(int i=0;i<기본.length;++i){
            ArrayList<Integer> l=링크[i];
            for(int j=0;j<l.size();++j){
                int n=l.get(j);
                링크점수[i]+=((double) 기본[n]/외부[n]);
            }
        }
        int idx=0;
        for(int i=0;i<링크점수.length;++i){
            double n=링크점수[i]+기본[i];
            if(max<n) {
                max=n;
                idx=i;
            }
        }

        return idx;
    }
}
