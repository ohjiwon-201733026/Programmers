import java.util.ArrayList;

public class Yogiyo2 {

    public static void main(String[] args) {
        String S="  root r-x delete-this.xls\n" +
                "  root r-- bug-report.pdf\n" +
                "  root r-- doc.xls\n" +
                "  root r-- podcast.flac\n" +
                " alice r-- system.xls\n" +
                "  root --x invoices.pdf\n" +
                " admin rwx SETUP.P";
        String answer=solution(S);
        System.out.println(answer);

    }

    private static String solution(String S) {
        String [] files=S.split("\n");
        ArrayList<Integer> fileLength=new ArrayList<>();
        String answer;

        for(String file : files){
            String owner=file.substring(0,6);
            String perm=file.substring(7,10);
            String name=file.substring(11);
            String ext=name.substring(name.length()-3, name.length());

            if(owner.contains("root") && (perm.equals("r--") || perm.equals("r-x"))
                    && (ext.equals("doc") || ext.equals("xls") || ext.equals("pdf"))){
                fileLength.add(name.length());
            }


        }

        int min=Integer.MAX_VALUE;
        for(int length:fileLength){
            if(min>length) min=length;
        }
        if(fileLength.size()==0) answer="NO FILES";


        return Integer.toString(min);
    }
}
