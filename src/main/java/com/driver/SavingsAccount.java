package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public SavingsAccount(double rate, double maxWithdrawalLimit) {
        this.rate = rate;
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    
    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name, balance, 0);
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.rate = rate;
    }

    public SavingsAccount(String name, double balance, double minBalance, double rate, double maxWithdrawalLimit) {
        super(name, balance, minBalance);
        this.rate = rate;
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    @Override
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if(amount>maxWithdrawalLimit){
            throw new Exception("Maximum Withdraw Limit Exceeded");
        }
        else if(amount>this.getBalance()){
            throw new Exception("Insufficient Balance");
        }
        else this.setBalance(this.getBalance()-amount);

    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        // SI = (P*N*R)/100;
        return ((this.getBalance() * years * this.rate) / 100) + this.getBalance();

    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        // CI = P(1+1/R)^n - P;

        return (this.getBalance()*Math.pow((1 + this.rate/100),times*years));

    }

}
