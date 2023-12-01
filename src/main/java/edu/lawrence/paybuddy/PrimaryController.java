package edu.lawrence.paybuddy;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable {

    @FXML
    private TextField fromAcct;
    @FXML
    private TextField toAcct;
    @FXML
    private TextField amt;
    @FXML
    private Label msg;
    
    @FXML
    private void handleTransfer() throws IOException {
        int fromAcct = Integer.parseInt(this.fromAcct.getText());
        int toAcct = Integer.parseInt(this.toAcct.getText());
        int amount = Integer.parseInt(this.amt.getText());
        
        Account from = dao.findAccount(fromAcct);
        Account to = dao.findAccount(toAcct);
        
        if(from == null)
            msg.setText("Invalid from account");
        else if(to == null)
            msg.setText("Invalid to account");
        else if(from.getBalance() < amount) {
            msg.setText("Insufficient funds");
        } else {
            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);
            dao.saveAccount(from);
            dao.saveAccount(to);
            Transaction t = new Transaction(fromAcct,toAcct,amount);
            dao.saveTransaction(t);
            msg.setText("Transfer successful");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dao = new DAO();
    }
    
    private DAO dao;
}
