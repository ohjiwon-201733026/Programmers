package Java의정석.ch13쓰레드;

public class ThreadEx2 {
    public static void main(String[] args) {
        ThreadEx2_1 t1=new ThreadEx2_1();
        t1.start();
    }

    static class ThreadEx2_1 extends Thread{
        public void run(){
            throwException();
        }

        private void throwException() {
            try{
                throw new Exception();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
