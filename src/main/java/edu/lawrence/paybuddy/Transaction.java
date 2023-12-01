package edu.lawrence.paybuddy;

/**
 *
 * @author Joe Gregg
 */
public class Transaction {
    private int fromAcct;
    private int toAcct;
    private int amount;
    
    public Transaction(int fromAcct,int toAcct,int amount) {
        this.fromAcct = fromAcct;
        this.toAcct = toAcct;
        this.amount = amount;
    }
    
    public int getFromAcct() { return fromAcct; }
    public int getToAcct() { return toAcct; }
    public int getAmount() { return amount; }
}
