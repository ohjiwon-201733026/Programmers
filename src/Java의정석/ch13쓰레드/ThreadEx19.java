package Java의정석.ch13쓰레드;

public class ThreadEx19 {
    static long startTime=0;

    public static void main(String[] args) { 
        ThreadEx19_1 th1=new ThreadEx19_1();
        ThreadEx19_2 th2=new ThreadEx19_2();
        th1.start();
        th2.start();

        startTime=System.currentTimeMillis();

        try{
            th1.join(); // 메인쓰레드 대기, th1 실행
            th2.join(); // 메인쓰레드 대기, th2 실행
        }catch (InterruptedException e){}

        System.out.println("소요시간 : "+(System.currentTimeMillis()-startTime));
    }

    static class ThreadEx19_1 extends Thread{
        public void run(){
            for(int i=0;i<300;++i){
                System.out.print(new String("-"));
            }
        }
    }

    static class ThreadEx19_2 extends Thread{
        public void run(){
            for(int i=0;i<300;++i){
                System.out.print(new String("|"));
            }
        }
    }
}
