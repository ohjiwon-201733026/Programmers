package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 매칭점수 {

    @Test
    public void test(){
//        Assertions.assertEquals(0,solution("blind"
//                ,new String[]{"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"}));
        Assertions.assertEquals(1,solution("Muzi",new String []{"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"}));
    }

    class Link{
        String url;
        int basic;
        ArrayList<String> links;
        int idx;
        double linkScore,extLinkScore; // 링크 점수, 외부링크수 총합
        double matchingScore;

        public void setLinkScore(){
            linkScore=(double) basic/links.size();
        }

        public void setExtLinkScore(){
            for (String link : links) {
                map.get(link).extLinkScore+=this.linkScore;
            }
        }

        public void setMatchingScore(){
            this.matchingScore=basic+extLinkScore;
        }


        public Link(String url, int idx){
            this.url=url;
            this.idx=idx;
        }

        @Override
        public String toString() {
            return "Link{" +
                    "url='" + url + '\'' +
                    ", basic=" + basic +
                    ", links=" + links +
                    ", idx=" + idx +
                    ", linkScore=" + linkScore +
                    ", extLinkScore=" + extLinkScore +
                    ", matchingScore=" + matchingScore +
                    '}';
        }
    }
    HashMap<String,Link> map;
    public int solution(String word, String[] pages) {
        word = word.toLowerCase();
        map = new HashMap<>();

        Pattern basicPattern = Pattern.compile("<meta property=\"og:url\" content=\"(\\S*)\"/>");
        Pattern linkPattern = Pattern.compile("<a href=\"(\\S*)\">");
        Pattern wordPattern=Pattern.compile("\\b(?i)"+word+"\\b");

        for(int i=0;i<pages.length;++i){
            String page=(pages[i]=pages[i].toLowerCase());
            Matcher basicMatcher=basicPattern.matcher(page);

            // home url
            String homeUrl = null; // url
            if(basicMatcher.find()){
                homeUrl=basicMatcher.group().split("\"")[3];
            }

            System.out.println(homeUrl);

            Link link=new Link(homeUrl,i);

            // 외부 링크
            ArrayList<String> extUrl=new ArrayList<>();
            Matcher extMatcher=linkPattern.matcher(page);
            while (extMatcher.find()){
                extUrl.add(extMatcher.group().split("\"")[1]);
            }

            link.links=extUrl;

            // 기본점수 (word 찾기)
            page=page.split("<body>")[1].split("</body>")[0];
            page=page.replaceAll("[0-9]"," ");
            Matcher wordMatcher=wordPattern.matcher(page);
            int hit=0;
            while(wordMatcher.find()){
                hit++;
            }

            link.basic=hit;
            link.setLinkScore();

            map.put(homeUrl,link);
        }

        for (String s : map.keySet()) {
            System.out.println(s+" "+map.get(s).toString());
        }

        for (String s : map.keySet()) {
            map.get(s).setExtLinkScore();
        }
        for (String s : map.keySet()) {
            map.get(s).setMatchingScore();
        }
        int idx=0;
        double maxScore=0;
        for (String s : map.keySet()) {
            Link tmp=map.get(s);
            if(tmp.matchingScore>maxScore) {
                maxScore=tmp.matchingScore;
                idx=tmp.idx;
            }
            else if(tmp.matchingScore==maxScore){
                if(tmp.idx<idx){
                    maxScore=tmp.matchingScore;
                    idx=tmp.idx;
                }
            }
        }

        for (String page : map.keySet()) {
            System.out.println(map.get(page).toString());
        }

        return idx;

    }


}
