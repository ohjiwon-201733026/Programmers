package Java의정석.ch13쓰레드;

public class ThreadEx3 {

    public static void main(String[] args) {
        ThreadEx3_1 t=new ThreadEx3_1();
        t.run();
    }

    static class ThreadEx3_1{
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
