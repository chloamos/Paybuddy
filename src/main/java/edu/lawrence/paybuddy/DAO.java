package edu.lawrence.paybuddy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Joe Gregg
 */
public class DAO {
    public DAO() {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");

            // Establish a connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/paybuddy?user=student&password=Cmsc250!");

            acctQueryStmt = connection.prepareStatement(acctQuery);
            acctUpdateStmt = connection.prepareStatement(acctUpdate);
            transactionInsertStmt = connection.prepareStatement(transactionInsert);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private String acctQuery = "select balance from accounts where id=?";
    private PreparedStatement acctQueryStmt;
    
    public Account findAccount(int id) {
        Account result = null;
        try {
            acctQueryStmt.setInt(1,id);
            ResultSet rset = acctQueryStmt.executeQuery();
            if(rset.next()) {
                result = new Account();
                result.setId(id);
                result.setBalance(rset.getInt(1));
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    private String acctUpdate = "update accounts set balance=? where id=?";
    private PreparedStatement acctUpdateStmt;
    
    public void saveAccount(Account acct) {
        try {
            acctUpdateStmt.setInt(1,acct.getBalance());
            acctUpdateStmt.setInt(2, acct.getId());
            acctUpdateStmt.execute();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private String transactionInsert = "insert into transactions(fromAcct,toAcct,amount) values(?,?,?)";
    private PreparedStatement transactionInsertStmt;

    public void saveTransaction(Transaction t) {
        try {
            transactionInsertStmt.setInt(1,t.getFromAcct());
            transactionInsertStmt.setInt(2, t.getToAcct());
            transactionInsertStmt.setInt(3, t.getAmount());
            transactionInsertStmt.execute();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}
