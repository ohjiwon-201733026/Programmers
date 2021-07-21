package OperationSystem.BankAccountProblem;

public class Parent extends Thread{
    BankAccount b;
    Parent(BankAccount b){
        this.b=b;
    }
    public void run(){
        for(int i=0;i<1000000;++i){
            b.deposit(1000);
        }
    }
}
