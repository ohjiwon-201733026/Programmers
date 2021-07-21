package OperationSystem.BankAccountProblem;


public class BankAccount {

    int balance;
    void deposit(int amount){
        this.balance+=amount;
        System.out.print("+");
    }
    void withdraw(int amount){
        this.balance-=amount;
        System.out.print("-");
    }
    int getBalance(){
        return this.balance;
    }
}
