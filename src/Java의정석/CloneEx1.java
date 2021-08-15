package Java의정석;

public class CloneEx1 {

    public static void main(String args[]){
        Point original=new Point(3,3);
        Point copy=(original.clone());
        System.out.println(original);
        System.out.println(copy);
    }

    public static class Point implements Cloneable{ // Cloneable 인터페이스 구현한 클래스에서만 clone 사용 가능
        int x;
        int y;

        Point(int x, int y){
            this.x=x;
            this.y=y;
        }

        public String toString(){
            return "x="+x+", y="+y;
        }

        public Point clone(){
            Object obj=null;

            try{
                obj=super.clone(); // clone은 반드시 예외처리 !!
            }catch (CloneNotSupportedException e){};
            return (Point)obj;
        }
    }
}
