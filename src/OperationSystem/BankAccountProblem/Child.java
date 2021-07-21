package OperationSystem.BankAccountProblem;

public class Child extends Thread{
    BankAccount b;
    Child(BankAccount b){
        this.b=b;
    }

    public void run(){
        for(int i=0;i<1000000;++i){
            b.withdraw(1000);
        }
    }
}
