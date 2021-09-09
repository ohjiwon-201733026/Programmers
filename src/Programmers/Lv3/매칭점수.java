package Programmers.Lv3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class 매칭점수 {
    public static void main(String [] args){
        String word="Muzi";
        String [] pages={
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"
        };
        System.out.println(solution(word,pages));
    }
    public static int solution(String word, String [] pages){
        HashMap<String, Double> basicScore = new HashMap<String, Double>();                //기본 점수
        HashMap<String, Double> linkScore = new HashMap<String, Double>();                //링크 점수
        ArrayList<String> names = new ArrayList<String>();                                //페이지 순서
        int answer = 0;                                                                    //최소 인덱스
        word = word.toLowerCase();                                                        //키워드 소문자 만들기

        for(int i = 0; i < pages.length; i++) {
            pages[i] = pages[i].toLowerCase();            //전부 소문자 만들기
        }

        for(int i = 0; i < pages.length; i++) {            //링크 점수 만들기
            int basic = 0;                                //기본점수
            int outlinkCount = 0;                        //외부 개수
            int hit = 0;                                //키워드 매칭
            ArrayList<String> links = new ArrayList<String>();
            String pName = "";
            //자기 사이트 이름 구하기
            Pattern pageName = Pattern.compile("<meta property=\"og:url\" content=\\S+/>");
            Matcher pageNameMatcher = pageName.matcher(pages[i].split("</head>")[0]);
            if(pageNameMatcher.find()) {
                pName = pageNameMatcher.group();                                                    //content="https://a.com"/>
            }
            pName = pName.substring(32);                                                            //"https://a.com"/>
            pName = pName.substring(0,pName.length()-2);                                            //"https://a.com"
            names.add(pName);

            //hashMap
            String temp = pages[i];
            temp = temp.split("<body>")[1].replaceAll("[0-9]", " ");

            Pattern pattern = Pattern.compile("\\b"+word+"\\b");
            Matcher    matcher = pattern.matcher(temp);
            while(matcher.find()) {
                matcher.group();
                hit++;
            }
            basic = hit;                                        //현재 페이지 기본점수
            basicScore.put(pName, (double)basic);                //기본 점수 구함

            // 연결된 링크 이름 구하고, 그 개수만큼 그 링크에 링크점수 던지기
            temp = pages[i];
            temp = temp.split("<body>")[1];                        //바디 부분만 외부링크 확인
            Pattern linkPattern = Pattern.compile("<a href=\\S+>");
            Matcher linkMatcher = linkPattern.matcher(temp);

            while(linkMatcher.find()) {
                String tempGroup = linkMatcher.group();                            //<a href="https://b.com">\
                tempGroup = tempGroup.substring(8);
                tempGroup = tempGroup.substring(0, tempGroup.length() -1);
                if(tempGroup.charAt(tempGroup.length()-1) == 'a') {
                    tempGroup = tempGroup.substring(0, tempGroup.length()-4);
                }
                System.out.println(tempGroup);                                    //"https://b.com"

                links.add(tempGroup);
            }
            outlinkCount = links.size();
            for(int j = 0; j < links.size(); j++) {
                linkScore.put(links.get(j), linkScore.getOrDefault(links.get(j), 0.0) + ((double)basic / outlinkCount));
            }

        }

        //기본 점수 + 링크 점수
        Iterator<String> iter = basicScore.keySet().iterator();
        HashMap<String, Double> result = new HashMap<String, Double>();
        double maxV = 0;
        while(iter.hasNext()) {
            Double value = 0.0;
            String page = iter.next();
            if(linkScore.containsKey(page)) {
                value = linkScore.get(page);
            }
            if(basicScore.containsKey(page)) {
                value += basicScore.get(page);
            }
            result.put(page,value);

            if(value > maxV) {
                maxV = value;
            }
        }
        for(int i = 0; i < names.size(); i++) {                    //가장 큰 값 중 가장 빠른 값 찾기
            if(result.get(names.get(i)) == maxV) {
                answer =  i;
                break;
            }
        }

        return answer;


    }
}
