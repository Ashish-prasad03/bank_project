package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;



public class Fastcash extends JFrame implements ActionListener {
    
    JButton deposite, ministate, withdrawl, pinchange,fastcash, balanceenquiry, Back;
    
    String pinnumber;
      Fastcash(String pinnumber) {

        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 14));
        image.add(text);
        
        deposite = new JButton("Rs 100");
        deposite.setBounds(170, 415, 150, 30);
        deposite.addActionListener(this);
        image.add(deposite);
       
        withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(355, 415, 150, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
       
        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);
       
        ministate = new JButton("Rs 2000");
        ministate.setBounds(355, 450, 150, 30);
        ministate.addActionListener(this);
        image.add(ministate);
       
        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);
       
        balanceenquiry = new JButton("Rs 10000");
        balanceenquiry.setBounds(355, 485, 150, 30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
         
       Back = new JButton("Back");
       Back.setBounds(355,520 , 150, 30);
       Back.addActionListener(this);
        image.add(Back);
       
       
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
       if (ae.getSource() == Back){
         setVisible(false);
         new Transactions(pinnumber).setVisible(true);
         }
        else {
           String amount = ((JButton)ae.getSource()).getText().substring(3); //rs 500
           conn c = new conn();
           try{
               
               ResultSet rs = c.s.executeQuery("Select * from bank where pin = '"+pinnumber+"'");
               int balance = 0;
               while(rs.next()) {
                   if(rs.getString("type").equals("deposite")) {
                       balance += Integer.parseInt(rs.getString("amount"));
                       
               } else {
                       balance -= Integer.parseInt(rs.getString("amount"));
                   }
               }
               
               if(ae.getSource() != Back && balance < Integer.parseInt(amount)) {
                   JOptionPane.showMessageDialog(null, "Insufficient Balance");
                   return;
               }
            
               Date date = new Date();
               String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'withdrawl', '"+amount+"')";
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Rs "+ amount + " Debited Sucessfully");
              
               
               setVisible(false);
               new Transactions(pinnumber).setVisible(true);
           
           
           
           } catch (Exception e){
               System.out.println(e);
           }
         
       }
}
        
    
    
    
    public static void main(String args[]){
        
       new Fastcash("");
    }
    
}


    

