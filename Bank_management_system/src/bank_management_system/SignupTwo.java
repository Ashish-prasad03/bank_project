package bank_management_system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener{
    
   
    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, occupation, income, qualification;
    String formno;

    
    SignupTwo(String formno){
        this.formno = formno;
        
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
       
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 28));
        additionalDetails.setBounds(270, 80, 400, 30);
        add(additionalDetails);
        
        JLabel name = new JLabel("Religion :");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Others"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
        JLabel fname = new JLabel("Category : ");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        String valCategory[] = {"General", "SC", "ST", "OBC", "Others"};
        category = new JComboBox(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);
        
        
        JLabel dob = new JLabel("Income :");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        String valIncome[] = {"Null", "<1,50,000", "<2,50,000", "<5,00,000", "<10,00,000 "};
        income = new JComboBox(valIncome);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
        
          
      
        JLabel gender = new JLabel("Educational :");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
       
        
     
        
         JLabel email = new JLabel("Qualification :");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 315, 200, 30);
        add(email);
        
        String educationValues[] = {"Non-Graduation", "Graduate", "Post-Graduate", "Doctrate", "Others"};
        qualification = new JComboBox(educationValues);
        qualification.setBounds(300, 315, 400, 30);
        qualification.setBackground(Color.WHITE);
        add(qualification);
        
        
         JLabel marital = new JLabel("Occupation :");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);
        
        String occupationValue[] = {"Self-Employed", "Bussiness", "Student", "Retired", "Others"};
        occupation = new JComboBox(occupationValue);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        
      
        
        
        JLabel address = new JLabel("PAN Number :");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);
        
        
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);
        
        
        JLabel city = new JLabel("Aadhar Number :");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);
        
        
         JLabel state = new JLabel("Senior Citizen :");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);
        
        syes = new JRadioButton("YES");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.GRAY);
        add(syes);
        
        sno = new JRadioButton("NO");
        sno.setBounds(300, 540, 100, 30);
        sno.setBackground(Color.GRAY);
        add(sno);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);
        
     
         JLabel pincode= new JLabel("Existing Account :");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);
        
        eyes = new JRadioButton("YES");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.GRAY);
        add(eyes);
        
        eno = new JRadioButton("NO");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.GRAY);
        add(eno);
        
        ButtonGroup emaritalgroup = new ButtonGroup();
        emaritalgroup.add(eyes);
        emaritalgroup.add(eno);
        
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.YELLOW);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
         
        
        
        getContentPane().setBackground(Color.gray);
        
        
        
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
   
    }
    
    public void actionPerformed(ActionEvent ae){
       
        String sreligion = (String) religion.getSelectedItem();//set text
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String squalification = (String) qualification.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        
        String seniorcitizen = null;
        if(syes.isSelected()) {
            seniorcitizen = "Yes";
        }
        else if(sno.isSelected()) {
        seniorcitizen = "No";
    }
        
        
        String existingaccount = null;
        if(eyes.isSelected()){
         existingaccount = "Yes";
        }
        else if(eno.isSelected()){
         existingaccount = "No";
        }
        
        
        
        String span = pan.getText();
        String saadhar = aadhar.getText();
        
        
        
        
        try{
           
                conn c = new conn();
                String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+squalification+"', '"+soccupation+"', '"+span+"', '"+saadhar+"', '"+seniorcitizen+"', '"+existingaccount+"')";
                c.s.executeUpdate(query);
        
        
        //signup object
        setVisible(false);
        new SignupThree(formno).setVisible(true);
        
        
        }catch (Exception e){
            System.out.println(e);
        }
        
    } 
    public static void main(String args[]){
        
        new SignupTwo("");
    }
        
}


    

