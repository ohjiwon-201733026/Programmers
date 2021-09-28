package Java의정석.ch13쓰레드;

public class ThreadEx1{
    public static void main(String[] args) {
        ThreadEx1_1 t1=new ThreadEx1_1();
        Runnable r=new ThreadEx1_2();

        Thread t2=new Thread(r);
        t1.start();
        t2.start();
    }

    static class ThreadEx1_1 extends Thread{
        public void run(){
            System.out.println("ThreadEX1_1");
            for(int i=0;i<5;++i){
                System.out.println(getName());
            }
        }
    }

    static class ThreadEx1_2 implements Runnable{

        @Override
        public void run() {
            System.out.println("ThreadEx1_2");
            for(int i=0;i<5;++i){
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}
