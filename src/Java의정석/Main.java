package Java의정석;

public class Main {
    public static void main(String[] args) {
        int one=Test.ONE;
        String two=Test.TWO;
        int one_sum_two=Test.sum(1,2);

        Test test=new Test(3);
        int three=test.getThree();
        int two_multiply_three=test.multiply(2,3);

        System.out.println("one = " + one);
        System.out.println("two = " + two);
        System.out.println("one_sum_two = " + one_sum_two);
        System.out.println("three = " + three);
        System.out.println("two_multiply_three = " + two_multiply_three);
        System.out.println("FOUR = " + Test.FOUR);
        System.out.println("FIVE = " + Test.FIVE);

    }
}
